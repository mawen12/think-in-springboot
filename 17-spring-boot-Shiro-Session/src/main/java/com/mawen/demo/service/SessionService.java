package com.mawen.demo.service;

import com.mawen.demo.pojo.UserOnline;

import java.util.List;

public interface SessionService {

    List<UserOnline> list();

    boolean forceLogout(String sessionId);
}
