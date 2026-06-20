import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFunctionalInterfaceExample {

    /*
     * The Consumer functional interface has accept<T> as abstract method which
     * takes a input and
     * does not return anything it consumes that input. It is used for printing and
     * logging purpose.
     * It has one default method andThen(), it is used to combine two
     * consumer interfaces the second ones output is passed to first one
     */
    public static void main(String args[]) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            list.add(i);
        }

        Consumer<List<Integer>> modifyList = parameterList -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 10);
            }
        };

        Consumer<List<Integer>> displayModifiedList = parameterList -> {
            list.stream().forEach(a -> System.out.println(a));
        };

        modifyList.accept(list);
        displayModifiedList.accept(list);

        modifyList.andThen(displayModifiedList).accept(list);
    }
}