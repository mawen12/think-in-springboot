package com.mawen.demo.service;

import com.mawen.demo.bean.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {
    int add(Student student);

    int update(Student student);

    int deleteBySno(String sno);

    List<Map<String, Object>> queryStudentsListMap();

    Student queryBySno(String sno);

}
