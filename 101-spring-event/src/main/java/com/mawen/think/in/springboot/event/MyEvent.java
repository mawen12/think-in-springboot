package com.mawen.think.in.springboot.event;

import org.springframework.context.ApplicationEvent;

/**
 * 自定义事件
 * 
 * @author <a href="1181963012mw@gmail.com">mawen12</a>
 * @since 
 */
public class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }
    
}
