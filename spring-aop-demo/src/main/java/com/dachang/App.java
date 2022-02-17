package com.dachang;

import com.dachang.service.TestService;
import com.dachang.service.impl.TestServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/10 16:38
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@SpringBootApplication
//@EnableAspectJAutoProxy
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);
        TestService testService = context.getBean(TestService.class);
        System.out.println(testService.getClass());
    }
}
