package com.mawen.think.in.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping(path = "hi", method = RequestMethod.GET)
    public String hi() {
        return "Hello World";
    }


}
