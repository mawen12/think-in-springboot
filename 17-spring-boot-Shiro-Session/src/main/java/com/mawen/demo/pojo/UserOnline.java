package com.mawen.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserOnline implements Serializable {
    private static final long serialVersionUID = 3185794917486413599L;

    private String id;
    private String userId;
    private String username;
    private String host;
    private String systemHost;
    private String status;
    private Date startTimestamp;
    private Date lastAccessTime;
    private Long timeout;

}
