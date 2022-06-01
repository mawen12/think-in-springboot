package com.mawen.demo.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Configuration 会创建一个代理类
 * @Component 只会创建一个实例
 *
 *
 * @author mawen
 * @since 2022/04/08
 */
@Component
@ConfigurationProperties(prefix = "test")
@PropertySource("classpath:test.properties")
public class TestConfigBean {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
