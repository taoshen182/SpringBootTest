package com.wangtao.profile;

import org.springframework.stereotype.Service;

/**
 * @author : wangtao
 * @date : 2018/1/8 15:44
 */
@Service
public class ProfileService {
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProfileService(String content) {

        this.content = content;
    }
}
