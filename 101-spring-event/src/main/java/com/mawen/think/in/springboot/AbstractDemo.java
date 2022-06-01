package com.mawen.think.in.springboot;

public abstract class AbstractDemo {

    protected String name() {
        return "Abstract";
    }

    protected void check() {
        System.out.println(name());
    }
}
