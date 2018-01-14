package com.wangtao.data.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Created by want on 2018-1-14.
 * 自定义模糊查询
 */
public interface PersonRepository2
//        extends CustomRepository<Person, Long>
{
    Page<Person> findByAddress(String address, Pageable pageable);
}
