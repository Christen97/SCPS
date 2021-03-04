package dk.sdu.mmmi.testapplication.Domain;

public class CO2Sensor implements ISensor {

    private final dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor co2Sensor;
    private final String name;

    public CO2Sensor(String name) {
        this.co2Sensor = new dk.sdu.mmmi.st4.scfs.sensors.CO2Sensor(name);
        this.name = name;

        this.co2Sensor.start();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Double getValue() {
        return Double.valueOf(this.co2Sensor.getValue());
    }
}
