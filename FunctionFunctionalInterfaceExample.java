import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.*;

public class FunctionFunctionalInterfaceExample {

    /*
     * Function functional interface has [R apply(T)] abstarct method. R is return
     * tyepe and T is input.
     * We use Function when we are taking and input and generating an output or
     * different output.
     * It has default methods like identity() which return the the input as it is
     * then andThen() to chain
     * the two Function interfaces
     */
    public static void main(String[] args) {
        Function<Integer, Double> res = i -> i / 2.0;
        Double result = res.apply(10);
        System.out.println(result);
        System.out.println(res.apply(20));

        System.out.println("--------------------------------------");
        Function<List<Integer>, Set<Integer>> setFromList = list -> {
            return list.stream().collect(Collectors.toSet());
        };

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            int j = i;
            list.add(i);
            list.add(j);
        }
        System.out.println("list with each value twice " + list);
        Set<Integer> set = setFromList.apply(list);
        System.out.println("Set using setFromList " + set);
        System.out.println("--------------------------------------");

        Function<List<Integer>, List<Integer>> sameList = Function.identity();
        System.out.println(sameList.apply(list));
    }
}
