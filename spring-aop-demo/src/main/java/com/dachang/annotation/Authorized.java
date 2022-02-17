package com.dachang.annotation;

import java.lang.annotation.*;

/**
 * 安全认证
 * @author Evan
 * @date 2022/2/15 19:17
 * @param
 * @return
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authorized {
    String value() default "";

}