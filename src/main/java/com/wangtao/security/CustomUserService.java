package com.wangtao.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author : wangtao
 * @date : 2018/1/15 16:26
 */

public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository sysUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser byUserName = sysUserRepository.findByUsername(username);
        if (byUserName == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("byUserName = " + byUserName.toString());
        return byUserName;
    }
}
