package com.mawen.demo.service.impl;

import com.mawen.demo.dao.mysql1.StudentMySQL1Mapper;
import com.mawen.demo.dao.mysql2.StudentMySQL2Mapper;
import com.mawen.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMySQL1Mapper studentMySQL1Mapper;

    @Autowired
    private StudentMySQL2Mapper studentMySQL2Mapper;

    @Override
    public List<Map<String, Object>> getAllStudentFromMysql1() {
        return studentMySQL1Mapper.getAllStudents();
    }

    @Override
    public List<Map<String, Object>> getAllStudentFromMysql2() {
        return studentMySQL2Mapper.getAllStudents();
    }
}
