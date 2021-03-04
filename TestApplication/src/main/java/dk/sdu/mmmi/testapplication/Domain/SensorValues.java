package dk.sdu.mmmi.testapplication.Domain;

public class SensorValues {
    private final Double value;
    private final String name;

    public SensorValues(Double value, String name) {
        this.value = value;
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
