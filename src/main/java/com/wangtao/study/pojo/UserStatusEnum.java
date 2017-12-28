package com.wangtao.study.pojo;

/**
 * @author : wangtao
 * @date : 2017/12/28 14:18
 */

public enum UserStatusEnum {
    NORMAL(1, "正常"),
    DELETE(2, "删除"),
    FROZEN(0, "冻结");


    private int index;
    private String statusName;

    UserStatusEnum(int index, String statusName) {
        this.index = index;
        this.statusName = statusName;
    }

    public int getIndex() {
        return index;
    }


    public String getStatusName() {
        return statusName;
    }


}
