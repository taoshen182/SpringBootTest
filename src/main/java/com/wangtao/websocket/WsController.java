package com.wangtao.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.util.StringUtils;

import java.security.Principal;

/**
 * @author : wangtao
 * @date : 2018/1/11 14:51
 */
@Controller
public class WsController {
    @MessageMapping("/welcome")
    @SendTo("/topic/getResponse")
    public MyResponse say(MyMsg myMsg) throws InterruptedException {
        Thread.sleep(1000);
        return new MyResponse("Welcome," + myMsg.getName() + "!");
    }

    @RequestMapping("/ws")
    public String ws() {
        return "ws";
    }


    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void handleChat(Principal principal, String msg) {
        System.out.println("principal = " + principal.toString());
        System.out.println("msg = " + msg.trim());

        if (StringUtils.equals("wangtao", principal.getName())) {
            messagingTemplate.convertAndSendToUser("wt", "/queue/notifications", principal.getName() + " send a msg to u . The msg is : " + msg.trim());
        }
        if (StringUtils.equals("wt", principal.getName())) {
            messagingTemplate.convertAndSendToUser("wangtao", "/queue/notifications", principal.getName() + " send a msg to u . The msg is : " + msg.trim());
        }

    }
}
