package org.example.eateaseserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.example.eateaseserver.pojo.CommonResult;
import org.example.eateaseserver.pojo.entity.User;
import org.example.eateaseserver.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/getByUsername")
    @Operation(summary = "根据用户名查询用户信息")
    public CommonResult getUserByUsername(@RequestParam String username) {
        User user = userService.selectByUsername(username);
        if (user == null) {
            return CommonResult.error("用户不存在");
        }
        return CommonResult.success(user);
    }
}
