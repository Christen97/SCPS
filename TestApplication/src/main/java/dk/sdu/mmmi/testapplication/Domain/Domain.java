package dk.sdu.mmmi.testapplication.Domain;

import java.util.ArrayList;

public class Domain {
    private ArrayList<SensorConnection> sensors = null;
    private final int CO2_PORT = 4445;
    private final int TEMP_PORT = 4446;

    public Domain() {
        sensors = new ArrayList<>();

        sensors.add(new SensorConnection("Localhost", CO2_PORT));
        sensors.add(new SensorConnection("Localhost", TEMP_PORT));
    }

    public  ArrayList<SensorValues> getSensors() {
        ArrayList<SensorValues> sensorValues = new ArrayList<>();

        for (SensorConnection s : sensors) {
            s.updateValuesFromNetwork();
            sensorValues.add(new SensorValues(s.getValue(), s.getName()));
        }

        return sensorValues;
    }

}
