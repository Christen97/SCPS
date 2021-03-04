package dk.sdu.mmmi.co2sensor.sensor;

import java.io.Serializable;

public class SensorData implements Serializable, ISensor {
    private final double value;
    private final String name;

    public SensorData(double value, String name){
        this.value = value;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getValue() {
        return this.value;
    }
}
