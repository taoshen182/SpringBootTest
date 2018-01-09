package com.wangtao.aop;

import com.sun.beans.decoder.ValueObject;
import org.springframework.stereotype.Component;

/**
 *
 * @author : wangtao
 * @date : 2018/1/9 9:48
 */
public aspect TestAspect {

    private long ValueObject.timestamp;
    public long ValueObject.getTimestamp() {
        return timestamp;
    }

    public void ValueObject.timestamp() {
        //"this" refers to ValueObject class not Timestamp aspect
        this.timestamp = System.currentTimeMillis();
    }

    pointcut HelloWorldPointCut() : execution(public * com.wangtao.asynctask..*(..));
    before() : HelloWorldPointCut(){
        System.out.println("Hello world");
    }


    pointcut publicMethods(): execution(public * com.wangtao.aop..*(..));
    pointcut logObjectCalls():
            execution(* Logger.*(..));

    pointcut loggableCalls(): publicMethods() && ! logObjectCalls();

    before(): loggableCalls(){
        System.out.println(thisJoinPoint.getSignature().toString());
    }
    before(): publicMethods(){
        System.out.println(thisJoinPoint.getSignature().toString());
    }

    after(): loggableCalls(){
        System.out.println(thisJoinPoint.getSignature().toString());
    }
}
