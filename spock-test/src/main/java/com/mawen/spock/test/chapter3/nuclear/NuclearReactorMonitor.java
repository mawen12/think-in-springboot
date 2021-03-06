package com.mawen.spock.test.chapter3.nuclear;

import java.util.ArrayList;
import java.util.List;

/**
 * 核反应堆检测器
 * @author mawen
 * @create 2022-02-07 17:02
 */
public class NuclearReactorMonitor {
    private int triggeredFireSensors = 0;
    private List<Float> radiationStatus = new ArrayList<>();
    private int currentPressure = 150;

    public void feedFireSensorData(int triggeredFireSensors) {
        this.triggeredFireSensors = triggeredFireSensors;
    }

    public void feedRadiationSensorData(List<Float> radiationStatus) {
        this.radiationStatus = radiationStatus;
    }

    public void feedPressureInBar(int bar) {
        this.currentPressure = bar;
    }

    public NuclearReactorStatus getCurrentStatus() {
        boolean radiationPresent = false;
        for (Float radiationMeter : radiationStatus) {
            if (radiationMeter > 100) {
                radiationPresent = true;
                break;
            }
        }
        boolean alarmStatus = (triggeredFireSensors > 0) || currentPressure > 150 || radiationPresent;
        boolean shutDownNeeded = (currentPressure > 160) || radiationPresent || (triggeredFireSensors > 1);
        int evacuationMinutes = -1;
        if (radiationPresent) {
            evacuationMinutes = 1;
        } else if (currentPressure > 160) {
            evacuationMinutes = 3;
        }
        return new NuclearReactorStatus(alarmStatus, shutDownNeeded, evacuationMinutes);
    }

}
