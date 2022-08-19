package com.mawen.demo.mapper;

import com.mawen.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> listAll();

    Employee selectById(@Param("id") Long id);
}
