package dk.sdu.mmmi.temperaturesensor.sensor;

import dk.sdu.mmmi.SensorData;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TemperatureSensorServer {
    static TemperatureSensor sensor = null;
    static Socket socket = null;
    static ServerSocket server = null;
    static ObjectOutputStream stream = null;

    public static void main(String[] args) {
        sensor = new TemperatureSensor("Temperature-1");

        try {
            server = new ServerSocket(4446);
            while (true) {
                socket = server.accept();
                stream = new ObjectOutputStream(socket.getOutputStream());

                SensorData s = new SensorData(sensor.getValue(), sensor.getName());

                stream.writeObject(s);

                System.out.println("Sent data");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
