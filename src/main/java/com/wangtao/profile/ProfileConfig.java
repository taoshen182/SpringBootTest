package com.wangtao.profile;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author : wangtao
 * @date : 2018/1/8 15:45
 */
@Configuration
public class ProfileConfig {

    @Bean
    @Profile("dev")
    public ProfileService devProfileService() {
        return new ProfileService("from dev profile");
    }

    @Bean
    @Profile("prod")
    public ProfileService prodProfileService() {
        return new ProfileService("from prod profile");
    }

}
