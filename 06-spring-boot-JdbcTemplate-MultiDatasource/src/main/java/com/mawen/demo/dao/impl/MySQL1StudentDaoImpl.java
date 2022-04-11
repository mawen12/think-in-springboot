package com.mawen.demo.dao.impl;

import com.mawen.demo.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("mysql1StudentDao")
public class MySQL1StudentDaoImpl implements StudentDao {

    @Autowired
    @Qualifier("mysql1JdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> getAllStudents() {
        return jdbcTemplate.queryForList("SELECT * FROM student");
    }
}
