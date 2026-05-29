package org.example.eateaseserver.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.example.eateaseserver.pojo.CommonResult;
import org.example.eateaseserver.pojo.entity.Merchant;
import org.example.eateaseserver.service.MerchantService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/merchant")
@Tag(name = "商家模块", description = "商家管理相关接口")
public class MerchantController {

    @Resource
    private MerchantService merchantService;

    @GetMapping("/list")
    @Operation(summary = "分页查询商家列表")
    public CommonResult getMerchants(
            @RequestParam(defaultValue = "1") int current,
            @RequestParam(defaultValue = "10") int size) {
        IPage<Merchant> page = merchantService.getMerchantPage(current, size);
        return CommonResult.success(page, "查询成功");
    }
}
