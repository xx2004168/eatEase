package org.example.eateaseserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.annotation.Resource;
import org.example.eateaseserver.pojo.CommonResult;
import org.example.eateaseserver.pojo.entity.Dish;
import org.example.eateaseserver.service.DishService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dish")
public class DishController {
    @Resource
    private DishService dishService;
    @GetMapping("/list")
    @Operation(summary = "获取菜品列表")
    public CommonResult list(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) Long merchantId) {
        IPage<Dish> page = dishService.listByMerchant(current, size, merchantId);
        return CommonResult.success(page, "获取菜品列表成功");
    }
}
