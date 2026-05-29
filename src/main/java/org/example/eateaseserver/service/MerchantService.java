package org.example.eateaseserver.service;

import org.example.eateaseserver.pojo.entity.Merchant;
import org.springframework.stereotype.Service;

public interface MerchantService {
    Boolean insert(Merchant merchant);
}
