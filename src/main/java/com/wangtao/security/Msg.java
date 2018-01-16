package com.wangtao.security;

/**
 * @author : wangtao
 * @date : 2018/1/15 16:21
 */

public class Msg {
    private String msg;
    private String content;
    private String etraInfo;

    public Msg(String msg, String content, String etraInfo) {
        this.msg = msg;
        this.content = content;
        this.etraInfo = etraInfo;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }
}
