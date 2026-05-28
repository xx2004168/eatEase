package org.example.eateaseserver.service.impl;

import jakarta.annotation.Resource;
import org.example.eateaseserver.mapper.UserMapper;
import org.example.eateaseserver.service.UserService;

public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

}
