package com.wangtao.el;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author : wangtao
 * @date : 2018/1/5 17:57
 */
@Service
public class ELDemo {
    @Value("其他类的属性")
    private String author;

    @Value("${book.name}")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
