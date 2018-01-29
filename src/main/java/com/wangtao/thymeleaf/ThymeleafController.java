package com.wangtao.thymeleaf;

import com.wangtao.data.jpa.Person;
import com.wangtao.data.jpa.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.thymeleaf.util.StringUtils;

import java.util.List;

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

    @RequestMapping("/welcome")
    public String welcome(Model model) {
        return "welcome";
    }

    @RequestMapping("/form")
    public String form(Model model) {
        return "form";
    }

    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/table")
    public String table(Model model) {
//        Sort sort = new Sort(Sort.Direction.DESC, "age", "id");
//        System.out.println("sort = " + sort.toString());
//        Page<Person> byName = personRepository.findByName("wangtao", new PageRequest(0, 15, sort));
//        System.out.println("byName = " + byName.toString());
//        List<Person> personList = byName.getContent();
        List<Person> personList = personRepository.findAll();
        model.addAttribute("personList", personList);
        return "tables";
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
