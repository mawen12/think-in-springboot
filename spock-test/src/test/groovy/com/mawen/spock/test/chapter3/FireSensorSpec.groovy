package com.mawen.spock.test.chapter3

import com.mawen.spock.test.chapter3.fire.FireEarlyWarning
import spock.lang.Specification

class FireSensorSpec extends Specification {

    def "If all sensors are inactive everything is ok"() {
        given: "that all fire sensors are off" // setup
        def fireEarlyWarning = new FireEarlyWarning()
        int triggeredSensors = 0;

        when: "we ask the status of fire control" // stimulus
        fireEarlyWarning.feedData(triggeredSensors)
        def status = fireEarlyWarning.getCurrentStatus()

        then: "no alarm/notification should be triggered" // assert
        !status.alarmActive
        !status.fireDepartmentNotified
    }

    def "If one sensor is active the alarm should sound as a precaution"() {
        given: "that only one fire sensor is active"
        def fireEarlyWarning = new FireEarlyWarning()
        int triggeredSensors = 1

        when: "we ask the status of fire control"
        fireEarlyWarning.feedData(triggeredSensors)
        def status = fireEarlyWarning.getCurrentStatus()

        then: "only the alarm should be triggered"
        status.alarmActive
        !status.fireDepartmentNotified
    }

    def "If more than one sensor is active then we have a fire"() {
        given: "that two fire sensors are active"
        def warning = new FireEarlyWarning()
        int triggeredSensors = 2

        when: "we ask the status of fire control"
        warning.feedData(triggeredSensors)
        def status = warning.getCurrentStatus()

        then: "alarm is triggered and the fire department is notified"
        status.alarmActive
        status.fireDepartmentNotified
    }
}
