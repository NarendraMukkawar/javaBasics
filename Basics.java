import java.util.*;

class Basics {

    public void printName() {
        System.out.println("I am NM");
    }

    public void execute() {
        System.out.println("executing");
        Basics jb = new Basics();
        jb.printName();
    }

    final public static void main(String[] args) {
        System.out.println("main method of Basics");
        A.main(args);
    }
}

class Example2 {
    public static void main(String[] args) {
        System.out.println("main method of Example2");
    }
}

class A {
    public static void main(String[] args) {
        System.out.println("A main string array");
    }

    public static void main(String args) {
        System.out.println("A main only String");
    }

    public static void main(int[] args) {
        System.out.println("A main int array");
    }

}
