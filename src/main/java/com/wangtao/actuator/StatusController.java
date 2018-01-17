package com.wangtao.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : wangtao
 * @date : 2018/1/17 10:15
 */
@RestController
public class StatusController {
    @Autowired
    StatusService statusService;

    @RequestMapping("/change")
    public String change(String status) {
        System.out.println("status = " + status);
        statusService.setStatus(status);
        return "OK";
    }
}
