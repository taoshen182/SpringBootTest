package com.wangtao.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @author : want
 * @date : 2018/2/24 11:49
 * <p>
 * 获取增强的目标类的工厂Factory，其中增强的方法类对象是有Enhancer来实现的
 * <p>
 * 工厂类，生成增强过的目标类（已加入切入逻辑）
 */

public class Factory {
    /**
     * 获得增强之后的目标类，即添加了切入逻辑advice之后的目标类
     *
     * @param proxy
     * @return
     */
    public static Base getInstance(CglibProxy proxy) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Base.class);
        //回调方法的参数为代理类对象CglibProxy，最后增强目标类调用的是代理类对象CglibProxy中的intercept方法
        enhancer.setCallback(proxy);
        // 此刻，base不是单纯的目标类，而是增强过的目标类
        Base base = (Base) enhancer.create();
        return base;
    }
}
