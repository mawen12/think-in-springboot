package com.mawen.think.in.springboot.beans;

import org.springframework.context.Lifecycle;
import org.springframework.stereotype.Component;

/**
 * 自定义生命周期Bean
 *
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since
 */
@Component
public class MyLifeCycle implements Lifecycle {

    private volatile boolean running = false;

    @Override
    public void start() {
        System.out.println("lifeCycle start");
        running = true;
    }

    @Override
    public void stop() {
        System.out.println("lifeCycle stop");
        running = false;
    }

    @Override
    public boolean isRunning() {
        return running;
    }
}
