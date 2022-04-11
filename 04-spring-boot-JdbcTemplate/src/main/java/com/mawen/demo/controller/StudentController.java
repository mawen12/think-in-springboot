package com.mawen.demo.controller;

import com.mawen.demo.bean.Student;
import com.mawen.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/load/{sno}")
    public Student queryStudent(@PathVariable("sno") String sno) {
        return this.studentService.queryBySno(sno);
    }

    @GetMapping("/list/all")
    public List<Map<String, Object>> queryAllStudent() {
        return this.studentService.queryStudentsListMap();
    }

    @PostMapping("/add")
    public int saveStudent(@RequestBody Student student) {
        return this.studentService.add(student);
    }

    @DeleteMapping("/delete/{sno}")
    public int deleteStudent(@PathVariable("sno") String sno) {
        return this.studentService.deleteBySno(sno);
    }

}
