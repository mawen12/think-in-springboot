package com.mawen.thinkin.springboot.quartz.payload;

import lombok.Data;

/**
 * Schedule Email Response
 *
 * @author mawen
 * @create 2022-01-27 17:20
 */
@Data
public class ScheduleEmailResponse {

    private boolean success;

    private String jobId;

    private String jobGroup;

    private String message;

    public ScheduleEmailResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ScheduleEmailResponse(boolean success, String jobId, String jobGroup, String message) {
        this.success = success;
        this.jobId = jobId;
        this.jobGroup = jobGroup;
        this.message = message;
    }
}
