package com.wangtao.thymeleaf;

/**
 * @author : wangtao
 * @date : 2018/1/10 16:31
 */

public class PersonTest {
    private String name;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public PersonTest(String name, String address, Integer age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    private String address;
    private Integer age;

    public PersonTest(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public PersonTest() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
