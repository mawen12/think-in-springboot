package com.mawen.demo.dao;

import java.util.List;

import com.mawen.demo.pojo.Permission;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPermissionMapper {

    List<Permission> findByUsername(String username);
}
