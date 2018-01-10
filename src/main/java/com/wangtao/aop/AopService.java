package com.wangtao.aop;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;

/**
 * @author : wangtao
 * @date : 2018/1/8 18:12
 */
@EnableAspectJAutoProxy //这个配置了才生效
@Service
public class AopService {
    @Action("我的注解")
    public void add() {
        System.out.println("AopService add ... ");
    }
}
