package com.dachang.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dachang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/14 15:57
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Component
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
