package com.wangtao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author : wangtao
 * @date : 2018/1/8 18:15
 */
@Aspect
@Component
@Order(1)
public class LogAspect {

    @Pointcut("@annotation(com.wangtao.aop.Action)")
    public void pointCut() {
        System.out.println("my point cut ");
    }

    @Before("pointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("annotation = " + annotation.name());
    }

    @Before("execution(public * com.wangtao.aop.NoAnnotationService.*(..))")
    public void before(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("method = " + method.getName());
    }
}
