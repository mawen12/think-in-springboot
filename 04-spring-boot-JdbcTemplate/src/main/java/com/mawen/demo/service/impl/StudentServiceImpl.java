package com.mawen.demo.service.impl;

import com.mawen.demo.bean.Student;
import com.mawen.demo.dao.StudentDao;
import com.mawen.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public int add(Student student) {
        return studentDao.add(student);
    }

    @Override
    public int update(Student student) {
        return studentDao.update(student);
    }

    @Override
    public int deleteBySno(String sno) {
        return studentDao.deleteBySno(sno);
    }

    @Override
    public List<Map<String, Object>> queryStudentsListMap() {
        return studentDao.queryStudentsListMap();
    }

    @Override
    public Student queryBySno(String sno) {
        return studentDao.queryBySno(sno);
    }
}
