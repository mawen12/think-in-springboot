package com.mawen.demo.dao;

import com.mawen.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRoleMapper {

    List<Role> findByUsername(String name);
}
