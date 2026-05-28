package org.example.eateaseserver.controller;

import org.example.eateaseserver.pojo.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    public CommonResult getUserInfo() {
        return CommonResult.success("用户信息获取成功");
    }
}
