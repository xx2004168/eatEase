package org.example.eateaseserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.example.eateaseserver.pojo.entity.Merchant;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MerchantMapper extends BaseMapper<Merchant> {
}
