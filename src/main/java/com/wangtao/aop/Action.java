package com.wangtao.aop;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author : wangtao
 * @date : 2018/1/8 17:34
 */
@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface Action {
    String value() default "我是日志注解";
}
