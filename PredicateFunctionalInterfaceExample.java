import java.text.Format;
import java.util.function.Predicate;

public class PredicateFunctionalInterfaceExample {
    /*
     * Predicate functional interface has one abstract method test(T) which taken an
     * input and
     * check the condition whether it is correct or not and return output in true or
     * false Format.
     * To combine 2 predicate we have 2 default methods and() and or(). For and()
     * both things should be true
     * but for or() if one condition is true it will return the true.
     */
    public static void main(String[] args) {
        Predicate<Integer> num1 = n -> n > 100;
        Predicate<Integer> num2 = n -> n < 200;

        boolean b1 = num1.and(num2).test(101);
        System.out.println(b1);

        boolean b2 = num1.or(num2).test(10);
        System.out.println(b2);
    }
}
