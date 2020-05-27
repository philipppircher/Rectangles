package cc.phil.observer1;

import java.util.ArrayList;
import java.util.List;

public class TemperatureSensor {
    // Membervariables
    //
    private List<Observer> observers;
    private int temperature;

    // Constructor
    //

    public TemperatureSensor(int temperature) {
        this.observers = new ArrayList<>();
        this.temperature = temperature;
    }

    // Methodes
    //
    public void addObserver(Observer observer){
        this.observers.add(observer);
    }

    public void alarm(){
        informAll();
    }

    public void informAll(){
        for (Observer observer : observers) {
            observer.info(this.temperature);
        }
    }
}
