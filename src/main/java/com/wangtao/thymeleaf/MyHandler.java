package com.wangtao.thymeleaf;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date : 2018/5/21 15:21
 * 1、单个实现类的执行顺序
 * <p>
 * preHandler -> Controller -> postHandler -> model渲染-> afterCompletion
 * <p>
 * 2、多个实现类的执行顺序
 * <p>
 * ———————preHandler1——————-
 * ———————preHandler2——————-
 * ———————preHandler3——————-
 * ———————–Controller———————
 * ———————postHandler3——————
 * ———————postHandler2——————
 * ———————postHandler1——————
 * ———————postHandler1——————
 * ——————afterCompletion3—————-
 * ——————afterCompletion2—————-
 * ——————afterCompletion1—————-
 */

public class MyHandler implements HandlerInterceptor {
    /**
     * 该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor
     * 和Controller，当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
     * 如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request = " + request.getRemoteUser());
        System.out.println(response.getStatus());
        return false;
    }

    /**
     * 该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
     * 可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("modelAndView = " + modelAndView.getViewName());
    }

    /**
     * 该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，
     * 该方法将在整个请求结束之后，也就是在DispatcherServlet 渲染了对应的视图之后执行。
     * 用于进行资源清理。
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
