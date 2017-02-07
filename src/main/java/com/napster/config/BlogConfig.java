package com.napster.config;

import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.filter.OrderedHiddenHttpMethodFilter;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
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

    /**
     * 配置上传文件解析
     */
    @Bean("multipartResolver")
    public MultipartResolver multipartResolver() {
        return new MyMultipartResolver();
    }

    /**
     * HiddenHttpMethodFilter会改掉request的某些信息，使得post传文件时取出流错误
     */
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

    @Bean
    public EmbeddedServletContainerCustomizer containerCustomizer() {
        return container -> {
            ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/404");
            ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500");
            container.addErrorPages(errorPage404, errorPage500);
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
