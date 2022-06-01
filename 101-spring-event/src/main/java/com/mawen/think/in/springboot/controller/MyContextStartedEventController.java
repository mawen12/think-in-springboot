package com.mawen.think.in.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyContextStartedEventController {

    @Autowired
    private AbstractApplicationContext applicationContext;

    @GetMapping("/start")
    public String start() {
        applicationContext.start();
        return "ok";
    }
}
