package com.napster.config;

import org.springframework.boot.web.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 基本配置类
 */

@Configuration
public class BlogConfig {

    @Bean("multipartResolver")
    public MultipartResolver multipartResolver() {
        return new MyMultipartResolver();
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new OrderedHiddenHttpMethodFilter() {
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                filterChain.doFilter(request, response);
            }
        };
    }

    /**
     * url过滤器,用于UEditor上传文件和图片
     */
    private class MyMultipartResolver extends CommonsMultipartResolver {

        @Override
        public boolean isMultipart(HttpServletRequest request) {
            String uri = request.getRequestURI();
            if (uri.indexOf("admin/config") > 0) {
                return false;
            }
            return super.isMultipart(request);
        }
    }
}
