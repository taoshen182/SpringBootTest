package com.wangtao.thymeleaf;

import com.wangtao.data.jpa.*;
import com.wangtao.data.jpa.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by want on 2018-1-13.
 */
//@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;

    @RequestMapping("/save")
    public com.wangtao.data.jpa.Person save(String name, String address, Integer age) {
        Person save = personRepository.save(new Person(name, age, address));
        System.out.println("save = " + save);
        return save;
    }

    @RequestMapping("/getAll")
    public List<Person> getAll() {
        Sort.Order orderAge = new Sort.Order(Sort.Direction.DESC, "age");
        Sort.Order orderId = new Sort.Order(Sort.Direction.DESC, "id");
        Sort.Order orderAddr = new Sort.Order(Sort.Direction.ASC, "address");
        Sort.Order orderName = new Sort.Order(Sort.Direction.ASC, "name");
        List<Sort.Order> orderList = new ArrayList<>();
        orderList.add(orderAge);
        orderList.add(orderId);
        orderList.add(orderAddr);
        orderList.add(orderName);
        Sort sort = new Sort(orderList);
        System.out.println("sort = " + sort.toString());
        List<Person> all = personRepository.findAll(sort);
        System.out.println("all = " + all);
        return all;
    }

    @RequestMapping("/setName")
    public int setName(String name) {
        System.out.println("name = " + name);
        int i = personRepository.setName(name);
        return i;
    }

    @RequestMapping("/setAddress")
    public int setAddress(String address) {
        int i = personRepository.setAddress(address);
        return i;
    }

    @RequestMapping("/getByPage")
    public List<Person> getPersonByPage(String name) {
        List<Person> first10ByName = personRepository.findFirst10ByName(name);
        return first10ByName;
    }

    /**
     * 分页查询
     *
     * @param name name
     * @param page 第几页 从0开始
     * @param size 每页记录数
     * @return {
     * "content" : [ {"id" : 6,"name" : "小王","age" : 26,"address" : "上海"},],   //数据
     * "last" : false,
     * "totalPages" : 11,
     * "totalElements" : 51,
     * "size" : 5,
     * "number" : 1,
     * "sort" : null,
     * "first" : false,
     * "sort" :
     * [ {
     * "direction" : "DESC",
     * "property" : "age",
     * "ignoreCase" : false,
     * "nullHandling" : "NATIVE",
     * "ascending" : false,
     * "descending" : true
     * }, {
     * "direction" : "DESC",
     * "property" : "id",
     * "ignoreCase" : false,
     * "nullHandling" : "NATIVE",
     * "ascending" : false,
     * "descending" : true
     * } ],
     * "numberOfElements" : 5
     * }
     */
    @RequestMapping("/getPage")
    public Page<Person> getPage(String name, int page, int size) {
        Sort sort = new Sort(Sort.Direction.DESC, "age", "id");
        System.out.println("sort = " + sort.toString());
        Page<Person> byName = personRepository.findByName(name, new PageRequest(page, size, sort));
        System.out.println("byName = " + byName.toString());
        return byName;
    }



//    @Autowired
//    PersonRepository2 repository2;
//
//    @RequestMapping("/like")
//    public Page<Person> like(Person person) {
//        Page<Person> byAddress = repository2.findByAuto(person, new PageRequest(0, 10));
//        return byAddress;
//    }

}
