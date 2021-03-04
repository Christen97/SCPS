package dk.sdu.mmmi.co2sensor.sensor;

import dk.sdu.mmmi.SensorData;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class CO2SensorServer {
    static CO2Sensor sensor = null;
    static Socket socket = null;
    static ServerSocket server = null;
    static ObjectOutputStream stream = null;

    public static void main(String[] args) {
        sensor = new CO2Sensor("CO2-1");

        try {
            server = new ServerSocket(4445);
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
