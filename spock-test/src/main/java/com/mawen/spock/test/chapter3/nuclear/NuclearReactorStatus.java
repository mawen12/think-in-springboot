package com.mawen.spock.test.chapter3.nuclear;

/**
 * 核反应堆状态
 *
 * @author mawen
 * @create 2022-02-07 17:04
 */
public class NuclearReactorStatus {
    private final boolean alarmActive;
    private final boolean shutDownNeeded;
    private final int evacuationMinutes;

    public NuclearReactorStatus(boolean alarmActive, boolean shutDownNeeded, int evacuationMinutes) {
        this.alarmActive = alarmActive;
        this.shutDownNeeded = shutDownNeeded;
        this.evacuationMinutes = evacuationMinutes;
    }

    public boolean isAlarmActive() {
        return alarmActive;
    }

    public boolean isShutDownNeeded() {
        return shutDownNeeded;
    }

    public int getEvacuationMinutes() {
        return evacuationMinutes;
    }
}
