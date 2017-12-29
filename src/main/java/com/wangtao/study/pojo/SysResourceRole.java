package com.wangtao.study.pojo;

import org.springframework.data.annotation.Id;

import java.util.Date;


/**
 * @author : wangtao
 * @date : 2017/12/28 15:32
 */


public class SysResourceRole {

    private int id;


    private String roleId; //角色ID


    private String resourceId;//资源ID


    private Date updateTime;//更新时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getResourceId() {
        return resourceId;
    }

    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}
