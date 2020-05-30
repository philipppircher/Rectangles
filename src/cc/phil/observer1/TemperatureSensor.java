package cc.phil.observer1;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor {
    private List<Observer> observers;
    private int temperature;

    public TemperatureSensor(int temperature) {
        this.temperature = temperature;
        this.observers = new ArrayList<>();
    }

    public void addedObserver(Observer observer){
        observers.add(observer);
    }

    public void informAll(){
        for (Observer observer : observers) {
            observer.info(this.temperature);
        }
    }
}