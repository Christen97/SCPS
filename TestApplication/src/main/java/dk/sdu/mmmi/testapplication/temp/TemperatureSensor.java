package dk.sdu.mmmi.testapplication.temp;

import dk.sdu.mmmi.co2sensor.sensor.ISensor;

public class TemperatureSensor implements ISensor {

    private final dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor temperatureSensor;
    private final String name;

    public TemperatureSensor(String name) {
        this.temperatureSensor = new dk.sdu.mmmi.st4.scfs.sensors.TemperatureSensor();
        this.name = name;

        this.temperatureSensor.start();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Double getValue() {
        return (Double) this.temperatureSensor.value();
    }
}
