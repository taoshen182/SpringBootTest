package com.wangtao.aop.jdkproxy;

/**
 * @author : want
 * @date : 2018/2/24 11:22
 */

public class MyServiceImpl implements MyService {
    @Override
    public void add() {
        System.out.println("MyServiceImpl add ... ");
    }
}
