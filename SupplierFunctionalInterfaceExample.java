import java.util.Optional;
import java.util.function.Supplier;

public class SupplierFunctionalInterfaceExample {
    /*
     * The Supplier functional interface does not take any input but generate and
     * output.
     * It has one abstract method named [R get()] R is return type
     */
    public static void main(String[] args) {
        Supplier<Double> randomNum = () -> Math.random();
        System.out.println(randomNum.get());
    }
}
