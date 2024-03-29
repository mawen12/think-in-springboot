package com.mawen.spock.test.chapter3.coolant2

import com.mawen.spock.test.chapter3.coolant.TemperatureReader
import com.mawen.spock.test.chapter3.coolant.TemperatureReadings
import spock.lang.Specification

class ImprovedCoolantSensorSpec extends Specification {

    def "If current temperature difference is within limits everything is ok"() {
        given: "that temperature readings are within limits"
        def prev = new TemperatureReadings(sensor1Data: 20, sensor2Data: 40, sensor3Data: 80)
        def current = new TemperatureReadings(sensor1Data: 30, sensor2Data: 45, sensor3Data: 73)
        def reader = Stub(TemperatureReader)
        reader.getCurrentReadings() >>> [prev, current]

        def control = Mock(ReactorControl)
        def monitor = new ImprovedTemperatureMonitor(reader, control)

        when: "we ask the status of temperature control"
        monitor.readSensor()
        monitor.readSensor()

        then: "everything should be ok"
        0 * control.shutdownReactor()
        0 * control.activateAlarm()
    }

    def "If current temperature difference if more than 20 degress the alarm sounds"() {
        given: "that temperature readings are not within limits"
        def prev = new TemperatureReadings(sensor1Data: 20, sensor2Data: 40, sensor3Data: 80)
        def current = new TemperatureReadings(sensor1Data: 30, sensor2Data: 10, sensor3Data: 73)
        def reader = Stub(TemperatureReader)
        reader.getCurrentReadings() >>> [prev, current]

        def control = Mock(ReactorControl)
        def monitor = new ImprovedTemperatureMonitor(reader, control)

        when: "we ask the status of temperature control"
        monitor.readSensor()
        monitor.readSensor()

        then: "the alarm should sound"
        0 * control.shutdownReactor()
        1 * control.activateAlarm()
    }

    def "Testing of all 3 sensors with temperatures that rize and fall"() {
        given: "various temperature readings"
        def prev = new TemperatureReadings(sensor1Data: previousTemp[0], sensor2Data: previousTemp[1], sensor3Data: previousTemp[2])
        def current = new TemperatureReadings(sensor1Data: currentTemp[0], sensor2Data: currentTemp[1], sensor3Data: currentTemp[2])
        def reader = Stub(TemperatureReader)

        reader.currentReadings >>> [prev, current]

        def control = Mock(ReactorControl)
        def monitor = new ImprovedTemperatureMonitor(reader, control)

        when: "we ask the status of temperature control"
        monitor.readSensor() // mock方法被调用
        monitor.readSensor()

        then: "the alarm should sound and the reactor should shut down if needed"
        shutDown * control.shutdownReactor() // 验证模拟对象被调用
        alarm * control.activateAlarm()

        where: "possible temperatures are:"
        previousTemp | currentTemp        || alarm | shutDown
        [20, 30, 40] | [25, 15, 43.2]     || 0     | 0
        [20, 30, 40] | [13.3, 37.8, 39.2] || 0     | 0
        [20, 30, 40] | [50, 15, 43.2]     || 1     | 0
        [20, 30, 40] | [-20, 15, 43.2]    || 1     | 0
        [20, 30, 40] | [100, 15, 43.2]    || 1     | 1
        [20, 30, 40] | [-80, 15, 43.2]    || 1     | 1
        [20, 30, 40] | [20, 55, 43.2]     || 1     | 0
        [20, 30, 40] | [20, 8, 43.2]      || 1     | 0
        [20, 30, 40] | [21, 100, 43.2]    || 1     | 1
        [20, 30, 40] | [22, -40, 43.2]    || 1     | 1
        [20, 30, 40] | [20, 35, 76]       || 1     | 0
        [20, 30, 40] | [20, 31, 13.2]     || 1     | 0
        [20, 30, 40] | [21, 33, 97]       || 1     | 1
        [20, 30, 40] | [22, 39, -22]      || 1     | 1
    }

    def "Testing of all 3 sensors with temperatures that rize and fall with mock"() {
        given: "various temperature readings"
        def prev = new TemperatureReadings(sensor1Data: previousTemp[0], sensor2Data: previousTemp[1], sensor3Data: previousTemp[2])
        def current = new TemperatureReadings(sensor1Data: currentTemp[0], sensor2Data: currentTemp[1], sensor3Data: currentTemp[2])
        def reader = Mock(TemperatureReader)

        reader.currentReadings >>> [prev, current]

        def control = Mock(ReactorControl)
        def monitor = new ImprovedTemperatureMonitor(reader, control)

        when: "we ask the status of temperature control"
        monitor.readSensor()
        monitor.readSensor()

        then: "the alarm should sound and the reactor should shut down if needed"
        shutDown * control.shutdownReactor()
        alarm * control.activateAlarm()

        where: "possible temperatures are:"
        previousTemp | currentTemp        || alarm | shutDown
        [20, 30, 40] | [25, 15, 43.2]     || 0     | 0
        [20, 30, 40] | [13.3, 37.8, 39.2] || 0     | 0
        [20, 30, 40] | [50, 15, 43.2]     || 1     | 0
        [20, 30, 40] | [-20, 15, 43.2]    || 1     | 0
        [20, 30, 40] | [100, 15, 43.2]    || 1     | 1
        [20, 30, 40] | [-80, 15, 43.2]    || 1     | 1
        [20, 30, 40] | [20, 55, 43.2]     || 1     | 0
        [20, 30, 40] | [20, 8, 43.2]      || 1     | 0
        [20, 30, 40] | [21, 100, 43.2]    || 1     | 1
        [20, 30, 40] | [22, -40, 43.2]    || 1     | 1
        [20, 30, 40] | [20, 35, 76]       || 1     | 0
        [20, 30, 40] | [20, 31, 13.2]     || 1     | 0
        [20, 30, 40] | [21, 33, 97]       || 1     | 1
        [20, 30, 40] | [22, 39, -22]      || 1     | 1
    }
}
