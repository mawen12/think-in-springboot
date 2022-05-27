package com.mawen.think.in.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class ServiceImpl {

    private String serviceName;

    public ServiceImpl (String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }
}
