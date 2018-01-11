# SpringBootTest 自学笔记
spring mvc

spring boot

mybatis

actuator

### 2018-1-10  第189页 ###

自动配置的核心注解
@ConditionalOnBean                  当容器有指定Bean的条件下
@ConditionalOnClass                 当类路径下有指定的类的条件下
@ConditionalOnExpression            基于SpEL表达式作为判断条件
@ConditionalOnJava                  基于JVM版本作为判断条件
@ConditionalOnJndi                  在JNDI存在的条件下查找指定的位置
@ConditionalOnMissingBean           当容器里没有指定Bean的情况下
@ConditionalOnMissingClass          当类路径下没有指定的类的情况下
@ConditionalOnNotWebApplication     当前项目不是web项目的条件下
@ConditionalOnProperty              指定的属性是否有指定的值
@ConditionalOnResource              类路径是否有指定的值
@ConditionalOnSingleCandidate       当指定Bean在容器中只有一个，或者虽然有多个但是指定首选的Bean
@ConditionalOnWebApplication        当前项目是web项目的条件下


### 2018-1-11  第189页 --> 第212页 ###
知识要点：
①Tomcat,Jetty,Undertow容器的自定义配置（配置文件，代码）
②SSL配置
③页面标题图标设置  Favicon
④WebSocket / SocketJS(WebSocket协议的模拟，增加了当浏览器不支持WebSocket的时候的兼容支持)
直接使用，开发繁琐，一般使用STOMP协议，基于帧(frame),与Http的request和response类型


