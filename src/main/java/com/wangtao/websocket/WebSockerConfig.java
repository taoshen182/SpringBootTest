package com.wangtao.websocket;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

/**
 * @author : wangtao
 * @date : 2018/1/11 14:42
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSockerConfig extends AbstractWebSocketMessageBrokerConfigurer {
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        String point = "/myendpoint";
        System.out.println("WebSockerConfig registerStompEndpoints : " + point);
        registry.addEndpoint(point).withSockJS();
        registry.addEndpoint("/endpointchat").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        String broker = "/topic";
        String chat = "/queue";
        System.out.println("WebSockerConfig configureMessageBroker :  " + broker);
        registry.enableSimpleBroker(broker, chat);
    }
}
