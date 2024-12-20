package com.harvest.tempmatch.util;

import com.harvest.tempmatch.model.SensorState;

public class SensorStateUtil {
    public static SensorState getTempState(double temperature, double hotThreshold, double coldThreshold) {
        if (temperature >= hotThreshold) {
            return SensorState.HOT;
        } else if (temperature < coldThreshold) {
            return SensorState.COLD;
        } else {
            return SensorState.WARM;
        }
    }
}

