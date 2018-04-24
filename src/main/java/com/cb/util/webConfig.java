package com.cb.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName webConfig
 * @Author redPeanuts
 * @Data 2018/4/19 15:40
 * @Version 1.0
 * @describtion 处理静态资源请求
 **/
@EnableWebMvc
@Configuration
public class webConfig implements WebMvcConfigurer {

    //处理图片请求路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry r) {
        r.addResourceHandler("/static/**").addResourceLocations(ResourceUtils.CLASSPATH_URL_PREFIX + "/static/");

    }
}
