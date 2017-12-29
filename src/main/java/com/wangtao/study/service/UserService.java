package com.wangtao.study.service;

import com.wangtao.study.pojo.SysUser;
import com.wangtao.study.pojo.User;

import java.util.List;

/**
 * @author : wangtao
 * @date : 2017/12/27 15:39
 */

public interface UserService {
    public List<User> getUser(int age);

    public int saveUser(String username, int age, String email);

    List<User> getUserByName(String name);

    SysUser findByName(String name);

    public User getOne(int id);

    int update(SysUser user);
}
