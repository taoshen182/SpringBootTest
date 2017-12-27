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
}
