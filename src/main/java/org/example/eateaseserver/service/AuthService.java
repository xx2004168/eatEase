package org.example.eateaseserver.service;

import org.example.eateaseserver.pojo.dto.LoginRequest;
import org.example.eateaseserver.pojo.dto.LoginVO;

public interface AuthService {
    LoginVO login(LoginRequest request);
}
