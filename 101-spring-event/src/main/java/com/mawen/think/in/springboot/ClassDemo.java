package com.mawen.think.in.springboot;

public class ClassDemo extends AbstractDemo {

    @Override
    protected String name() {
        return "Class";
    }

    public void check() {
        super.check();
    }

    public static void main(String[] args) {
        new ClassDemo().check();
    }
}
