public class CalculatorI extends Demo._CalculatorDisp {

    @Override
    public int add(int a, int b, com.zeroc.Ice.Current current) {
        return a + b;
    }

    @Override
    public int multiply(int a, int b, com.zeroc.Ice.Current current) {
        return a * b;
    }
}
