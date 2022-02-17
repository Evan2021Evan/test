package com.dachang.aop;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/10 17:00
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Component
@Aspect
public class MyAdvice {

    private Logger logger=LoggerFactory.getLogger(MyAdvice.class);

    /**
     * 定义切面
     * @author Evan
     * @date 2022/2/10 17:13
     */
    @Pointcut(value = "execution( * com.dachang.controller.HelloController.*(..))")
    public void myPointCut() {
    }

    /**
     * 声明增强
     * @author Evan
     * @date 2022/2/10 17:17
     * @param pjp
     * @return java.lang.Object
     */
    @Around("myPointCut()")
    public Object myLogger(ProceedingJoinPoint pjp) throws Throwable {
        String methodName = pjp.getSignature().getName();
        String className = pjp.getTarget().getClass().toString();
        Object[] array = pjp.getArgs();
        ObjectMapper m=new ObjectMapper();

        logger.info("调用前:"+className+":"+methodName+"  传递的参数: "+m.writeValueAsString(array));
        Object obj = pjp.proceed();
        logger.info("调用后:"+className+":"+methodName+" 返回的结果: "+obj);
        return obj;
    }

}
