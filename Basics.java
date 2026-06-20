// import java.util.*;

// public class Basics {

// public void printName() {
// System.out.println("I am NM");
// }

// public void execute() {
// System.out.println("executing");
// Basics jb = new Basics();
// jb.printName();
// }

// final public static void main(String[] args) {
// System.out.println("main method of Basics");
// A.main(args);
// }
// }

// // class Example2 {
// // public static void main(String[] args) {
// // System.out.println("main method of Example2");
// // }
// // }

// // class A {
// // public static void main(String[] args) {
// // System.out.println("A main string array");
// // }

// // public static void main(String args) {
// // System.out.println("A main only String");
// // }

// // public static void main(int[] args) {
// // System.out.println("A main int array");
// // }

// // }

// import java.util.ArrayList;
// import java.util.LinkedList;
// import java.util.List;
// import java.util.function.Consumer;

// class Main {
// public static void main(String args[]) {
// // Consumer to display a number
// Consumer<Integer> display = a -> System.out.println(a);

// // Implement display using accept()
// display.accept(10);

// // Consumer to multiply 2 to every integer of a list
// Consumer<List<Integer>> modify = list -> {
// for (int i = 0; i < list.size(); i++)
// list.set(i, 2 * list.get(i));
// };

// // Consumer to display a list of numbers
// Consumer<List<Integer>> dispList = list -> list.stream().forEach(a ->
// System.out.print(a + " "));

// List<Integer> list = new ArrayList<Integer>();
// list.add(2);
// list.add(1);
// list.add(3);

// // Implement modify using accept()
// modify.accept(list);

// // Implement dispList using accept()
// dispList.accept(list);
// }
// }
