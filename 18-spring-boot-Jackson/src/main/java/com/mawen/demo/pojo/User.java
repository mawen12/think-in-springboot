package com.mawen.demo.pojo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class User implements Serializable {

    @JsonView(UserNameView.class)
    public String userName;

    @JsonView(AllUserFieldView.class)
    private int age;

    @JsonView(AllUserFieldView.class)
    public String password;

    @JsonView(AllUserFieldView.class)
    private Date birthday;

    public interface UserNameView {

    }

    public interface AllUserFieldView extends UserNameView {

    }
}
