package com.mawen.demo.controller;

import com.mawen.demo.pojo.ResponseBo;
import com.mawen.demo.pojo.UserOnline;
import com.mawen.demo.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/online")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping("/index")
    public String online() {
        return "online";
    }

    @ResponseBody
    @RequestMapping("list")
    public List<UserOnline> list() {
        return sessionService.list();
    }

    @ResponseBody
    @RequestMapping("/forceLogout")
    public ResponseBo forceLogout(String id) {
        sessionService.forceLogout(id);
        return ResponseBo.ok();
    }
}
