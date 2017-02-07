package com.napster.config;

import com.napster.util.IPUtil;
import com.napster.util.LogUtil;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 记录请求日志和异常日志的切面
 */
@Aspect
@Component
public class BlogAspect {

    @Pointcut(value = "execution (* com.napster.controller..*.*(..))")
    public void pointcut() {
    }

    /**
     * 配置打印每个请求的信息
     *
     * @param point
     */
    @Before(value = "pointcut()")
    public void before(JoinPoint point) {
        String ipAddress = IPUtil.getRemoteAddress();
        String className = point.getTarget().getClass().getName();
        String methodName = point.getSignature().getName();
        LogUtil.logInfo("ip address:" + ipAddress + StringUtils.SPACE +
                "is visiting" + StringUtils.SPACE + className + "." + methodName + "()");
    }

    /**
     * 配置打印controller抛出的异常信息
     *
     * @param point
     */
    /*@Around(value = "pointcut()")
    public void around(ProceedingJoinPoint point) {
        try {
            point.proceed();
        } catch (Throwable e) {
            LogUtil.logError(e);
        }
    }*/


}
