package com.wangtao.thymeleaf;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.thymeleaf.util.StringUtils;

/**
 * @author : wangtao
 * @date : 2018/1/10 17:07
 */
@Controller
public class ThymeleafController {
    @RequestMapping("/index")
    public String index(Model model) {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        String s = requestAttributes.toString();
        System.out.println("s = " + s);
        PersonTest person = new PersonTest("wangtao", 26);

        model.addAttribute("person", person);
        System.out.println("person = " + person.getName());
        return "index";
    }

    @RequestMapping("/home")
    public String aaa(Model model) {
        return "home";
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
