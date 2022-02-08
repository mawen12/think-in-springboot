package com.mawen.spock.test.chapter3.coolant2;

import com.mawen.spock.test.chapter3.coolant.TemperatureReader;
import com.mawen.spock.test.chapter3.coolant.TemperatureReadings;

/**
 * 升级后的温度监控器
 *
 * @author mawen
 * @create 2022-02-08 9:32
 */
public class ImprovedTemperatureMonitor {
    private final TemperatureReader reader;
    private TemperatureReadings lastReadings;
    private TemperatureReadings currentReadings;
    private final ReactorControl reactorControl;

    public ImprovedTemperatureMonitor(TemperatureReader reader, ReactorControl reactorControl) {
        this.reader = reader;
        this.reactorControl = reactorControl;
    }

    private boolean isTemperatureDiffMoreThan(long degress) {
        boolean firstSensorTriggered = Math.abs(lastReadings.getSensor1Data() - currentReadings.getSensor1Data()) > degress;
        boolean secondSensorTriggered = Math.abs(lastReadings.getSensor2Data() - currentReadings.getSensor2Data()) > degress;
        boolean thirdSensorTriggered = Math.abs(lastReadings.getSensor3Data() - currentReadings.getSensor3Data()) > degress;
        return firstSensorTriggered || secondSensorTriggered || thirdSensorTriggered;
    }

    public void readSensor() {
        lastReadings = currentReadings;
        currentReadings = reader.getCurrentReadings();

        if (lastReadings == null) {
            return;
        }

        if (isTemperatureDiffMoreThan(20)) {
            reactorControl.activateAlarm();
        }

        if (isTemperatureDiffMoreThan(50)) {
            reactorControl.shutdownReactor();
        }
    }
}
