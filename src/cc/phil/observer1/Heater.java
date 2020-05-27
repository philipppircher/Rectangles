package cc.phil.observer1;

public class Heater implements Observer {
    @Override
    public void info(int temperature) {
        System.out.println("I am a heater. Temperature: " + temperature);
    }
}
