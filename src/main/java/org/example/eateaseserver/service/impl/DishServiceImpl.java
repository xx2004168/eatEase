package org.example.eateaseserver.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.DishMapper;
import org.example.eateaseserver.pojo.entity.Dish;
import org.example.eateaseserver.pojo.entity.Merchant;
import org.example.eateaseserver.service.DishService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishServiceImpl implements DishService {
    @Resource
    private DishMapper dishMapper;
    @Override
    public IPage<Dish> listByMerchant(int current, int size, Long merchantId) {
        Page<Dish> page = new Page<>(current, size);
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
        if (merchantId != null) {
            queryWrapper.eq("merchant_id", merchantId);
        }
        return dishMapper.selectPage(page, queryWrapper);
    }
}
