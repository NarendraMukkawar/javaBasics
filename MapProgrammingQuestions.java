import java.util.*;

public class MapProgrammingQuestions {
    public static void main(String[] args) {
        Map<Integer, String> God = new HashMap<>();

        // Write a Java program to associate the specified value with the specified key
        // in a HashMap.
        System.out
                .println("1.Write a Java program to associate the specified value with the specified key in a HashMap");
        God.put(101, "Ram");
        God.put(102, "Lakshman");
        God.put(103, "Sita");
        System.out.println("Initial HashMap: " + God);

        // 2. Write a Java program to count the number of key-value (size) mappings in a
        // map.
        System.out.println("2. Write a Java program to count the number of key-value (size) mappings in a map.");
        System.out.println("Printing the size of HashMap");
        System.out.println("Initial size of the map: " + God.size());

        // 3. Write a Java program to copy all mappings from the specified map to
        // another map.
        System.out.println("3. Write a Java program to copy all mappings from the specified map to another map");
        Map<Integer, String> NewGodMap = new HashMap<>();
        NewGodMap.put(null, "Infinity");
        NewGodMap.putAll(God);
        System.out.println("New Map contents after copying: " + NewGodMap);

        // 4. Write a Java program to remove all mappings from a map.
        System.out.println("4. Write a Java program to remove all mappings from a map.");
        System.out.println("Removing all mappings using clear");
        NewGodMap.clear();
        System.out.println(NewGodMap);

        // 5. Write a Java program to check whether a map contains key-value mappings
        // (empty) or not.
        System.out
                .println("5. Write a Java program to check whether a map contains key-value mappings (empty) or not.");
        // Checking if the 'God' map is empty
        if (God.isEmpty()) {
            System.out.println("The map is empty (contains no mappings).");
        } else {
            System.out.println("The map contains key-value mappings! Current size: " + God.size());
        }

        // 6. Write a Java program to get a shallow copy of a HashMap instance.
        System.out.println("6. Write a Java program to get a shallow copy of a HashMap instance.");

        // 7. Write a Java program to test if a map contains a mapping for the specified
        // key.
        System.out.println("7. Write a Java program to test if a map contains a mapping for the specified key.");
        int keyToFind = 101;
        int missingKey = 105;
        // Testing for a key that present
        if (God.containsKey(keyToFind)) {
            System.out.println(
                    "Yes, The map contains a mapping for key " + keyToFind + " (Value: " + God.get(keyToFind) + ")");
        } else {
            System.out.println("No! The map does not contain key " + keyToFind);
        }
        // Testing for a key that is not present
        if (God.containsKey(missingKey)) {
            System.out.println("Yes, The map contains a mapping for key " + missingKey);
        } else {
            System.out.println("No! The map does not contain key " + missingKey);
        }

        // 8. Write a Java program to test if a map contains a mapping for the specified
        // value.
        System.out.println("8. Write a Java program to test if a map contains a mapping for the specified value.");
        String valueToFind = "Sita";
        String missingValue = "Hanuman";

        // Testing for a value that present
        if (God.containsValue(valueToFind)) {
            System.out.println("The map contains the value");
        } else {
            System.out.println("The map does not contain the value");
        }

        // Testing for a value that is not present
        if (God.containsValue(missingValue)) {
            System.out.println("The map contains the value");
        } else {
            System.out.println("The map does not contain the value");
        }

        // 9. Write a Java program to create a set view of the mappings contained in a
        // map.
        System.out.println("9. Write a Java program to create a set view of the mappings contained in a map.");
        Set<Map.Entry<Integer, String>> mappingSet = God.entrySet();
        System.out.println("Set view of the mappings: " + mappingSet);
        System.out.println("Iterating through the Set view:");
        for (Map.Entry<Integer, String> entry : mappingSet) {
            System.out.println("Key is: " + entry.getKey() + " | Value is: " + entry.getValue());
        }

        // 10. Write a Java program to get the value of a specified key in a map.
        System.out.println("10. Write a Java program to get the value of a specified key in a map.");
        int searchKey1 = 102;
        int searchKey2 = 108; // This key doesn't exist

        String value1 = God.get(searchKey1);
        System.out.println("Value for key " + searchKey1 + " is: " + value1);

        String value2 = God.get(searchKey2);
        System.out.println("Value for key " + searchKey2 + " is: " + value2 + " (Because it doesn't exist)");

        // 11. Write a Java program to get a set view of the keys contained in this map.
        System.out.println("11. Write a Java program to get a set view of the keys contained in this map.");

        // Creating a Set view of the keys
        Set<Integer> keysSet = God.keySet();

        System.out.println("Set view of the keys: " + keysSet);

        // Iterating through the keys to print them
        System.out.println("Printing keys individually:");
        for (Integer key : keysSet) {
            System.out.println("Key: " + key);
        }

        // 12. Get a collection view of the values contained in this map.
        System.out.println("12. Write a Java program to get a collection view of the values contained in this map.");
        Collection<String> valuesCollection = God.values();
        System.out.println("Collection view of values: " + valuesCollection);
    }
}
