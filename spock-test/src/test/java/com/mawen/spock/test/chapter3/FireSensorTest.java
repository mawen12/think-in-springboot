package com.mawen.spock.test.chapter3;


import com.mawen.spock.test.chapter3.fire.FireEarlyWarning;
import com.mawen.spock.test.chapter3.fire.WarningStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FireSensorTest {

    @Test
    public void everythingIsOk() {
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning(); // setup
        int triggeredSensors = 0;

        fireEarlyWarning.feedData(triggeredSensors); // stimulus
        WarningStatus status = fireEarlyWarning.getCurrentStatus();

        Assertions.assertFalse(status.isAlarmActive(), "Expected no alarm"); // assert
        Assertions.assertFalse(status.isFireDepartmentNotified(), "No notifications");
    }

    @Test
    public void oneSensorIsTriggered() {
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning(); // setup
        int triggeredSensors = 1;

        fireEarlyWarning.feedData(triggeredSensors); // stimulus
        WarningStatus status = fireEarlyWarning.getCurrentStatus();

        Assertions.assertTrue(status.isAlarmActive(), "Alarm sounds"); // assert
        Assertions.assertFalse(status.isFireDepartmentNotified(), "No notifications");
    }


    @Test
    public void twoSensorIsTriggered() {
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning(); // setup
        int triggeredSensors = 2;

        fireEarlyWarning.feedData(triggeredSensors); // stimulus
        WarningStatus status = fireEarlyWarning.getCurrentStatus();

        Assertions.assertTrue(status.isAlarmActive(), "Alarm sounds"); // assert
        Assertions.assertTrue(status.isFireDepartmentNotified(), "Fire Department is notified");
    }

    @Test
    public void sensorsAreTriggered() {
        FireEarlyWarning fireEarlyWarning = new FireEarlyWarning(); // setup
        fireEarlyWarning.feedData(1);
        WarningStatus status = fireEarlyWarning.getCurrentStatus(); // stimulus

        Assertions.assertTrue(status.isAlarmActive(), "Alarm sounds"); // assert
        Assertions.assertFalse(status.isFireDepartmentNotified(), "No notifications");

        fireEarlyWarning.feedData(2); // setup
        WarningStatus status2 = fireEarlyWarning.getCurrentStatus(); // stimulus
        Assertions.assertTrue(status2.isAlarmActive(), "Alarm sounds"); // assert
        Assertions.assertTrue(status2.isFireDepartmentNotified(), "Fire Department is notified");
    }

}