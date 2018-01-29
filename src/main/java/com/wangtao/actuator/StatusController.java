package com.wangtao.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
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

    /**
     * 自定义接口访问次数
     */
    @Autowired
    private CounterService counterService;

    @RequestMapping("/change")
    public String change(String status) {
        counterService.increment("my.status.count");
        System.out.println("status = " + status);
        statusService.setStatus(status);
        return "OK";
    }
}
