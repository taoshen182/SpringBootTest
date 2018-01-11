package com.wangtao.websocket;

/**
 * @author : wangtao
 * @date : 2018/1/11 14:50
 */

public class MyResponse {
    private String responseMsg;

    public String getResponseMsg() {
        System.out.println("responseMsg = " + responseMsg);
        return responseMsg;
    }

    public MyResponse(String responseMsg) {

        this.responseMsg = responseMsg;
    }
}
