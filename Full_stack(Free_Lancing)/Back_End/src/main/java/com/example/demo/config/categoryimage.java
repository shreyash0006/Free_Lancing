package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class categoryimage implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry reg)
    {
        String path= Paths.get("uploads").toAbsolutePath().toString();
        reg.addResourceHandler("/uploads/**").addResourceLocations("file:"+path+"/");
    }
}
