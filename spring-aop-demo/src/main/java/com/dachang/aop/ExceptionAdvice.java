package com.dachang.aop;

import com.dachang.entity.ServiceResultTO;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/11 19:23
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Aspect
@Component
public class ExceptionAdvice {
    @Pointcut("@annotation( com.dachang.annotation.GlobalErrorCatch)")
    private void GlobalErrorCatch() {
    }

    @Around("GlobalErrorCatch()")
    public Object handleGlobalErrorCatch(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Object obj = pjp.proceed();
            return obj;
        } catch (Exception e) {
            System.out.println("执行错误"+e);
            return ServiceResultTO.buildFailed(false, "系统错误");
        }
    }
}
