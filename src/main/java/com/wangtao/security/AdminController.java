package com.wangtao.security;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : wangtao
 * @date : 2018/1/15 15:13
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("index")
    @ResponseBody
    public String index() {
        return "admin-index";
    }
}
