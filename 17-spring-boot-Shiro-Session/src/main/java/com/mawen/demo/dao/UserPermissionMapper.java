package com.mawen.demo.dao;

import com.mawen.demo.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserPermissionMapper {

    List<Permission> findByUsername(String username);
}
