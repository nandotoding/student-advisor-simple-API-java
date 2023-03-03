package com.example.myproject.config;

import com.example.myproject.config.interceptor.HeaderInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    private final HeaderInterceptor headerInterceptor;

    @Autowired
    public InterceptorConfig(HeaderInterceptor headerInterceptor) {
        this.headerInterceptor = headerInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(headerInterceptor);
    }
}
