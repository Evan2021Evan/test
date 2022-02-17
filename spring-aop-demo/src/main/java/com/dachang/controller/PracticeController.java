package com.dachang.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/16 11:42
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@RestController
@RequestMapping(value = "/practice")
public class PracticeController {

    @GetMapping("/practiceAop")
    public Object practiceAop(@RequestParam("name") String name) {
        return "Hello " + name;
    }
}
