package com.wangtao.aop;

import org.springframework.stereotype.Service;

/**
 * Created by want on 2018-1-8.
 */
@Service
public class NoAnnotationService {
    public void doSome(){
        System.out.println(" 没有使用注解的 ");
    }
}
