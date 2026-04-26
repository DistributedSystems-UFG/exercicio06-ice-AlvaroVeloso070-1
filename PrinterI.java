public class PrinterI extends Demo._PrinterDisp {

    @Override
    public void printString(String s, com.zeroc.Ice.Current current) {
        System.out.println(s);
    }

    @Override
    public void printUpperCase(String s, com.zeroc.Ice.Current current) {
        System.out.println(s.toUpperCase());
    }

    @Override
    public void printReverse(String s, com.zeroc.Ice.Current current) {
        System.out.println(new StringBuilder(s).reverse().toString());
    }
}
