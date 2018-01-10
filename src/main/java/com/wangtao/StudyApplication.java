package com.wangtao;

import com.wangtao.study.pojo.SysUser;
import com.wangtao.study.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.File;

/**
 * @author : wangtao
 * @date : 2017/12/26 15:27
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.wangtao.thymeleaf"})
//@MapperScan(basePackages = "com.wangtao.study.dao")
public class StudyApplication {

    public static void main(String[] args) {


        ConfigurableApplicationContext context = SpringApplication.run(StudyApplication.class, args);

//        UserService userService = context.getBean(UserService.class);

//        UserService userService = (UserService) context.getBean("userService");
//        SysUser admin = userService.findByName("admin");
        //将密码加密 可以先设置初始密码：000000
//        BCryptPasswordEncoder bc = new BCryptPasswordEncoder(4);
//        System.out.println("原始密码 = " + admin.getPassword());
//        admin.setPassword(bc.encode(admin.getPassword()));
//        System.out.println("密码" + admin.getPassword());

        //运行一次后记得注释这段重复加密会无法匹配*/
//        userService.update(admin);
    }

    public static void main2(String[] args) {
        SpringApplication app = new SpringApplication(StudyApplication.class);
        /*如果application.properties中配置了banner.location属性，则如下配置会被覆盖*/
        app.setBanner(new ResourceBanner(new FileSystemResource(new File("C:\\project\\wangtao\\SpringBootTest\\src\\main\\resources\\love.txt"))));
//        OFF  CONSOLE  LOG
        app.setBannerMode(Banner.Mode.CONSOLE);

        ConfigurableApplicationContext applicationContext = app.run(args);
    }
}
