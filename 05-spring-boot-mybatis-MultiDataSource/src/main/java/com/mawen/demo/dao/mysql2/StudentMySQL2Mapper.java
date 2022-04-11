package com.mawen.demo.dao.mysql2;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMySQL2Mapper {
    List<Map<String, Object>> getAllStudents();
}
