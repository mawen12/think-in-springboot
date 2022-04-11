package com.mawen.demo.dao;

import com.mawen.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.Date;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM user")
    @Results(id = "user", value = {
            @Result(property = "id", column = "id", javaType = Integer.class, id = true),
            @Result(property = "name", column = "name", javaType = String.class),
            @Result(property = "password", column = "password", javaType = String.class),
            @Result(property = "createTime", column = "create_time", javaType = Date.class),
            @Result(property = "status", column = "status", javaType = String.class),
    })
    User selectByUsername(String username);
}
