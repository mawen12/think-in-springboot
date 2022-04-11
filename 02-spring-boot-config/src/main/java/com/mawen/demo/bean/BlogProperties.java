package com.mawen.demo.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author mawen
 * @since 2022/04/08
 */
@Component
public class BlogProperties {

    @Value("${mawen.blog.name}")
    private String name;

    @Value("${mawen.blog.title}")
    private String title;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
