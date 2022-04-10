package com.mawen.demo.service;

import com.mawen.demo.Application;
import com.mawen.demo.bean.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class StudentServiceTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void testLoad() {
        Student student = studentService.load("001");
        System.out.println("学号" + student.getSno() + "的学生姓名为" + student.getName());

        student = studentService.load("001");
        System.out.println("学号" + student.getSno() + "的学生姓名为" + student.getName());
    }

    @Test
    public void testUpdate() {
        Student student = studentService.load("001");
        System.out.println("学号" + student.getSno() + "的学生姓名为" + student.getName());

        student.setName("Mawen");
        studentService.update(student);

        student = studentService.load("001");
        System.out.println("学号" + student.getSno() + "的学生姓名为" + student.getName());
    }

    @Test
    public void testDelete() {
        Student student = studentService.load("001");
        System.out.println("学号" + student.getSno() + "的学生姓名为" + student.getName());

        studentService.deleteBySno("001");
    }


}