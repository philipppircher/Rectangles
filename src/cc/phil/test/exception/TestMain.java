package cc.phil.test.exception;

public class TestMain {
    public static void main(String[] args) {
        Adder adder = new Adder();
        try {
            System.out.println(adder.addNumbers(0, 5));
        } catch (UnableToAddException ex){
            System.out.println("Fehler aufgetreten. " + ex.getMessage());
        } catch (NullPointerException ex){
            System.out.println("Fehler aufgetreten. Versuch auf null zu zeigen");
        }

    }
}
