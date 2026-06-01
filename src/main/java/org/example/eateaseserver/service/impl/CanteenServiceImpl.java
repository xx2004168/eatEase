package org.example.eateaseserver.service.impl;

import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.CanteenMapper;
import org.example.eateaseserver.pojo.entity.Canteen;
import org.example.eateaseserver.service.CanteenService;
import org.springframework.stereotype.Service;

@Service
public class CanteenServiceImpl implements CanteenService {
    @Resource
    private CanteenMapper canteenMapper;
    @Override
    public Canteen selectById(Long id) {
        return canteenMapper.selectById(id);
    }

}
