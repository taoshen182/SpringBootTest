package com.wangtao.aop;

import org.springframework.stereotype.Service;

/**
 * @author : wangtao
 * @date : 2018/1/8 18:12
 */
@Service
public class AopService {
    @Action("我的注解")
    public void add() {
        System.out.println("AopService add ... ");
    }
}
