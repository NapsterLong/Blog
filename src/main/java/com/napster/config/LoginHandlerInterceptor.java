package com.napster.config;

import com.napster.mapper.UserMapper;
import com.napster.model.User;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 登陆拦截器，控制登陆跳转
 */
@Component
public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!request.getServletPath().startsWith("/admin/login") && request.getServletPath().startsWith("/admin")) {
            HttpSession session = request.getSession();
            if (null == session || StringUtils.isBlank((String) session.getAttribute("userId"))) {
                response.sendRedirect("/admin/login");
                return false;
            } else {
                User user = userMapper.selectByUserId((String) session.getAttribute("userId"));
                request.setAttribute("userId", user.getUserId());
                request.setAttribute("userName", user.getUserName());
                return true;
            }
        } else {
            return true;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
