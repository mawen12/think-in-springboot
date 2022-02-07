package com.mawen.spock.test.chapter3.coolant;

import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

public class CoolantSensorTest {

    @Test
    public void temperatureWithinLimits() {
        TemperatureReadings prev = new TemperatureReadings();
        prev.setSensor1Data(20);
        prev.setSensor2Data(40);
        prev.setSensor3Data(80);

        TemperatureReadings current = new TemperatureReadings();
        current.setSensor1Data(30);
        current.setSensor2Data(45);
        current.setSensor3Data(73);

        TemperatureReader reader = Mockito.mock(TemperatureReader.class);
        Mockito.when(reader.getCurrentReadings()).thenReturn(prev, current);

//        Mockito.mock();
    }

}