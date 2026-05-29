package org.example.eateaseserver.service.impl;

import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.UserMapper;
import org.example.eateaseserver.pojo.entity.User;
import org.example.eateaseserver.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public boolean insert(User user) {
        return userMapper.insert(user) > 0;
    }
}
