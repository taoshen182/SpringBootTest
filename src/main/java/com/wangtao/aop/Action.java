package com.wangtao.aop;

import java.lang.annotation.*;

/**
 * @author : wangtao
 * @date : 2018/1/8 17:34
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface Action {
    String name();
}
