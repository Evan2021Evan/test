package com.dachang.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dachang.entity.User;
import com.dachang.mapper.UserMapper;
import com.dachang.service.UserService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/14 15:55
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
