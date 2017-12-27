package com.wangtao.study.dao;

import com.wangtao.study.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author : wangtao
 * @date : 2017/12/27 15:35
 */

@Mapper
public interface UserMapper {

    @Select("select * from user where age=#{age}")
    public List<User> getUser(int age);
}
