package com.wangtao.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author : wangtao
 * @date : 2018/1/8 18:15
 */
@Component
@Aspect
public class LogAspect {

    @Pointcut("@annotation(com.wangtao.aop.Action)")
    public void pointCut() {
    }

    @Around("pointCut()")
    public Object advice(ProceedingJoinPoint joinPoint) {
        System.out.println("环绕通知之开始");
        Object proceed = null;
        try {
            proceed = joinPoint.proceed();
            System.out.println("proceed = " + proceed.toString());
        } catch (Throwable e) {
            e.printStackTrace();
        }
        System.out.println("环绕通知之结束");
        return proceed;

    }

    @Before("pointCut()")
    public void after(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        Action annotation = method.getAnnotation(Action.class);
        System.out.println("annotation = " + annotation.value());
    }

    @Before("execution(public * com.wangtao.aop.NoAnnotationService.*(..))")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = methodSignature.getMethod();
        System.out.println("method = " + method.getName());
    }
}
