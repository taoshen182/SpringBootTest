package com.wangtao.aop.cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author : want
 * @date : 2018/2/24 11:42
 */

public class CglibProxy implements MethodInterceptor {

    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("[CglibProxy.intercept] before ... ");
        Object result = methodProxy.invokeSuper(object, args);
        System.out.println("[CglibProxy.intercept] after ... ");
        return result;
    }
}
