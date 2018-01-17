package com.wangtao.actuator;

import org.springframework.stereotype.Service;

/**
 * @author : wangtao
 * @date : 2018/1/17 10:07
 * 自定义端点 -- 1.1状态服务
 */
@Service
public class StatusService {
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
