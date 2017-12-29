package com.wangtao.study.pojo;

import org.apache.ibatis.mapping.FetchType;
import org.springframework.data.annotation.Id;

/**
 * @author : wangtao
 * @date : 2017/12/28 15:31
 */

public class SysRole {

    private int id;


    private SysUser SUser;//角色对应的用户实体


    private String name;//角色名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SysUser getSUser() {
        return SUser;
    }

    public void setSUser(SysUser sUser) {
        SUser = sUser;
    }
}
