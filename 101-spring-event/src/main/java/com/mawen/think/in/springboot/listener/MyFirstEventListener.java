package com.mawen.think.in.springboot.listener;

import java.util.Random;

import com.mawen.think.in.springboot.event.MyEvent;

import org.springframework.context.ApplicationListener;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * MyEvent事件监听器
 * 
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 
 */
@Order(1)
@Component
public class MyFirstEventListener implements ApplicationListener<MyEvent> {
    Random random = new Random();

    @Override
    public void onApplicationEvent(MyEvent event) {
        System.out.println(this.toString() + " received: " + event);
        if (random.nextInt(10) % 2 == 1)
            throw new RuntimeException("exception happen on first listener");
    }
    
}
