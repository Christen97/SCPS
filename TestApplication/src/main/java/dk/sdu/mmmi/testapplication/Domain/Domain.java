package dk.sdu.mmmi.testapplication.Domain;

import dk.sdu.mmmi.co2sensor.sensor.CO2Sensor;
import dk.sdu.mmmi.co2sensor.sensor.ISensor;
import dk.sdu.mmmi.testapplication.temp.TemperatureSensor;

import java.util.ArrayList;

public class Domain {
    ArrayList<ISensor> sensors = null;

    public Domain() {
        sensors = new ArrayList<>();

        sensors.add(new CO2Sensor("CO2Sensor-1"));
        sensors.add(new TemperatureSensor("TemperatureSensor-1"));
    }

    public  ArrayList<SensorValues> getSensors() {
        ArrayList<SensorValues> sensorValues = new ArrayList<>();

        for (ISensor s : sensors) {
            sensorValues.add(new SensorValues(s.getValue(), s.getName()));
        }

        return sensorValues;
    }

}
