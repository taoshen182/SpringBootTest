package com.wangtao.study;

import com.wangtao.aop.AopConfig;
import com.wangtao.aop.AopService;
import com.wangtao.aop.NoAnnotationService;
import com.wangtao.beanlife.BeanConfig;
import com.wangtao.beanlife.BeanLifeService;
import com.wangtao.el.ElConfig;
import com.wangtao.event.EventConfig;
import com.wangtao.event.MyPublisher;
import com.wangtao.profile.ProfileConfig;
import com.wangtao.profile.ProfileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class StudyApplicationTests {

    @Test
    public void contextLoads() {
    }


    /**
     * el 表达式
     */
    @Test
    public void testValue() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ElConfig.class);
        ElConfig bean = context.getBean(ElConfig.class);
        bean.outputResource();
        context.close();
    }

    /**
     * bean的初始化和销毁
     */
    @Test
    public void testBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        BeanLifeService bean = context.getBean(BeanLifeService.class);
        System.out.println("bean = " + bean.getName());
        context.close();
    }

    /**
     * GenericApplicationContext does not support multiple refresh attempts: just call 'refresh' once
     */
    @Test
    public void testProfile() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //先将活动的Profile设置为prod
        context.getEnvironment().setActiveProfiles("dev");
        //后置注册Bean配置类，不然会报Bean未定义的错误
        context.register(ProfileConfig.class);
        //刷新容器
        context.refresh();

        System.out.println(context.getEnvironment());

        ProfileService prodBean = context.getBean(ProfileService.class);
        System.out.println("prodBean.getContent() = " + prodBean.getContent());

        context.close();
    }

    @Test
    public void testEvent() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(EventConfig.class);
        MyPublisher bean = context.getBean(MyPublisher.class);
        bean.publishMsg("hi my event");

        context.close();
    }

    @Test
    public void testAop() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AopConfig.class);
        AopService bean = context.getBean(AopService.class);
        bean.add();

        NoAnnotationService noAnnotationService = context.getBean(NoAnnotationService.class);
        noAnnotationService.doSome();
        context.close();
    }


    @Test
    public void testSecurity() throws IOException {
        AuthenticationManager am = new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication auth) throws AuthenticationException {
                if (auth.getName().equals(auth.getCredentials())) {
                    List<GrantedAuthority> AUTHORITIES = new ArrayList<GrantedAuthority>();
                    AUTHORITIES.add(new SimpleGrantedAuthority("ROLE_USER"));

                    return new UsernamePasswordAuthenticationToken(auth.getName(),
                            auth.getCredentials(), AUTHORITIES);
                }
                throw new BadCredentialsException("Bad Credentials");
            }
        };
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Please enter your username:");
            String name = in.readLine();
            System.out.println("Please enter your password:");
            String password = in.readLine();
            try {
                Authentication request = new UsernamePasswordAuthenticationToken(name, password);
                Authentication result = am.authenticate(request);
                SecurityContextHolder.getContext().setAuthentication(result);
                break;
            } catch (AuthenticationException e) {
                System.out.println("Authentication failed: " + e.getMessage());
            }
        }
        System.out.println("Successfully authenticated. Security context contains: " +
                SecurityContextHolder.getContext().getAuthentication());
    }


}
