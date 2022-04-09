package com.mawen.demo.controller;

import com.mawen.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/list/mysql1/all")
    public List<Map<String, Object>> listAllFromMySQL1() {
        return studentService.listAllFromMySQL1();
    }

    @GetMapping("/list/mysql2/all")
    public List<Map<String, Object>> listAllFromMySQL2() {
        return studentService.listAllFromMySQL2();
    }

}
