package cc.phil.test.exception;

public class Adder {
    private Object UnableToAddException;

    public int addNumbers(int a, int b) throws UnableToAddException {
        int sum = a + b;
        if (sum == 0){
            throw new UnableToAddException("die Summe ist null");
        }
        return sum;
    }
}
