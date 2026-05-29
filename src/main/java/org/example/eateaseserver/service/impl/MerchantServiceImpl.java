package org.example.eateaseserver.service.impl;

import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.MerchantMapper;
import org.example.eateaseserver.pojo.entity.Merchant;
import org.example.eateaseserver.service.MerchantService;
import org.springframework.stereotype.Service;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Resource
    private MerchantMapper merchantMapper;
    @Override
    public Boolean insert(Merchant merchant) {
        return merchantMapper.insert(merchant) > 0;
    }
}
