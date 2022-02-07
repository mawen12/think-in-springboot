package com.mawen.spock.test.chapter3.fire;

/**
 * 火灾报警
 *
 * @author mawen
 * @create 2022-02-07 14:59
 */
public class FireEarlyWarning {

    private int sensorDetectingFire = 0;

    /**
     * 传感器采集信息
     * @param triggeredFireSensors
     */
    public void feedData(int triggeredFireSensors) {
        sensorDetectingFire = triggeredFireSensors;
    }

    /**
     * 获取当前状态
     * @return
     */
    public WarningStatus getCurrentStatus() {
        return new WarningStatus(sensorDetectingFire > 0, sensorDetectingFire > 1);
    }
}
