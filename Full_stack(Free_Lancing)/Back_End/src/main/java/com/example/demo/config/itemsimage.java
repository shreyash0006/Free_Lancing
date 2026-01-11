package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.file.Paths;

@Configuration
public class itemsimage implements WebMvcConfigurer {
    public void addResourceHandlers(ResourceHandlerRegistry reg)
    {
        String path= Paths.get("uploadsitems").toAbsolutePath().toString();
        reg.addResourceHandler("/uploadsitems/**").addResourceLocations("file:"+path+"/");
    }
}
