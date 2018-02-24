package com.wangtao.aop.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author : want
 * @date : 2018/2/24 11:12
 */

public class MyHandler implements InvocationHandler {
    private Object target;

    public MyHandler() {
        super();
    }

    public MyHandler(Object target) {
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("[MyHandler.invoke] before ....  ");
        Object result = method.invoke(target, args);
        System.out.println("[MyHandler.invoke] after ....  ");
        return result;
    }
}
