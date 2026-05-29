package org.example.eateaseserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. 彻底关闭 CSRF（前后端分离必须，否则 POST 请求会被拦截报 403）
            .csrf(AbstractHttpConfigurer::disable)
            
            // 2. 配置 CORS 跨域
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            
            // 3. 权限控制：允许所有请求通过
            .authorizeHttpRequests(auth -> auth
                .anyRequest().permitAll()
            )
            
            // 4. 关闭默认登录表单和 Basic 认证
            .formLogin(AbstractHttpConfigurer::disable)
            .httpBasic(AbstractHttpConfigurer::disable)
            
            // 5. 设置为无状态 Session（配合 JWT 使用）
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
            
        return http.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        // 允许所有域名访问（生产环境请改为具体域名）
        configuration.setAllowedOriginPatterns(Arrays.asList("http://localhost:*", "http://127.0.0.1:*", "https://*"));
        // 允许所有 HTTP 方法（包括 OPTIONS 预检请求）
        configuration.setAllowedMethods(Arrays.asList("*"));
        // 允许所有请求头
        configuration.setAllowedHeaders(Arrays.asList("*"));
        // 允许携带 Cookie/Token 等凭证
        configuration.setAllowCredentials(true);
        // 预检请求缓存时间（1小时）
        configuration.setMaxAge(3600L);
        
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}
