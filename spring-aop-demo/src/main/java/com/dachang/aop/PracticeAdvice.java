package com.dachang.aop;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname
 * @Descripyion aop练习案例
 * 切点和通知构成切面
 * @Date 2022/2/16 11:37
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Aspect
@Component
//@Slf4j
public class PracticeAdvice {

    private Logger logger = LoggerFactory.getLogger(PracticeAdvice.class);
    /**
     * 定义切点（选中的连接点就叫做切点）
     * 使用注解或者切点表达式
     * 这个包下的所有类所有方法以及所有参数
     * @param
     * @return null
     * @author Evan
     * @date 2022/2/16 11:38
     */
    @Pointcut("execution( * com.dachang.controller.PracticeController.*(..))")
    private void practiceCut() {
    }


    @Before("practiceCut()")
    public void doBefore(JoinPoint joinPoint) {
        logger.info("====doBefore方法进入了====");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //获取签名
        Signature signature = joinPoint.getSignature();

        //获取包名
        String declaringTypeName = signature.getDeclaringTypeName();

        //获取即将执行的方法名
        String methodName = signature.getName();

        logger.info("获取即将执行的方法名:{},属于{}包",methodName,declaringTypeName);

        //获取url
        String url = request.getRequestURL().toString();

        //获取ip(远程地址)
        String ip = request.getRemoteAddr();

        logger.info("用户url为:{}，ip地址为:{}",url,ip);
    }

    /**
     * 环绕增强 算耗时
     * @author Evan
     * @date 2022/2/17 11:08
     * @param proceedingJoinPoint
     * @return java.lang.Object
     */
    @Around("practiceCut()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Object result = null;
        long startTime = System.currentTimeMillis();
        try {
            result = proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            logger.error(throwable.getMessage());
        }
        logger.info("========================================== 环绕Start ==========================================");
        logger.info("URL        :{}",request.getRequestURL());
        logger.info("URI        :{}",request.getRequestURI());
        //http 请求方式
        logger.info("HTTP Method:      {}",request.getMethod());

        //控制器全路径以及执行方法名
        logger.info("控制器全路径:      {}，方法名:       {}",proceedingJoinPoint.getSignature().getDeclaringTypeName(),proceedingJoinPoint.getSignature().getName());

        //打印请求ip
        logger.info("IP:     {}", request.getRemoteAddr());

        //请求入参
        logger.info("Request Args:      {}",proceedingJoinPoint.getArgs());
        //耗时
        logger.info("耗时:        {} ms", System.currentTimeMillis() - startTime);
        logger.info("=========================================== 环绕End ===========================================");
        return result;
    }

    @AfterReturning(pointcut = "practiceCut()",returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
      logger.info("结果增强:{}",result);
    }






}
