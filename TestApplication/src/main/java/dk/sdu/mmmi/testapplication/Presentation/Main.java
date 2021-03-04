package dk.sdu.mmmi.testapplication.Presentation;

import dk.sdu.mmmi.testapplication.Domain.CO2Sensor;
import dk.sdu.mmmi.testapplication.Domain.TemperatureSensor;
import dk.sdu.mmmi.testapplication.Domain.ISensor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<ISensor> sensors = new ArrayList<>();
        sensors.add(new CO2Sensor("CO2Sensor-1"));
        sensors.add(new TemperatureSensor("TemperatureSensor-1"));

        while (true) {
            for (ISensor s: sensors) {
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
