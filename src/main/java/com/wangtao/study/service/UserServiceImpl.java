package com.wangtao.study.service;

import com.wangtao.study.dao.UserMapper;
import com.wangtao.study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : wangtao
 * @date : 2017/12/27 15:41
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUser(int age) {
        return userMapper.getUser(age);
    }

    @Override
    public List<User> getUserByName(String name) {
        return userMapper.getUserByName(name);
    }

    @Override
    public int saveUser(String username, int age, String email) {
        return userMapper.saveUser(username, age, email);
    }

    @Override
    public User getOne(int id) {
        return userMapper.getOne(id);
    }
}
