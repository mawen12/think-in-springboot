package com.mawen.thinkin.springboot.eventdriven.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * listen CustomSpringEvent
 * two type:
 * - ApplicationListener#onApplicationEvent
 * - @EventListener
 *
 * @author mawen
 * @create 2022-01-27 10:05
 */
@Slf4j
@Component
public class CustomSpringEventListener implements ApplicationListener<CustomSpringEvent> {

    @Override
    public void onApplicationEvent(CustomSpringEvent event) {
        log.debug("Received custom spring event - " + event.getMessage());
    }

    @EventListener
    public void handle(CustomSpringEvent event) {
        log.debug("Received custom spring event - " + event.getMessage());
    }
}
