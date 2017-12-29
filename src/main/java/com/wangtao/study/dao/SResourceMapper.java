package com.wangtao.study.dao;

import com.wangtao.study.pojo.UserSexEnum;
import com.wangtao.study.pojo.UserStatusEnum;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.type.EnumOrdinalTypeHandler;

import java.util.List;
import java.util.Map;

/**
 * @author : wangtao
 * @date : 2017/12/29 10:33
 */
@Mapper
public interface SResourceMapper {
    @Select("SELECT r.name, s.resourceString FROM  s_role r ,s_resource_role sr,s_resource s " +
            "where r.id=sr.roleId and sr.resourceId=s.id and r.name=#{auth}")
    @Results({
            @Result(property = "resource_string", column = "resourceString")
    })
    public List<Map<String, Object>> findByRoleName(String auth);
}
