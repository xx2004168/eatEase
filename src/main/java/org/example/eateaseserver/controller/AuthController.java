package org.example.eateaseserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.example.eateaseserver.pojo.CommonResult;
import org.example.eateaseserver.pojo.dto.LoginRequest;
import org.example.eateaseserver.pojo.dto.RegisterRequest;
import org.example.eateaseserver.pojo.vo.LoginVO;
import org.example.eateaseserver.service.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Tag(name = "认证模块", description = "登录注册相关接口")
public class AuthController {

    @Resource
    private AuthService authService;

    @PostMapping("/login")
    @Operation(summary = "统一登录接口")
    public CommonResult login(@RequestBody LoginRequest request) {
        try {
            LoginVO loginVO = authService.login(request);
            return CommonResult.success(loginVO, "登录成功");
        } catch (RuntimeException e) {
            return CommonResult.error(401, e.getMessage());
        }
    }

    @PostMapping("/register")
    @Operation(summary = "统一注册接口")
    public CommonResult register(@RequestBody RegisterRequest request) {
        try {
            authService.register(request);
            return CommonResult.success(null, "注册成功");
        } catch (RuntimeException e) {
            e.printStackTrace();
            return CommonResult.error(400, e.getMessage());
        }
    }
}
