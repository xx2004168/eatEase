package org.example.eateaseserver.service.impl;

import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.AdminMapper;
import org.example.eateaseserver.pojo.entity.Admin;
import org.example.eateaseserver.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    private AdminMapper adminMapper;
    @Override
    public Boolean insert(Admin admin) {
        return adminMapper.insert(admin) > 0;
    }
}
