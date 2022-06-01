package com.mawen.think.in.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(
//        scanBasePackages = "com.mawen.think.in.controller"
)
@ComponentScan(basePackages = {"com.mawen.think.in.controller"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
    public String serviceName() {
        return "This is ServiceImpl";
    }
}
