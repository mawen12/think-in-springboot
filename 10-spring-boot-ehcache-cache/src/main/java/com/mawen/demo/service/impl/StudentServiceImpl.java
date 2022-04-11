package com.mawen.demo.service.impl;

import com.mawen.demo.bean.Student;
import com.mawen.demo.mapper.StudentMapper;
import com.mawen.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    @Transactional
    public Student update(Student student) {
        studentMapper.update(student);
        return studentMapper.selectBySno(student.getSno());
    }

    @Override
    @Transactional
    public void deleteBySno(String sno) {
        studentMapper.deleteBySno(sno);
    }

    @Override
    public Student load(String sno) {
        return studentMapper.selectBySno(sno);
    }
}
