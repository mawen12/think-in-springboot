package com.mawen.spock.test.chapter3.fire;

/**
 * 火灾状态
 *
 * @author mawen
 * @create 2022-02-07 15:00
 */
public class WarningStatus {
    private final boolean alarmActive;
    private final boolean fireDepartmentNotified;

    public WarningStatus(boolean alarmActive, boolean fireDepartmentNotified) {
        this.alarmActive = alarmActive;
        this.fireDepartmentNotified = fireDepartmentNotified;
    }

    public boolean isAlarmActive() {
        return alarmActive;
    }

    public boolean isFireDepartmentNotified() {
        return fireDepartmentNotified;
    }
}
