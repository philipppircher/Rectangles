package cc.phil.observer1;

public class Heater implements Observer {

    public void on(){
        System.out.println("I am On");
    }

    public void off(){
        System.out.println("I am Off");
    }

    @Override
    public void info(int temperature) {

        System.out.println("I am a heater.");
        if (temperature > 21){
            off();
        } else {
            on();
        }
        System.out.println();
    }
}
