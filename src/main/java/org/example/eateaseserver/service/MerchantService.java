package org.example.eateaseserver.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.example.eateaseserver.pojo.entity.Merchant;

public interface MerchantService {
    Boolean insert(Merchant merchant);

    IPage<Merchant> getMerchantPage(int current, int size);
}
