package com.wangtao.security;

import org.apache.ibatis.annotations.Insert;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author : wangtao
 * @date : 2018/1/15 16:23
 */

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    SysUser findByUsername(String username);

//    @Insert("insert into sys_user (password,username) values (#{password},#{username});")
//    boolean addUser(String password, String username);
}
