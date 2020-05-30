package cc.phil.observer1;

public class Main {
    public static void main(String[] args) {
        Heater heater = new Heater();
        Rollo rollo = new Rollo();
        Mobile mobile = new Mobile();

        TemperatureSensor temperatureSensor = new TemperatureSensor(30);
        temperatureSensor.addedObserver(heater);
        temperatureSensor.addedObserver(rollo);
        temperatureSensor.addedObserver(mobile);
        temperatureSensor.informAll();
    }
}
