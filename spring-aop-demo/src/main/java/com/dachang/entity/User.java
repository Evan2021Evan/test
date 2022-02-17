package com.dachang.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/14 15:38
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.AUTO)
    private Long id;

    @TableField("user_name")
    private String userName;

    private String userAge;
}
