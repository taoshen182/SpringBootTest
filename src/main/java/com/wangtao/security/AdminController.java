package com.wangtao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionInformation;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

import java.util.List;

/**
 * @author : wangtao
 * @date : 2018/1/15 15:13
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "admin-index";
    }

    @Autowired
    SessionRegistry sessionRegistry;

    @RequestMapping("/num")
    @ResponseBody
    public String getNumberOfUsers() {
        List<Object> principals = sessionRegistry.getAllPrincipals();
        System.out.println("principals = " + principals);
        for (Object prin : principals) {
            System.out.println("prin = " + prin);
            List<SessionInformation> allSessions = sessionRegistry.getAllSessions(prin, true);
            for (SessionInformation session : allSessions) {
                System.out.println("session = " + session);
                String sessionId = session.getSessionId();
                System.out.println("sessionId = " + sessionId);
            }
        }
        return "" + principals.size();
    }

    @Autowired
    SysUserRepository sysUserRepository;

    @RequestMapping("/user")
    public String getUsers(Model model) {
        List<SysUser> all = sysUserRepository.findAll();
        model.addAttribute("users", all);
        return "admin/user/sysuser";
    }

    @RequestMapping("/show/{id}")
    public String show(Model model, @PathVariable Long id) {
        System.out.println("id = " + id);
        SysUser one = sysUserRepository.getOne(id);
        model.addAttribute("user", one);
        return "admin/user/show";
    }

    @RequestMapping("/show")
    public String addOrEdit(Model model, @RequestParam(value = "id", required = false) Long id) {
        if (id != null) {
            SysUser one = sysUserRepository.getOne(id);
            if (one != null) {
                model.addAttribute("user", one);
            } else {
                model.addAttribute("user", new SysUser());
            }
        }
        return "admin/user/show";
    }

    @RequestMapping("/save")
    @ResponseBody
    public String saveUser(SysUser user) {
        System.out.println("user = " + user);
        Assert.notNull(user, "SysUser required");
        SysUser save = sysUserRepository.save(user);
        return "add user : " + save.toString();
    }
}
