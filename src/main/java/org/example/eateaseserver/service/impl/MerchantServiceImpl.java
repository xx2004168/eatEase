package org.example.eateaseserver.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    @Override
    public IPage<Merchant> getMerchantPage(int current, int size) {
        Page<Merchant> page = new Page<>(current, size);
        return merchantMapper.selectPage(page, null);
    }
}
