package org.example.eateaseserver.controller;

import jakarta.annotation.Resource;
import org.example.eateaseserver.pojo.CommonResult;
import org.example.eateaseserver.pojo.entity.Canteen;
import org.example.eateaseserver.service.CanteenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/canteen")
public class CanteenController {
    @Resource
    private CanteenService canteenService;
    @GetMapping("/getById")
    public CommonResult getCanteen(@RequestParam("id") Long id) {
        Canteen canteen = canteenService.selectById(id);
        if (canteen == null) {
            return CommonResult.error("食堂不存在");
        }
        return CommonResult.success(canteen);
    }
}
