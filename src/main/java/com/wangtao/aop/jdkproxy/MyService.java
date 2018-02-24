package com.wangtao.aop.jdkproxy;

/**
 * @author : want
 * @date : 2018/2/24 11:22
 * <p>
 * 该类是所有被代理类的接口类，jdk实现的代理要求被代理类基于统一的接口
 */

public interface MyService {
    void add();
}
