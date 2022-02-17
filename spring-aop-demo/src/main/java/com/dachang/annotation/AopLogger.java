package com.dachang.annotation;

import java.lang.annotation.*;

/**
 * @author Administrator
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AopLogger {
    String describe() default "";
}