package com.mawen.think.in.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Autowired
    private ManagedBeanDemo managedBeanDemo;

    @Autowired
    private ServiceImpl service;

    @RequestMapping(path = "hi1", method = RequestMethod.GET)
    public String hi() {
        managedBeanDemo.print();
        System.out.println(service.getServiceName());
        return "Hello World1!";
    }
}
