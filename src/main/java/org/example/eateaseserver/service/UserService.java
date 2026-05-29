package org.example.eateaseserver.service;

import io.swagger.v3.oas.annotations.servers.Server;
import org.example.eateaseserver.pojo.entity.User;

public interface UserService {
    boolean insert(User user);

}
