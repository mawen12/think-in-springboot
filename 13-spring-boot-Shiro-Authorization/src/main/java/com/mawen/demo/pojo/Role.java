package com.mawen.demo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Role implements Serializable {
    private static final long serialVersionUID = 258596383122982972L;

    private Integer id;
    private String name;
    private String memo;
}
