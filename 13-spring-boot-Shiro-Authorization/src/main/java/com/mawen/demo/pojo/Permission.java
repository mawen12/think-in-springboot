package com.mawen.demo.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Permission implements Serializable {
    private static final long serialVersionUID = -7414194769400534999L;

    private Integer id;
    private String url;
    private String name;
}
