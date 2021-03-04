package dk.sdu.mmmi.testapplication.Presentation;

import dk.sdu.mmmi.co2sensor.sensor.CO2Sensor;
import dk.sdu.mmmi.co2sensor.sensor.SensorData;
import dk.sdu.mmmi.testapplication.Domain.Domain;
import dk.sdu.mmmi.testapplication.Domain.SensorValues;
import dk.sdu.mmmi.testapplication.temp.TemperatureSensor;
import dk.sdu.mmmi.co2sensor.sensor.ISensor;

import java.util.ArrayList;
import java.util.concurrent.atomic.DoubleAccumulator;

public class Main {
    public static void main(String[] args) {
        Domain domain = new Domain();

        while (true) {
            ArrayList<SensorValues> sensors = domain.getSensors();
            for (SensorValues s : sensors) {
                System.out.println("Sensors: " + s.getName() + ", Value: " + s.getValue());
            }
            System.out.println();

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
