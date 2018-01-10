package com.wangtao.study.controller;

import com.wangtao.aop.Action;
import com.wangtao.properties.HelloService;
import com.wangtao.study.pojo.User;
import com.wangtao.study.service.UserService;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : wangtao
 * @date : 2017/12/27 10:45
 */
@EnableAspectJAutoProxy
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @Autowired
    private HelloService helloService;

    @Action
    @Secured("role_super")
    @GetMapping(value = "/index")
    @ResponseBody
    public String index() {
        return "hello world!" + " helloService.sayHello = " + helloService.sayHello();
    }


    @GetMapping(value = "/home")
    @ResponseBody
    public String home() {
        return "home home home!";
    }

    @GetMapping(value = "/login")
    @ResponseBody
    public String login() {
        return "login login login!";
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public List<User> getUser(int age) {
        return userService.getUser(age);
    }

    @GetMapping(value = "/user/name")
    @ResponseBody
    public List<User> getUser(String name) {
        return userService.getUserByName(name);
    }


    @GetMapping(value = "/user/one")
    @ResponseBody
    public User showUser(int id) {
        return userService.getOne(id);
    }

    @PostMapping(value = "/user/save")
    @ResponseBody
    public int saveUser(String username, int age, String email) {
        return userService.saveUser(username, age, email);
    }


}
