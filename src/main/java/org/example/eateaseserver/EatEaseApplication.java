package org.example.eateaseserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("org.example.eateaseserver.mapper")
@EnableAsync
public class EatEaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(EatEaseApplication.class, args);
        System.out.println("========== eat-ease-server started ==========");
    }

}
