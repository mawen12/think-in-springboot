package com.mawen.demo.dao.mysql1;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMySQL1Mapper {
    List<Map<String, Object>> getAllStudents();
}
