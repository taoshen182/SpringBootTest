package com.wangtao.study.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author : wangtao
 * @date : 2017/12/28 15:31
 */

public class SysUser {

    private Integer id;

    private String name; //用户名

    private String email;//用户邮箱

    private String password;//用户密码

    private Date dob;//时间


    private Set<SysRole> SysRoles = new HashSet<SysRole>(0);// 所对应的角色集合

    public SysUser() {
    }

    public SysUser(String name, String email, String password, Date dob, Set<SysRole> SysRoles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dob = dob;
        this.SysRoles = SysRoles;
    }


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Date getDob() {
        return this.dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }


    public Set<SysRole> getSysRoles() {
        return this.SysRoles;
    }

    public void setSysRoles(Set<SysRole> SysRoles) {
        this.SysRoles = SysRoles;
    }
}
