package org.example.eateaseserver.service;

import org.example.eateaseserver.pojo.dto.LoginRequest;
import org.example.eateaseserver.pojo.dto.RegisterRequest;
import org.example.eateaseserver.pojo.vo.LoginVO;

public interface AuthService {
    LoginVO login(LoginRequest request);
    void register(RegisterRequest request);
}
