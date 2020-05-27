package cc.phil.observer1;

public class ObserverTest {
    public static void main(String[] args) {
        Rollo rollo = new Rollo();
        Heater heater = new Heater();
        Mobile mobile1 = new Mobile();
        Mobile mobile2 = new Mobile();

        TemperatureSensor temperatureSensor = new TemperatureSensor(10);
        temperatureSensor.addObserver(heater);
        temperatureSensor.addObserver(mobile1);
        temperatureSensor.addObserver(rollo);
        temperatureSensor.alarm();
    }
}
