package com.wangtao;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.Banner;
import org.springframework.boot.ResourceBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;

import java.io.File;

/**
 * @author : wangtao
 * @date : 2017/12/26 15:27
 */

@SpringBootApplication
@ComponentScan(basePackages = {"com.wangtao.thymeleaf", "com.wangtao.websocket"})
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

    /**
     * 配置容器
     */
//    @Component
//    public class MyContainer implements EmbeddedServletContainerCustomizer {
//        @Override
//        public void customize(ConfigurableEmbeddedServletContainer container) {
//            container.setPort(8998);
//            container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
//            container.setSessionTimeout(20, TimeUnit.MINUTES);
//            System.out.println("in StudyApplication ... ");
//        }
//    }
    @Bean
    public EmbeddedServletContainerFactory servletContainer() {
        TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
            @Override
            protected void postProcessContext(Context context) {
                SecurityConstraint constraint = new SecurityConstraint();
                constraint.setUserConstraint("CONFIDENTIAL");

                SecurityCollection collection = new SecurityCollection();
                collection.addPattern("/*");

                constraint.addCollection(collection);
                context.addConstraint(constraint);
            }
        };

        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setPort(8080);
        connector.setScheme("http");
        connector.setSecure(false);
        connector.setRedirectPort(8443);
        return connector;
    }
}
