package com.mawen.spock.test.chapter3.coolant;

/**
 * 温度监控器
 *
 * @author mawen
 * @create 2022-02-07 18:21
 */
public class TemperatureMonitor {

    private final TemperatureReader reader;
    private TemperatureReadings lastReadings;
    private TemperatureReadings currentReadings;

    public TemperatureMonitor(TemperatureReader reader) {
        this.reader = reader;
    }

    public boolean isTemperatureNormal() {
        boolean firstSensorOK = Math.abs(lastReadings.getSensor1Data() - currentReadings.getSensor1Data()) < 20;
        boolean secondSensorOK = Math.abs(lastReadings.getSensor2Data() - currentReadings.getSensor2Data()) < 20;
        boolean thirdSensorOK = Math.abs(lastReadings.getSensor3Data() - currentReadings.getSensor3Data()) < 20;
        return firstSensorOK && secondSensorOK && thirdSensorOK;
    }

    public void readSensor() {
        lastReadings = currentReadings;
        currentReadings = reader.getCurrentReadings();
    }
}
