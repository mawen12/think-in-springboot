package com.mawen.demo.dao;

import com.mawen.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    @Select("SELECT * FROM role where name = #{name}")
    @Results(id = "user", value = {
            @Result(property = "id", column = "id", id = true),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "memo", column = "memo", javaType = String.class)
    })
    List<Role> findByUsername(String name);
}
