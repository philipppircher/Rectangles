package cc.phil.observer1;

public class Mobile implements Observer{
    @Override
    public void info(int temperature) {
        System.out.println("I am a mobilephone. Temperature: " + temperature);
    }
}
