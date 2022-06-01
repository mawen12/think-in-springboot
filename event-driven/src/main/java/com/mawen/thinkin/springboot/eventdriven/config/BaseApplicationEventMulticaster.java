package com.mawen.thinkin.springboot.eventdriven.config;

import java.util.function.Predicate;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.ResolvableType;
import org.springframework.util.ReflectionUtils;

/**
 * Custom ApplicationEventMulticaster to support
 * - ASYNC{@link com.mawen.thinkin.springboot.eventdriven.event.EventTypeEnum#ASYNC}
 * - SYNC{@link com.mawen.thinkin.springboot.eventdriven.event.EventTypeEnum#SYNC}
 *
 * @author mawen
 * @create 2022-01-27 11:05
 */
public class BaseApplicationEventMulticaster extends SimpleApplicationEventMulticaster {

    private static final String ON_APPLICATION_EVENT_NAME = "onApplicationEvent";

    private static final Predicate<ApplicationListener> methodExistsTest = x -> ReflectionUtils.findMethod(x.getClass(), ON_APPLICATION_EVENT_NAME, ApplicationEvent.class) != null;


    /**
     *
     * @param event
     */
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (ApplicationListener<?> listener : getApplicationListeners(event, ResolvableType.forInstance(event))) {
            // check onApplicationEvent


            // check @EventType



        }
    }
}
