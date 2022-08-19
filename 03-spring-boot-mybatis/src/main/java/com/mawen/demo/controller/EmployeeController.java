package com.mawen.demo.controller;

import com.mawen.demo.entity.Employee;
import com.mawen.demo.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/em")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;

    @GetMapping("/all")
    @ResponseBody
    public List<Employee> listAll() {
        return employeeMapper.listAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Employee load(@PathVariable("id") Long id) {
        System.out.println("111");
        return employeeMapper.selectById(id);
    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "Hello World";
    }

}
