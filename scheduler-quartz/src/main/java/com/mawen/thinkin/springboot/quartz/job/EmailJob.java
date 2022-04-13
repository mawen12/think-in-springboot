package com.mawen.thinkin.springboot.quartz.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

/**
 * Email Job For Scheduler
 *
 * @author mawen
 * @create 2022-01-27 17:51
 */
@Slf4j
@Component
public class EmailJob extends QuartzJobBean {

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Executing Job With key {}", context.getJobDetail().getKey());

        JobDataMap jobDataMap = context.getMergedJobDataMap();
        String subject = jobDataMap.getString("subject");
        String body = jobDataMap.getString("body");
        String recipientEmail = jobDataMap.getString("email");

        sendMail(null, recipientEmail, subject, body);
    }

    private void sendMail(String fromEmail, String toEmail, String subject, String body) {
        try {
            log.info("Sending Email to {}", toEmail);
            Thread.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
