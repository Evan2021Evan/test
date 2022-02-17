package com.dachang.controller;

import com.dachang.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/11 18:17
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@RestController
public class TestController1 {
    @Autowired
    private TestService testService;
    @GetMapping(value = "/test1")
    public void test1() {
        testService.eatCarrot();
    }

    @GetMapping(value = "/test2")
    public void test2() {
        testService.test();
    }
}
