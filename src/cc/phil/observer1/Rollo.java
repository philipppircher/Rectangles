package cc.phil.observer1;

public class Rollo implements Observer {
    public void up(){

    }

    public void down(){

    }

    public String getType(){
        return "Type a";
    }

    @Override
    public void info(int temperature) {
        System.out.println("I am a rollo. Temperature: " + temperature);
        down();
    }
}
