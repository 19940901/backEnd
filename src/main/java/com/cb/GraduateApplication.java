package com.cb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication(scanBasePackages = "com.cb.*")
@MapperScan(basePackages = "com.cb.dao")
public class GraduateApplication extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(GraduateApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(GraduateApplication.class, args);
    }
}
