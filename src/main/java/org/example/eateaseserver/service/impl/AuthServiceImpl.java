package org.example.eateaseserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.AdminMapper;
import org.example.eateaseserver.mapper.MerchantMapper;
import org.example.eateaseserver.mapper.UserMapper;
import org.example.eateaseserver.pojo.dto.LoginRequest;
import org.example.eateaseserver.pojo.dto.RegisterRequest;
import org.example.eateaseserver.pojo.entity.Admin;
import org.example.eateaseserver.pojo.entity.Merchant;
import org.example.eateaseserver.pojo.entity.User;
import org.example.eateaseserver.pojo.vo.LoginVO;
import org.example.eateaseserver.service.AuthService;
import org.example.eateaseserver.service.MerchantService;
import org.example.eateaseserver.service.UserService;
import org.example.eateaseserver.util.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MerchantMapper merchantMapper;

    @Resource
    private AdminMapper adminMapper;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private UserService userService;

    @Resource
    private MerchantService merchantService;

    @Override
    public LoginVO login(LoginRequest request) {
        Long userId = null;
        String role = null;
        String inputPasswordMd5 = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());

        User user = userMapper.selectOne(
                new LambdaQueryWrapper<User>().eq(User::getUsername, request.getUsername()));
        if (user != null && inputPasswordMd5.equalsIgnoreCase(user.getPassword())) {
            userId = user.getId();
            role = "user";
        }

        if (role == null) {
            Merchant merchant = merchantMapper.selectOne(
                    new LambdaQueryWrapper<Merchant>().eq(Merchant::getUsername, request.getUsername()));
            if (merchant != null && inputPasswordMd5.equalsIgnoreCase(merchant.getPassword())) {
                userId = merchant.getId();
                role = "merchant";
            }
        }

        if (role == null) {
            Admin admin = adminMapper.selectOne(
                    new LambdaQueryWrapper<Admin>().eq(Admin::getUsername, request.getUsername()));
            if (admin != null && inputPasswordMd5.equalsIgnoreCase(admin.getPassword())) {
                userId = admin.getId();
                role = "admin";
            }
        }

        if (userId == null) {
            throw new RuntimeException("用户名或密码错误");
        }

        String token = jwtUtil.generateToken(userId, role);

        LoginVO loginVO = new LoginVO();
        loginVO.setToken(token);
        loginVO.setUserId(userId);
        loginVO.setUsername(request.getUsername());
        loginVO.setRole(role);
        return loginVO;
    }

    @Override
    public void register(RegisterRequest request) {
        String role = request.getRole();
        if (role == null || role.isEmpty()) {
            throw new RuntimeException("角色类型不能为空");
        }

        String md5Password = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());

        switch (role.toLowerCase()) {
            case "user":
                registerUser(request, md5Password);
                break;
            case "merchant":
                registerMerchant(request, md5Password);
                break;
            default:
                throw new RuntimeException("不支持的角色类型或管理员不可注册");
        }
    }

    private void registerUser(RegisterRequest request, String md5Password) {
        User exist = userMapper.selectOne(
                new LambdaQueryWrapper<User>().eq(User::getUsername, request.getUsername()));
        if (exist != null) {
            throw new RuntimeException("用户名已存在");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(md5Password);
        user.setName(request.getName());
        user.setImgUrl(request.getImgUrl());
        user.setPoints(0);
        user.setCreateTime(new Date());
        boolean success = userService.insert(user);
        if (!success) {
            throw new RuntimeException("用户注册失败");
        }
    }

    private void registerMerchant(RegisterRequest request, String md5Password) {
        Merchant exist = merchantMapper.selectOne(
                new LambdaQueryWrapper<Merchant>().eq(Merchant::getUsername, request.getUsername()));
        if (exist != null) {
            throw new RuntimeException("用户名已存在");
        }

        if (request.getName() == null || request.getName().isEmpty()) {
            throw new RuntimeException("商家名称不能为空");
        }
        if (request.getCanteenId() == null) {
            throw new RuntimeException("所属食堂ID不能为空");
        }

        Merchant merchant = new Merchant();
        merchant.setUsername(request.getUsername());
        merchant.setPassword(md5Password);
        merchant.setName(request.getName());
        merchant.setCanteenId(request.getCanteenId());
        merchant.setPhone(request.getPhone());
        merchant.setImgUrl(request.getImgUrl());
        merchant.setIsOpen(request.getIsOpen() != null ? request.getIsOpen() : 0);
        boolean success = merchantService.insert(merchant);
        if (!success) {
            throw new RuntimeException("商家注册失败");
        }
    }
}
