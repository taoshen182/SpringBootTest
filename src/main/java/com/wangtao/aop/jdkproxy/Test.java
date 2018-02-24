package com.wangtao.aop.jdkproxy;

import java.lang.reflect.Proxy;

/**
 * @author : want
 * @date : 2018/2/24 11:24
 */

public class Test {
    public static void main(String[] args) {
        MyService service = new MyServiceImpl();
        MyHandler myHandler = new MyHandler(service);

        //生成代理类
        MyService serviceProxy = (MyService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), myHandler);

        serviceProxy.add();
    }
}
