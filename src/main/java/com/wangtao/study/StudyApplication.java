package com.wangtao.study;

import com.wangtao.study.pojo.SysUser;
import com.wangtao.study.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author : wangtao
 * @date : 2017/12/26 15:27
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.wangtao.study.controller", "com.wangtao.study.service"})
@MapperScan(basePackages = "com.wangtao.study.dao")
public class StudyApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(StudyApplication.class, args);

        UserService userService = context.getBean(UserService.class);

//        UserService userService = (UserService) context.getBean("userService");
        SysUser admin = userService.findByName("admin");
        //将密码加密 可以先设置初始密码：000000
        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);
        System.out.println("原始密码 = " + admin.getPassword());
        admin.setPassword(bc.encode(admin.getPassword()));
        System.out.println("密码" + admin.getPassword());

        //运行一次后记得注释这段重复加密会无法匹配*/
//        userService.update(admin);
    }
}
