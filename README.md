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


### 2018-1-12  第212页 --> 第242页 ###
①数据绑定
②docker 常用命令
    docker search 镜像名                Docker镜像检索
    docker pull 镜像名                  Docker镜像下载
    docker images                      镜像列表
    docker rmi image-id(镜像id)        镜像删除
    docker rmi $(docker images -q)      删除全部镜像
    docker ps                           容器列表，UP状态的
    docker ps -a                        全部容器
    docker stop 容器名称/容器id           停止容器
    docker start 容器名称/容器id          启动容器
    docker rm 容器名称/容器id             删除容器
    docker rm $(docker ps -a -q)         删除所有容器
    docker logs 容器名称/容器id           查看容器日志
    docker exec -it 容器名称/容器id bash  登录容器
    
    docker run                          
            -d                          detached 控制台不会被阻碍
            --name                      容器名称
            -p 8090:8080                


### 2018-1-14  第242页 --> 第350页 ###
①JPA
②REST 
@事务

### 2018-1-15  第350页 --> 第242页 ###
①数据库中的用户，默认配置。   JdbcDaoImpl.loadUserByUsername
sql :   select username,password,enabled
        from users where username = ?

        select username,authority
        from authorities where username = ?

        select g.id, g.group_name, ga.authority
        from groups g, group_members gm, group_authorities ga
        where gm.username = ? and g.id = ga.group_id and g.id = gm.group_id

users
        CREATE TABLE `users` (
          `username` varchar(255) NOT NULL,
          `password` varchar(255) default NULL,
          `enabled` varchar(255) default NULL,
          PRIMARY KEY  USING BTREE (`username`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

authorities
        CREATE TABLE `authorities` (
          `username` varchar(255) NOT NULL,
          `authority` varchar(255) default NULL,
          PRIMARY KEY  USING BTREE (`username`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

group_authorities
        CREATE TABLE `group_authorities` (
          `group_id` int(11) NOT NULL,
          `authority` varchar(255) default NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

group_members
        CREATE TABLE `group_members` (
          `group_id` int(11) NOT NULL,
          `username` varchar(255) default NULL
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

groups
        CREATE TABLE `groups` (
          `id` int(11) NOT NULL auto_increment,
          `group_name` varchar(255) default NULL,
          PRIMARY KEY  (`id`)
        ) ENGINE=InnoDB DEFAULT CHARSET=utf8;



AOP底层原理：
jdk动态代理和cglib动态代理
两种方法同时存在，各有优劣。jdk动态代理是由java内部的反射机制来实现的，cglib动态代理底层则是借助asm来实现的。
总的来说，反射机制在生成类的过程中比较高效，
而asm在生成类之后的相关执行过程中比较高效（可以通过将asm生成的类进行缓存，这样解决asm生成类过程低效问题）。
还有一点必须注意：jdk动态代理的应用前提，必须是目标类基于统一的接口。如果没有上述前提，jdk动态代理不能应用。
由此可以看出，jdk动态代理有一定的局限性，cglib这种第三方类库实现的动态代理应用更加广泛，且在效率上更有优势。




