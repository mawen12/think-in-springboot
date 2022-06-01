package com.mawen.think.in.springboot.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

@Component
public class MyContextStarterEventListener implements ApplicationListener<ContextStartedEvent> {

    public MyContextStarterEventListener() {
        System.out.println("MyContextStarterEventListener init...");
    }

    @Override
    public void onApplicationEvent(ContextStartedEvent event) {
        System.out.println(this.toString() + " received: " + event);
    }
}
