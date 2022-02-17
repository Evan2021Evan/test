package com.dachang.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/11 17:53
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Component
@Aspect
public class TestAdvice {
   /**
    * 选择连接点
    * @author Evan
    * @date 2022/2/11 18:16
    */
    @Pointcut("execution( * com.dachang.service.impl.TestServiceImpl.eatCarrot())")
    private void eatCarrot() {
    }

    /**
     *  定义通知
     * @author Evan
     * @date 2022/2/11 18:21
     * @param pjp
     */
    @Around("eatCarrot()")
    public void eatCarrotAdvice(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("吃萝卜前洗手");
        //  原来的 TestServiceImpl.eatCarrot 逻辑，可视情况决定是否执行
        pjp.proceed();
        System.out.println("吃萝后买单");
    }
}
