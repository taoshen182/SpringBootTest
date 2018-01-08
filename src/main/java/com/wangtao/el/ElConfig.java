package com.wangtao.el;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author : wangtao
 * @date : 2018/1/5 18:04
 */
@Configuration
@ComponentScan("com.wangtao.el")
//test.properties 放在java目录下死活不行啊！！！
@PropertySource(value = {"classpath:wangtao/test.properties",
        "classpath:config.properties",
        "classpath:db.properties"})
public class ElConfig {

    /**
     * 1、普通字符串
     */
    @Value("ELConfig的作者")
    private String author;

    /**
     * 2、操作系统属性
     */
    @Value("#{systemProperties['os.name']}")
    private String osName;

    /**
     * 3、表达式结果
     */
    @Value("#{T(java.lang.Math).random()*100}")
    private double randomNumber;
    /**
     * 4、其他类属性
     */
    @Value("#{elService.author}")
    private String another;
    /**
     * 5、资源文件
     */
    @Value("classpath:wangtao/aaa.txt")
    private Resource testFile;
    /**
     * 6、网址
     */
    @Value("http://www.baidu.com")
    private Resource testUrl;

    /*---------------------------- 7 属性文件 start -----------------*/
    @Value("${book.name}")
    private String bookName;

    @Autowired
    private Environment environment;

    /**
     * 要想使用@Value 用${}占位符注入属性，这个bean是必须的，
     * 这个就是占位bean,另一种方式是不用value直接用Envirment变量直接getProperty('key')
     *
     * @return
     */
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

      /*---------------------------- 7 属性文件 end -----------------*/

    public void outputResource() {
        System.out.println("author is : " + author);
        System.out.println("osName is : " + osName);
        System.out.println("randomNumber is : " + randomNumber);
        System.out.println("another is : " + another);
        try {
            System.out.println("testFile is : " + testFile.getFile().getName() + ", size : " + testFile.getFile().length());
            System.out.println("testUrl is : " + testUrl.getURI());
            System.out.println("bookName is : " + bookName);
            System.out.println("environment is : " + environment.getProperty("book.author"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
