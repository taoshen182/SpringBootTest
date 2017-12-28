package com.wangtao.study.dao;

import com.wangtao.study.pojo.User;
import com.wangtao.study.pojo.UserSexEnum;
import com.wangtao.study.pojo.UserStatusEnum;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;
import org.apache.ibatis.type.EnumTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

/**
 * @author : wangtao
 * @date : 2017/12/27 15:35
 */

@Mapper
public interface UserMapper {

    @Select("select * from user where age=#{age}")
    public List<User> getUser(int age);

    /* # 和 $ 的区别
      # --->   where name = ?;
    * $ --->   where name = 'someName';
    * */
    @Select("select * from user where username = '${name}'")
    public List<User> getUserByName(@Param("name") String username);


    @Insert("insert into user(id,username,age,email) values (null,#{nnn},#{age},#{email})")
    int saveUser(@Param("nnn") String name, @Param("age") int age, @Param("email") String email);


    @Insert("insert into user(username,age,email) values (#{username},#{age},#{email})")
    int save(User user);


    /**
     * @Result 修饰返回的结果集，关联实体类属性和数据库字段一一对应，
     * 如果实体类属性和数据库属性名保持一致，就不需要这个属性来修饰。
     * 枚举处理类
     * typeHandler = EnumTypeHandler.class  or  EnumOrdinalTypeHandler.class
     */
    @Select("SELECT * FROM user WHERE id = #{id}")
    @Results({
            @Result(property = "sex", column = "sex", javaType = UserSexEnum.class),
            @Result(property = "status", column = "status", javaType = UserStatusEnum.class, typeHandler = EnumOrdinalTypeHandler.class)
    })
    User getOne(int id);
}
