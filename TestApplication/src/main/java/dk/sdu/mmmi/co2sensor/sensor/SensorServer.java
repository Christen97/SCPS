package dk.sdu.mmmi.co2sensor.sensor;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;

public class SensorServer {
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

                SensorData s = new SensorData(1.0, "lol");

                stream.writeObject(s);

                System.out.println("Sent data");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
