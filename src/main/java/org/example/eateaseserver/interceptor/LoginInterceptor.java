package org.example.eateaseserver.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.eateaseserver.util.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    private final JwtUtil jwtUtil;

    public LoginInterceptor(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String uri = request.getRequestURI();
        if (uri.equals("/auth/login") || uri.equals("/auth/register")) {
            return true;
        }

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            response.setStatus(401);
            return false;
        }

        if (token.startsWith("Bearer ")) {
            token = token.substring(7);
        }

        if (jwtUtil.isTokenExpired(token)) {
            response.setStatus(401);
            return false;
        }

        request.setAttribute("userId", jwtUtil.getUserId(token));
        request.setAttribute("role", jwtUtil.getRole(token));
        return true;
    }
}
