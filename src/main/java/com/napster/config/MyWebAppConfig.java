package com.napster.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * web配置类
 */
@Configuration
public class MyWebAppConfig extends WebMvcConfigurerAdapter {

    @Value("${rootPath}")
    private String rootPath;

    @Autowired
    private LoginHandlerInterceptor loginHandlerInterceptor;


    /**
     * 配置资源路径映射，可以使SpringBoot项目访问外部资源
     *
     * @param registry
     */
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
        registry.addResourceHandler("/html/**").
                addResourceLocations("file:" + rootPath + "/html/");
        super.addResourceHandlers(registry);
    }

    /**
     * 配置拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginHandlerInterceptor).addPathPatterns("/admin/**");
        super.addInterceptors(registry);
    }
}
