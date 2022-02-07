package com.mawen.spock.test.chapter3.coolant;

/**
 * 提供温度读取的第三方接口
 *
 * @author mawen
 * @create 2022-02-07 18:20
 */
public interface TemperatureReader {

    TemperatureReadings getCurrentReadings();

}
