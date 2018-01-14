package com.wangtao.data.jpa;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by want on 2018-1-13.
 */
//@Repository  //这里不需要注解 jpa自动注册
public interface PersonRepository extends JpaRepository<Person, Long>
{
    List<Person> findByName(String name);

    List<Person> findByName(String name, Sort sort);

    @Query("select p from Person p where p.address=?1")
    List<Person> findByAddress(String address);

    @Query("select p from Person p where p.address=:addr")
    List<Person> findByAddress2(@Param("addr") String address);

    List<Person> findByNameLike(String name);

    List<Person> findByNameAndAddress(String name, String address);

    List<Person> findFirst10ByName(String name);

    @Modifying
    @Transactional
    @Query("update Person p set p.name=?1")
    int setName(String name);

    @Modifying
    @Transactional
    @Query("update Person p set p.address=?1")
    int setAddress(String address);

    Page<Person> findByName(String name, Pageable pageable);
}
