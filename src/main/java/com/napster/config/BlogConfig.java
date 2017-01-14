package com.napster.config;

import org.springframework.context.annotation.Configuration;

/**
 * 配置类
 */

@Configuration
public class BlogConfig {

   /* @Bean("multipartResolver")
    public MultipartResolver multipartResolver() {
        return new MyMultipartResolver();
    }

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        return new OrderedHiddenHttpMethodFilter(){
            @Override
            protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
                    throws ServletException, IOException {
                filterChain.doFilter(request, response);
            }
        };
    }*/


}
