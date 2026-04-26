import com.zeroc.Ice.*;

public class Server {
    public static void main(String[] args) {
        try (Communicator communicator = Util.initialize(args)) {

            ObjectAdapter adapter = communicator.createObjectAdapterWithEndpoints(
                "SimpleAdapter", "default -p 11000");

            adapter.add(new PrinterI(), Util.stringToIdentity("SimplePrinter"));
            adapter.add(new CalculatorI(), Util.stringToIdentity("SimpleCalculator"));
            adapter.activate();

            System.out.println("Java server running on port 11000...");
            communicator.waitForShutdown();

        } catch (LocalException e) {
            e.printStackTrace();
        }
    }
}
