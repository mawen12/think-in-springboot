package com.mawen.thinkin.springboot.eventdriven.controller;

import com.mawen.thinkin.springboot.eventdriven.event.CustomSpringEventPublisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Event Controller
 *
 * @author mawen
 * @create 2022-01-27 11:37
 */
@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private CustomSpringEventPublisher publisher;

    @PostMapping("/publish")
    public String publishEvent(String message) {
        publisher.publishEvent(message);
        return message;
    }
}
