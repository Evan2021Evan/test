package com.dachang.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/15 10:27
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Aspect
@Component
public class LogAdvice {
    /**
     * 定义一个切点
     * @author Evan
     * @date 2022/2/15 10:36
     */
    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    private void logAdvicePointcut() {
    }

    // Before表示logAdvice将在目标方法执行前执行
    @Before("logAdvicePointcut()")
    public void logAdvice(){
        // 这里只是一个示例，你可以写任何处理逻辑
        System.out.println("post请求的advice触发了");
    }


}
