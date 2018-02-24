package com.wangtao.study;

import com.wangtao.aop.AopConfig;
import com.wangtao.aop.AopService;
import com.wangtao.aop.NoAnnotationService;
import com.wangtao.asynctask.TaskConfig;
import com.wangtao.asynctask.TaskService;
import com.wangtao.aware.AwareConfig;
import com.wangtao.aware.AwareService;
import com.wangtao.beanlife.BeanConfig;
import com.wangtao.beanlife.BeanLifeService;
import com.wangtao.conditional.ConditionConfig;
import com.wangtao.conditional.ListService;
import com.wangtao.el.ElConfig;
import com.wangtao.event.EventConfig;
import com.wangtao.event.MyPublisher;
import com.wangtao.profile.ProfileConfig;
import com.wangtao.profile.ProfileService;
import com.wangtao.properties.HelloService;
import com.wangtao.properties.HelloServiceAutoConfiguration;
import com.wangtao.scheduledtask.ScheduledConfig;
import com.wangtao.thymeleaf.ThymeleafController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration //测试mvc
public class StudyApplicationTests {

    @Test
    public void contextLoads() {
    }

    //mvc
    private MockMvc mvc;

    //测试对应的controller
    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new ThymeleafController()).build();
    }

    //测试对应的请求
    @Test
    public void testAdmin() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/search").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("{\"name\":\"default\",\"address\":\"shanghai\",\"age\":26}")));
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

    /**
     * Spring Aware 为了让Bean获得Spring容器的服务。
     * ApplicationContext接口集成了MessageSource接口，ApplicationEventPublisher接口和ResourceLoader接口
     * 所以Bean继承ApplicationContextAware可以获得Spring容器的所有服务。我们可以选择性的实现接口
     *
     * @throws IOException
     */
    @Test
    public void testAware() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AwareConfig.class);
        AwareService bean = context.getBean(AwareService.class);
        bean.outputResult();
    }

    /**
     * 异步任务 多线程
     *
     * @throws InterruptedException
     */
    @Test
    public void testTask() throws InterruptedException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TaskConfig.class);
        TaskService taskService = context.getBean(TaskService.class);
        for (int i = 0; i < 10; i++) {
            taskService.testOne(i);
            taskService.testTwo(i);
        }
        context.close();
    }

    /**
     * 计划任务
     */
    @Test
    public void testSchedule() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ScheduledConfig.class);
        while (true) {

        }
//        context.close();

    }

    @Test
    public void testCondition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfig.class);
        ListService bean = context.getBean(ListService.class);
        System.out.println("当前操作系统是：" + context.getEnvironment().getProperty("os.name") + ", list cmd is : " + bean.showListCmd());


    }

    @Test
    public void testAutoConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HelloServiceAutoConfiguration.class);
        HelloService bean = context.getBean(HelloService.class);
        System.out.println("bean = " + bean.hashCode());
        String s = bean.sayHello();
        System.out.println("s = " + s);

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

    @Test
    public void testMd5() {
        Md5PasswordEncoder md5PasswordEncoder = new Md5PasswordEncoder();
        String s = md5PasswordEncoder.encodePassword("wangtao", "wangtao");
        System.out.println("s = " + s);
        String password = "wangtao";
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        System.out.println("hashedPassword = " + hashedPassword);
    }

    @Test
    public void testJCE() throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {

        byte[] data = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};
        // create a 64 bit secret key from raw bytes
        SecretKey key64 = new SecretKeySpec(
                new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07},
                "Blowfish");

        // create a cipher and attempt to encrypt the data block with our key
        Cipher c = Cipher.getInstance("Blowfish/ECB/NoPadding");
        c.init(Cipher.ENCRYPT_MODE, key64);
        c.doFinal(data);
        System.out.println("64 bit test: passed");

        // create a 192 bit secret key from raw bytes
        SecretKey key192 = new SecretKeySpec(
                new byte[]{0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07,
                        0x08, 0x09, 0x0a, 0x0b, 0x0c, 0x0d, 0x0e, 0x0f,
                        0x10, 0x11, 0x12, 0x13, 0x14, 0x15, 0x16, 0x17},
                "Blowfish");

        // now try encrypting with the larger key
        c.init(Cipher.ENCRYPT_MODE, key192);
        c.doFinal(data);

        System.out.println("192 bit test: passed");

        System.out.println("Tests completed");

    }
}
