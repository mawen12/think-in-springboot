package com.mawen.thinkin.springboot.eventdriven.event;

import org.springframework.context.ApplicationEvent;

/**
 * Event Object
 *
 * @author mawen
 * @create 2022-01-27 10:01
 */
public class CustomSpringEvent extends ApplicationEvent {

    private final String message;

    public CustomSpringEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
