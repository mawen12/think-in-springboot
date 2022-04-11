package com.mawen.demo.bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class Student implements Serializable {
    private static final long serialVersionUID = -2659966693551961085L;

    private String sno;
    private String name;
    private Integer sex;
}
