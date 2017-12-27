package com.wangtao.study.controller;

import com.wangtao.study.pojo.User;
import com.wangtao.study.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author : wangtao
 * @date : 2017/12/27 10:45
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/index")
    @ResponseBody
    public String index() {
        return "hello world!";
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public List<User> getUser(int age) {
        return userService.getUser(age);
    }
}
