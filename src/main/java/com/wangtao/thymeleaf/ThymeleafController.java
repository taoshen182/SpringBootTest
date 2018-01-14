package com.wangtao.thymeleaf;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.util.StringUtils;

/**
 * @author : wangtao
 * @date : 2018/1/10 17:07
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/index")
    public String index(Model model) {
        PersonTest person = new PersonTest("wangtao", 26);

        model.addAttribute("person", person);
        System.out.println("person = " + person.getName());
        return "index";
    }

    @RequestMapping("/aaa")
    public String aaa(Model model) {
        PersonTest person = new PersonTest("aaa", 26);

        model.addAttribute("person", person);
        System.out.println("person = " + person);
        return "aaa";
    }

    @RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public PersonTest search(String personName) {
        System.out.println("personName = " + personName);
        if (StringUtils.isEmpty(personName)) {
            personName = "default";
        }
        return new PersonTest(personName, "shanghai", 26);
    }
}
