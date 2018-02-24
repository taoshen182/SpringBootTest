package com.wangtao.aop;


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author : wangtao
 * @date : 2018/1/8 17:34
 * <p>
 * 元注解@Target,@Retention,@Documented,@Inherited
 * <p>
 * Target
 * ElemenetType.CONSTRUCTOR 构造器声明
 * ElemenetType.FIELD 域声明（包括 enum 实例）
 * ElemenetType.LOCAL_VARIABLE 局部变量声明
 * ElemenetType.METHOD 方法声明
 * ElemenetType.PACKAGE 包声明
 * ElemenetType.PARAMETER 参数声明
 * ElemenetType.TYPE 类，接口（包括注解类型）或enum声明
 * <p>
 * Retention
 * RetentionPolicy.SOURCE 注解将被编译器丢弃
 * RetentionPolicy.CLASS 注解在class文件中可用，但会被VM丢弃
 * RetentionPolicy.RUNTIME VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息。
 * <p>
 * Documented 将此注解包含在 javadoc 中
 * <p>
 * Inherited 允许子类继承父类中的注解
 */
@Documented //将此注解包含在 javadoc 中
@Retention(RUNTIME) //VM将在运行期也保留注释，因此可以通过反射机制读取注解的信息
@Target(METHOD) //方法声明
public @interface Action {
    String value() default "我是日志注解";
}
