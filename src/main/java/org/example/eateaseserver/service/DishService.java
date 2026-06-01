package org.example.eateaseserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.eateaseserver.pojo.entity.Dish;
import org.example.eateaseserver.pojo.entity.Merchant;

import java.util.List;

public interface DishService {
    IPage<Dish> listByMerchant(int current, int size, Long merchantId);
}
