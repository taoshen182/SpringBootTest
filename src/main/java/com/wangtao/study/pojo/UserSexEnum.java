package com.wangtao.study.pojo;

/**
 * @author : wangtao
 * @date : 2017/12/28 10:23
 */

public enum UserSexEnum {
    m("男"),
    f("女");

    private String sex;

    UserSexEnum(String sex) {
        this.sex = sex;
    }


    public String getSex() {
        return this.sex;
    }


}
