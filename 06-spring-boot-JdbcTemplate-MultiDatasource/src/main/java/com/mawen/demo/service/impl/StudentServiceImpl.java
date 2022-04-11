package com.mawen.demo.service.impl;

import com.mawen.demo.dao.StudentDao;
import com.mawen.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    @Qualifier("mysql1StudentDao")
    private StudentDao mysql1StudentDao;

    @Autowired
    @Qualifier("mysql2StudentDao")
    private StudentDao mysql2StudentDao;

    @Override
    public List<Map<String, Object>> listAllFromMySQL1() {
        return mysql1StudentDao.getAllStudents();
    }

    @Override
    public List<Map<String, Object>> listAllFromMySQL2() {
        return mysql2StudentDao.getAllStudents();
    }
}
