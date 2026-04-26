import com.zeroc.Ice.*;

public class Client {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            // Connect to the Printer object on the server
            ObjectPrx base = communicator.stringToProxy("SimplePrinter:default -h localhost -p 11000");
            Demo.PrinterPrx printer = Demo.PrinterPrx.checkedCast(base);

            if (printer == null) {
                throw new Error("Invalid proxy");
            }

            printer.printString("Hello from Java client!");
            printer.printUpperCase("hello uppercase");
            printer.printReverse("hello reverse");

            // Connect to the Calculator object on the server
            ObjectPrx calcBase = communicator.stringToProxy("SimpleCalculator:default -h localhost -p 11000");
            Demo.CalculatorPrx calculator = Demo.CalculatorPrx.checkedCast(calcBase);

            if (calculator == null) {
                throw new Error("Invalid proxy");
            }

            System.out.println("10 + 5 = " + calculator.add(10, 5));
            System.out.println("10 * 5 = " + calculator.multiply(10, 5));

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
