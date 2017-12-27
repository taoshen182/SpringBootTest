package com.wangtao.study.service;

import com.wangtao.study.pojo.User;
import org.springframework.stereotype.Service;


import java.util.List;

/**
 * @author : wangtao
 * @date : 2017/12/27 15:39
 */

public interface UserService {
    public List<User> getUser(int age);
}
