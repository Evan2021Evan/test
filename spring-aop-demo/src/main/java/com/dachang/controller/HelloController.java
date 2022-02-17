package com.dachang.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/10 16:54
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@RestController
public class HelloController {

    @GetMapping(value = "/hello1")
    public String hello1(@RequestParam(value = "name") String name) {
        return "欢迎:" + name;
    }

    @GetMapping(value = "/hello2")
    public String hello2(@RequestParam(value = "name") String name,@RequestParam("age") int age) {
        return "欢迎:"+age+"岁的" + name;
    }

}
