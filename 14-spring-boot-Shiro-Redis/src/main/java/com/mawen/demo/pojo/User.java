package com.mawen.demo.pojo;

import lombok.Data;
import org.crazycake.shiro.AuthCachePrincipal;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable, AuthCachePrincipal {
    private static final long serialVersionUID = -8108804981991754198L;

    private Integer id;
    private String name;
    private String password;
    private Date createTime;
    private String status;

    @Override
    public String getAuthCacheKey() {
        return String.valueOf(id);
    }
}
