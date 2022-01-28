package com.mawen.thinkin.springboot.quartz.payload;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * 发送邮件请求
 *
 * @author mawen
 * @create 2022-01-27 17:18
 */
@Data
public class ScheduleEmailRequest {

    private String email;

    private String subject;

    private String body;

    private LocalDateTime dateTime;

    private ZoneId timeZone;
}
