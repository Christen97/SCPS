package dk.sdu.mmmi.testapplication.Domain;

import dk.sdu.mmmi.SensorData;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class SensorConnection {
    private final String address;
    private final int port;

    private Double value;
    private String name;


    public SensorConnection(String address, int port) {
        this.address = address;
        this.port = port;

        SensorData s = updateDataInternal(address, port);
        this.value = s.getValue();
        this.name = s.getName();

    }

    private SensorData updateDataInternal(String address, int port) {
        SensorData sensorData = null;

        try {
            Socket socket = new Socket(address, port);

            System.out.println("Connected for port : " + port);

            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());
            sensorData = (SensorData) input.readObject();

            socket.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return sensorData;
    }

    public void updateValuesFromNetwork() {
        SensorData s = updateDataInternal(address, port);
        this.value = s.getValue();
        this.name = s.getName();
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
