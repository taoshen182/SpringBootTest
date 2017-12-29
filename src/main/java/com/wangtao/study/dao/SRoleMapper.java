package com.wangtao.study.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author : wangtao
 * @date : 2017/12/29 10:35
 */
@Mapper
public interface SRoleMapper {
    @Select("select r.name from s_role r")
    List<Map<String, Object>> findAll();
}
