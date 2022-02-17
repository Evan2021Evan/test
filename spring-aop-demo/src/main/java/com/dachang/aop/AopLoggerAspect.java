package com.dachang.aop;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.dachang.annotation.AopLogger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import org.springframework.util.ObjectUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @author Administrator
 */
@Aspect
@Component
public class AopLoggerAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 贴了这个注解的方法都加增强
     * @author Evan
     * @date 2022/2/14 17:18
     */
    @Pointcut("@annotation(com.dachang.annotation.AopLogger)")
    public void aopLoggerAspect() {
    }

    /**
     * 环绕触发
     *
     * @param point
     * @return
     */
    @Around("aopLoggerAspect()")
    public Object doAround(ProceedingJoinPoint point) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = servletRequestAttributes.getRequest();
        Object result = null;
        //在业务方法前执行
        long startTime = System.currentTimeMillis();
        try {
            result = point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(throwable.getMessage());
        }
        String describe = getAopLoggerDescribe(point);
        if (StrUtil.isBlank(describe)) {
            describe = "-";
        }
        // 打印请求相关参数
        logger.info("========================================== Start ==========================================");
        logger.info("Describe       : {}", describe);
        // 打印请求 url
        logger.info("URL            : {}", request.getRequestURL());
        logger.info("URI            : {}", request.getRequestURI());
        // 打印 Http method
        logger.info("HTTP Method    : {}", request.getMethod());
        // 打印调用 controller 的全路径以及执行方法
        logger.info("Class Method   : {}.{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
        // 打印请求的 IP
        logger.info("IP             : {}", request.getRemoteAddr());
        // 打印请求入参
        logger.info("Request Args   : {}", point.getArgs());
        // 打印请求出参
        logger.info("Response Args  : {}", result);
        logger.info("Time Consuming : {} ms", System.currentTimeMillis() - startTime);
        logger.info("=========================================== End ===========================================");
        return result;
    }

    /**
     * 获取注解中对方法的描述信息
     *
     * @param joinPoint 切点
     * @return describe
     */
    public static String getAopLoggerDescribe(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        AopLogger controllerLog = method.getAnnotation(AopLogger.class);
        return controllerLog.describe();
    }
}