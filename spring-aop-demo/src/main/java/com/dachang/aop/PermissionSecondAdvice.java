package com.dachang.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class PermissionSecondAdvice {

   @Pointcut("@annotation(com.dachang.annotation.PermissionAnnotation)")
   private void permissionCheck() {
   }

   @Around("permissionCheck()")
   public Object permissionCheckSecond(ProceedingJoinPoint joinPoint) throws Throwable {
       System.out.println("===================第二个切面===================：" + System.currentTimeMillis());

       //获取请求参数，详见接口类
       Object[] objects = joinPoint.getArgs();
       Long id = ((JSONObject) objects[0]).getLong("id");
       String name = ((JSONObject) objects[0]).getString("name");
       System.out.println("id->>>>>>>>>>>>>>>>>>>>>>" + id);
       System.out.println("name->>>>>>>>>>>>>>>>>>>>>>" + name);

       // name不是管理员则抛出异常
       if (!name.equals("admin")) {
           return JSON.parseObject("{\"message\":\"not admin\",\"code\":403}");
       }
       return joinPoint.proceed();
   }
}