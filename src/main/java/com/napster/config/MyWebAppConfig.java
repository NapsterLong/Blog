package com.napster.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 资源路径config
 */
@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/picture/**").
                addResourceLocations("file:/data1/resources/picture/");
        registry.addResourceHandler("/scrawl/**").
                addResourceLocations("file:/data1/resources/scrawl/");
        registry.addResourceHandler("/screen/**").
                addResourceLocations("file:/data1/resources/screen/");
        registry.addResourceHandler("/catch/**").
                addResourceLocations("file:/data1/resources/catch/");
        registry.addResourceHandler("/video/**").
                addResourceLocations("file:/data1/resources/video/");
        registry.addResourceHandler("/file/**").
                addResourceLocations("file:/data1/resources/file/");

        super.addResourceHandlers(registry);
    }
}
