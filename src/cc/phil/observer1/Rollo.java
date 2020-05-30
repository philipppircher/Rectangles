package cc.phil.observer1;

public class Rollo implements Observer {
    public void up(){
        System.out.println("I am up");
    }

    public void down(){
        System.out.println("I am down");
    }

    @Override
    public void info(int temperature) {
        System.out.println("I am a rollo.");
        if (temperature > 23){
            down();
        } else {
            up();
        }
        System.out.println();
    }
}
