package com.mawen.thinkin.springboot.eventdriven.event;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Test publish customSpringEvent
 */
@SpringBootTest
public class CustomSpringEventPublisherTest {

    @Autowired
    private CustomSpringEventPublisher publisher;

    /**
     * by default Spring Events is synchronous, so it can join
     */
    @Test
    public void testPublishCustomEvent() {
        String message = "Hello World!";
        publisher.publishEvent(message);
    }

}