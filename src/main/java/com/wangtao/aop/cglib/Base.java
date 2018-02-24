package com.wangtao.aop.cglib;

/**
 * @author : want
 * @date : 2018/2/24 11:41
 * <p>
 * cglib不需要定义目标类的统一接口
 */

public class Base {
    public void add() {
        System.out.println("[Base.add] do some ... ");
    }
}
