package com.dachang.controller;

import com.dachang.annotation.AopLogger;
import com.dachang.entity.User;
import com.dachang.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    @AopLogger(describe = "查询所有用户")
    public List<User> findAll() {
        return userService.list();
    }
}