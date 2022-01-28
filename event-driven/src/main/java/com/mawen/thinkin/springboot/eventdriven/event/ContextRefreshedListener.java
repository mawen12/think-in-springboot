package com.mawen.thinkin.springboot.eventdriven.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * listen context refresh asynchronously
 *
 * @author mawen
 * @create 2022-01-27 10:34
 */
@Slf4j
@Component
public class ContextRefreshedListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        log.debug("Handling context refreshed event.");
    }
}
