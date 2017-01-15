package com.napster.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 资源路径config
 */
@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {

    @Value("${rootPath}")
    private String rootPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/picture/**").
                addResourceLocations("file:" + rootPath + "/picture/");
        registry.addResourceHandler("/scrawl/**").
                addResourceLocations("file:" + rootPath + "/scrawl/");
        registry.addResourceHandler("/screen/**").
                addResourceLocations("file:" + rootPath + "/screen/");
        registry.addResourceHandler("/catch/**").
                addResourceLocations("file:" + rootPath + "/catch/");
        registry.addResourceHandler("/video/**").
                addResourceLocations("file:" + rootPath + "/video/");
        registry.addResourceHandler("/file/**").
                addResourceLocations("file:" + rootPath + "/file/");

        super.addResourceHandlers(registry);
    }
}
