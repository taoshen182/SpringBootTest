package com.wangtao.beanlife;

import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author : wangtao
 * @date : 2018/1/8 14:55
 */

public class BeanLifeService {
    @Value("I am BeanLifeService")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**
     * 1
     */
    public BeanLifeService() {
        super();
        System.out.println("BeanLifeService construct ... ");
    }

    @PostConstruct
    public void post33() {
        System.out.println("BeanLifeService postConstruct 33 ... ");
    }
    /**
     * 2 注解配置的 ，在构造方法执行之后
     */
    @PostConstruct
    public void post() {
        System.out.println("BeanLifeService postConstruct ... ");
    }

    @PostConstruct
    public void post22() {
        System.out.println("BeanLifeService postConstruct 22 ... ");
    }

    /**
     * 3 @Bean 中配置的 初始化的方法
     */
    public void initTheBean() {
        System.out.println("BeanLifeService init ... ");
    }

    /**
     * 4 注解配置的 ，在Bean销毁之前执行
     */
    @PreDestroy
    public void destroy() {
        System.out.println("BeanLifeService preDestroy ... ");
    }

    /**
     * 5 @Bean 中配置的 销毁的方法
     */
    public void destroyBean() {
        System.out.println("BeanLifeService destroy ... ");
    }


}
