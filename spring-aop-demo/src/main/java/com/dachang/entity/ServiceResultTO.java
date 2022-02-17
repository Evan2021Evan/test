package com.dachang.entity;

import java.io.Serializable;

/**
 * @Classname
 * @Descripyion
 * @Date 2022/2/11 19:02
 * @Sign 优秀的判断力来自经验，但经验来自于错误的判断！
 * @Author huangzhongliang
 * @Email zhongliang2018@126.com
 */
public class ServiceResultTO<T> implements Serializable {
    private static final long serialVersionUID = 1L;
    public Boolean success;
    public String message;
    public T data;

    public static ServiceResultTO<Boolean> buildSuccess(Boolean aTrue) {
        System.out.println("成功");
        return new ServiceResultTO<Boolean>();
    }

    public static ServiceResultTO<Boolean> buildFailed(Boolean aFalse, String msg) {
        return new ServiceResultTO<Boolean>();
    }
}
