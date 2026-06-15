import java.util.*;

public class SetProgrammingQuestions {
    public static void main(String[] args) {
        HashSet<Integer> numbers = new HashSet<>();

        // 1. Write a Java program to append the specified element to a hash set.
        System.out.println("1. Append (add) elements to a hash set:");
        numbers.add(5);
        numbers.add(10);
        numbers.add(2);
        numbers.add(8);
        System.out.println("HashSet contents: " + numbers);
        System.out.println("----------------------------------------");

        // 2. Write a Java program to iterate through all elements in a hash set.
        System.out.println("2. Iterate through all elements in a hash set:");
        for (Integer num : numbers) {
            System.out.println("Element: " + num);
        }
        System.out.println("----------------------------------------");

        // 3. Write a Java program to get the number of elements in a hash set.
        System.out.println("3. Get the number of elements in a hash set:");
        System.out.println("Size of hash set: " + numbers.size());
        System.out.println("----------------------------------------");

        // 6. Write a Java program to clone a hash set to another hash set.

        // 7. Write a Java program to convert a hash set to an array.
        System.out.println("7. Convert a hash set to an array:");
        Integer[] array = numbers.toArray(new Integer[0]);
        System.out.println("Array element at index 0: " + array[0]);
        System.out.println("----------------------------------------");

        // 8. Write a Java program to convert a hash set to a tree set.
        System.out.println("8. Convert a hash set to a tree set:");
        TreeSet<Integer> treeSet = new TreeSet<>(numbers);
        System.out.println("TreeSet contents (Automatically sorted!): " + treeSet);
        System.out.println("----------------------------------------");

        // 9. Write a Java program to find numbers less than 7 in a tree set.
        System.out.println("9. Find numbers less than 7 in a tree set:");
        System.out.println("Numbers less than 7: " + treeSet.headSet(7));
        System.out.println("----------------------------------------");

        // 10. Write a Java program to compare two hash sets.
        System.out.println("10. Compare two hash sets:");
        HashSet<Integer> anotherSet = new HashSet<>();
        anotherSet.add(5);
        anotherSet.add(10);
        anotherSet.add(2);
        anotherSet.add(8);
        System.out.println("Are the two sets equal? " + numbers.equals(anotherSet));
        System.out.println("----------------------------------------");

        // 11. Write a Java program to compare two sets and retain elements that are the
        // same.
        System.out.println("11. Compare two sets and retain elements that are the same (Intersection):");
        HashSet<Integer> sampleSet = new HashSet<>();
        sampleSet.add(1);
        sampleSet.add(2);
        System.out.println("----------------------------------------");

        // 5. Write a Java program to test if a hash set is empty or not.
        System.out.println("5. Test if a hash set is empty or not:");
        System.out.println("Is 'sampleSet' empty? " + sampleSet.isEmpty());
        System.out.println("----------------------------------------");

        // 4 & 12. Write a Java program to empty / remove all elements from a hash set.
        System.out.println("4 & 12. Empty / remove all elements from a hash set:");
        sampleSet.clear();
        System.out.println("sampleSet set after clear(): " + sampleSet);
        System.out.println("Is 'sampleSet' empty now? " + sampleSet.isEmpty());
    }
}
