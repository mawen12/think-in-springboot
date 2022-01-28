package com.mawen.thinkin.springboot.quartz.controller;

import com.mawen.thinkin.springboot.quartz.job.EmailJob;
import com.mawen.thinkin.springboot.quartz.payload.ScheduleEmailRequest;
import com.mawen.thinkin.springboot.quartz.payload.ScheduleEmailResponse;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.ZonedDateTime;
import java.util.UUID;

/**
 * scheduler controller
 * @author mawen
 * @create 2022-01-27 17:44
 */
@Slf4j
@RestController
@RequestMapping("/api/email")
public class EmailJobSchedulerController {

    @Autowired
    private Scheduler scheduler;

    /**
     * 定时发送邮件
     * @param scheduleEmailRequest 请求体
     * @return 响应体
     */
    @PostMapping("/scheduleEmail")
    public ResponseEntity<ScheduleEmailResponse> scheduleEmail(@RequestBody ScheduleEmailRequest scheduleEmailRequest) {
        ZonedDateTime dateTime = ZonedDateTime.of(scheduleEmailRequest.getDateTime(), scheduleEmailRequest.getTimeZone());
        if (dateTime.isBefore(ZonedDateTime.now())) {
            ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(false, "dateTime must be after current time");
            return ResponseEntity.badRequest().body(scheduleEmailResponse);
        }

        JobDetail jobDetail = buildJobDetail(scheduleEmailRequest);
        Trigger trigger = buildJobTrigger(jobDetail, dateTime);

        try {
            scheduler.scheduleJob(jobDetail, trigger);

            ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(true, jobDetail.getKey().getName(), jobDetail.getKey().getGroup(), "Email Scheduled Successfully!");
            return ResponseEntity.ok(scheduleEmailResponse);
        } catch (SchedulerException e) {
            log.error("Error scheduling email", e);

            ScheduleEmailResponse scheduleEmailResponse = new ScheduleEmailResponse(false, "Error scheduling email, Please try later!");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(scheduleEmailResponse);
        }
    }

    private JobDetail buildJobDetail(ScheduleEmailRequest scheduleEmailRequest) {
        JobDataMap jobDataMap = new JobDataMap();

        jobDataMap.put("email", scheduleEmailRequest.getEmail());
        jobDataMap.put("subject", scheduleEmailRequest.getSubject());
        jobDataMap.put("body", scheduleEmailRequest.getBody());

        return JobBuilder.newJob(EmailJob.class)
                .withIdentity(UUID.randomUUID().toString(), "email-jobs")
                .withDescription("Send Email Job")
                .usingJobData(jobDataMap)
                .storeDurably()
                .build();
    }

    private Trigger buildJobTrigger(JobDetail jobDetail, ZonedDateTime startAt) {
        return TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .withIdentity(jobDetail.getKey().getName(), "email-triggers")
                .withDescription("Send Email Trigger")
                .startAt(Date.from(startAt.toInstant()))
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withMisfireHandlingInstructionFireNow())
                .build();
    }
}
