package dk.sdu.mmmi.testapplication.Presentation;

import dk.sdu.mmmi.testapplication.Domain.Domain;
import dk.sdu.mmmi.testapplication.Domain.SensorValues;

import java.util.ArrayList;

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
