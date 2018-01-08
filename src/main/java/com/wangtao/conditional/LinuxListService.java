package com.wangtao.conditional;

/**
 * Created by want on 2018-1-8.
 */
public class LinuxListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
