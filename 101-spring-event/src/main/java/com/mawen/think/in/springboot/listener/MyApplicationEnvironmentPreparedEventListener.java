package com.mawen.think.in.springboot.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationEnvironmentPreparedEvent 监听器
 *
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since
 * @see
 */
@Component
public class MyApplicationEnvironmentPreparedEventListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {

    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        System.out.println(this.toString() + " received: " + event);
    }
}
