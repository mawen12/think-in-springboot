package com.mawen.demo.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mawen.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class JsonController {

    @Autowired
    private ObjectMapper mapper;

    @JsonView(User.AllUserFieldView.class)
    @RequestMapping("/get")
    @ResponseBody
    public User getUser() {
        User user = new User();
        user.setUserName("mawen");
        user.setAge(26);
        user.setPassword("123456");
        user.setBirthday(new Date());
        return user;
    }

    @RequestMapping("/serializer")
    @ResponseBody
    public String serializer() {
        String json = "{\"name\":\"mawen\", \"age\":26}";
        try {
            JsonNode node = mapper.readTree(json);
            String name = node.get("name").asText();
            int age = node.get("age").asInt();
            return name + " " + age;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/format")
    @ResponseBody
    public String format() {
        User user = new User();
        user.setUserName("mawen");
        user.setAge(26);
        user.setPassword("123456");
        user.setBirthday(new Date());
        try {
            return mapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/update")
    @ResponseBody
    public int updateUser(@RequestBody List<User> list) {
        return list.size();
    }

    @RequestMapping("/custom")
    @ResponseBody
    public String customize() throws JsonProcessingException {
        String jsonStr = "[{\"userName\":\"mrbird\",\"age\":26},{\"userName\":\"scott\",\"age\":27}]";
        JavaType type = mapper.getTypeFactory().constructParametricType(List.class, User.class);
        List<User> list = mapper.readValue(jsonStr, type);
        return list.stream().map(User::getUserName).collect(Collectors.joining());
    }

}
