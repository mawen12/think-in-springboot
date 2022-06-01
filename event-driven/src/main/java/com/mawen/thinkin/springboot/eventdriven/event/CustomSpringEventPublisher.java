package com.mawen.thinkin.springboot.eventdriven.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * publish CustomSpringEvent
 * ApplicationEvent provide
 *
 * @author mawen
 * @create 2022-01-27 10:03
 */
@Slf4j
@Component
public class CustomSpringEventPublisher {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void publishEvent(final String message) {
        log.debug("Publishing custom event, {}.", publisher.getClass());
        CustomSpringEvent customSpringEvent = new CustomSpringEvent(this, message);
        publisher.publishEvent(customSpringEvent);
        log.debug("Publish event end.");
    }

}
