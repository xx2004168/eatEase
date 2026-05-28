package org.example.eateaseserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.AdminMapper;
import org.example.eateaseserver.mapper.MerchantMapper;
import org.example.eateaseserver.mapper.UserMapper;
import org.example.eateaseserver.pojo.dto.LoginRequest;
import org.example.eateaseserver.pojo.dto.LoginVO;
import org.example.eateaseserver.pojo.entity.Admin;
import org.example.eateaseserver.pojo.entity.Merchant;
import org.example.eateaseserver.pojo.entity.User;
import org.example.eateaseserver.service.AuthService;
import org.example.eateaseserver.util.JwtUtil;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

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

    @Override
    public LoginVO login(LoginRequest request) {
        Long userId = null;
        String role = null;
        String inputPasswordMd5 = DigestUtils.md5DigestAsHex(request.getPassword().getBytes());

        User user = userMapper.selectOne(
                new LambdaQueryWrapper<User>().eq(User::getUsername, request.getUsername()));
        if (user != null && inputPasswordMd5.equalsIgnoreCase(user.getPassword())) {
            userId = user.getId();
            role = "student";
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
}
