package com.wangtao.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author : wangtao
 * @date : 2018/1/11 17:07
 */
@Configuration
@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public SessionRegistry sessionRegistry() {
        return new SessionRegistryImpl();
    }

    @Bean
    UserDetailsService cutomUserService() {
        System.out.println("加载了自定义的UserDetailsService。。。");
        return new CustomUserService();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(cutomUserService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
//                .successForwardUrl("/index")
                .defaultSuccessUrl("/index")
                .failureUrl("/login?error")
                .permitAll()
                //开启cookie
//                .and().rememberMe().tokenValiditySeconds(10000).key("mykey")
                .and().headers().frameOptions().disable()
                .and()
                .logout()
//                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .addLogoutHandler(new MyLogoutHandler())
//                .logoutSuccessUrl("/login")
                .permitAll()
//                .and().sessionManagement().maximumSessions(2).expiredUrl("/").sessionRegistry(sessionRegistry())
        ;

        // session管理
        http.sessionManagement().sessionFixation().changeSessionId()
                .maximumSessions(1).expiredUrl("/login?expired");
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        //内存中的用户
//        auth.inMemoryAuthentication()
//                .withUser("wangtao").password("wangtao").roles("USER")
//                .and()
//                .withUser("wt").password("wt").roles("USER");

        //jdbc中的用户
//        auth.jdbcAuthentication().dataSource(getApplicationContext().getBean(DataSource.class));

        //jdbc中的用户 自定义sql
//        auth.jdbcAuthentication().dataSource(getApplicationContext().getBean(DataSource.class));

        //自定义数据用户
//        auth.userDetailsService(cutomUserService());
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/**/*.html", "/**/*.js", "/**/*.css", "/jquery-ui-1.12.1/**", "/font-awesome/**");
    }


}
