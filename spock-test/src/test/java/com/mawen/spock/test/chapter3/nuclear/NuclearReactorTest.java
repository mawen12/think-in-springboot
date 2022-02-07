package com.mawen.spock.test.chapter3.nuclear;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@RunWith(Parameterized.class)
public class NuclearReactorTest {
    private final int triggeredFireSensors;
    private final List<Float> radiationDataReadings;
    private final int pressure;

    private final boolean expectedAlarmStatus;
    private final boolean expectedShutdownCommand;
    private final int expectedMinutesToEvacuate;

    public NuclearReactorTest(int pressure, int triggeredFireSensors, List<Float> radiationDataReadings, boolean expectedAlarmStatus, boolean expectedShutdownCommand, int expectedMinutesToEvacuate) {
        this.triggeredFireSensors = triggeredFireSensors;
        this.radiationDataReadings = radiationDataReadings;
        this.pressure = pressure;
        this.expectedAlarmStatus = expectedAlarmStatus;
        this.expectedShutdownCommand = expectedShutdownCommand;
        this.expectedMinutesToEvacuate = expectedMinutesToEvacuate;
    }

    @Test
    public void nuclearReactorScenario() {
        NuclearReactorMonitor nuclearReactorMonitor = new NuclearReactorMonitor();

        nuclearReactorMonitor.feedFireSensorData(triggeredFireSensors);
        nuclearReactorMonitor.feedRadiationSensorData(radiationDataReadings);
        nuclearReactorMonitor.feedPressureInBar(pressure);
        NuclearReactorStatus status = nuclearReactorMonitor.getCurrentStatus();

        Assertions.assertEquals(expectedAlarmStatus, status.isAlarmActive(), "Expected no alarm");
        Assertions.assertEquals(expectedShutdownCommand, status.isShutDownNeeded(), "No notifications 1");
        Assertions.assertEquals(expectedMinutesToEvacuate, status.getEvacuationMinutes(), "No notifications 2");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays
                .asList(new Object[][]{
                        {150, 0, new ArrayList<Float>(), false, false, -1},
                        {150, 1, new ArrayList<Float>(), true, false, -1},
                        {150, 3, new ArrayList<Float>(), true, true, -1},
                        {150, 0, Arrays.asList(110.4f, 0.3f, 0.0f), true,
                                true, 1},
                        {150, 0, Arrays.asList(45.3f, 10.3f, 47.7f), false,
                                false, -1},
                        {155, 0, Arrays.asList(0.0f, 0.0f, 0.0f), true, false,
                                -1},
                        {170, 0, Arrays.asList(0.0f, 0.0f, 0.0f), true, true,
                                3},
                        {180, 0, Arrays.asList(110.4f, 0.3f, 0.0f), true,
                                true, 1},
                        {500, 0, Arrays.asList(110.4f, 300f, 0.0f), true,
                                true, 1},
                        {30, 0, Arrays.asList(110.4f, 1000f, 0.0f), true,
                                true, 1},
                        {155, 4, Arrays.asList(0.0f, 0.0f, 0.0f), true, true,
                                -1},
                        {170, 1, Arrays.asList(45.3f, 10.3f, 47.7f), true,
                                true, 3},});

    }
}