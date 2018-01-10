package com.wangtao.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : wangtao
 * @date : 2018/1/9 16:41
 */
@Controller
public class HelloController {
    @RequestMapping("/mvc")
    public String hello() {
        return "test";
    }
}
