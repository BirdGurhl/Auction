package com.example.auction.tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class MyMVCConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//uploads/**:表示uploads及下面子目录路径
//addResourceLocations("file:E:\\test\\images\\")表示本地映射的具体位置，上传的图片存储的文件夹位置
        registry.addResourceHandler("/uploads/**").addResourceLocations("file:D:\\test\\images\\");
    }
}
