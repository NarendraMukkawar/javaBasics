import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultiThreadDemo {
    public static void main(String[] args) throws InterruptedException {
        
        // ====================================================================
        // SCENARIO 1: Plain ArrayList with synchronized block approach
        // ====================================================================
        System.out.println("--- Scenario 1: ArrayList with synchronized block ---");
        List<String> arrayList = new ArrayList<>();
        arrayList.add("Java");
        arrayList.add("Python");
        arrayList.add("C++");

        // Thread 1: Reader Thread (Iterating)
        Thread reader1 = new Thread(() -> {
            try {
                // Your teacher says synchronize on the list object
                synchronized (arrayList) {
                    for (String lang : arrayList) {
                        System.out.println("Reader Thread reading: " + lang);
                        // Simulating a tiny delay reading each item
                        Thread.sleep(100); 
                    }
                }
            } catch (Exception e) {
                System.out.println("READER THREAD CRASHED: " + e);
            }
        });

        // Thread 2: Writer Thread (Modifying)
        Thread writer1 = new Thread(() -> {
            try {
                // Give the reader a small head-start to begin its loop
                Thread.sleep(50); 
                System.out.println("Writer Thread attempting to add 'Go'...");
                synchronized (arrayList) {
                    arrayList.add("Go");
                    System.out.println("Writer successfully added 'Go'!");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        reader1.start();
        writer1.start();
        
        // Wait for both threads to finish before moving to Scenario 2
        reader1.join();
        writer1.join();


        System.out.println("\n--------------------------------------------------\n");


        // ====================================================================
        // SCENARIO 2: CopyOnWriteArrayList (The Concurrent Solution)
        // ====================================================================
        System.out.println("--- Scenario 2: CopyOnWriteArrayList ---");
        List<String> cowList = new CopyOnWriteArrayList<>();
        cowList.add("Java");
        cowList.add("Python");
        cowList.add("C++");

        // Thread 1: Reader Thread (Iterating)
        Thread reader2 = new Thread(() -> {
            try {
                // NO SYNCHRONIZATION
                for (String lang : cowList) {
                    System.out.println("Reader Thread reading: " + lang);
                    Thread.sleep(100); 
                }
            } catch (Exception e) {
                System.out.println("READER THREAD CRASHED: " + e);
            }
        });

        // Thread 2: Writer Thread (Modifying)
        Thread writer2 = new Thread(() -> {
            try {
                Thread.sleep(50); 
                System.out.println("Writer Thread attempting to add 'Go'...");
                cowList.add("Go"); // No synchronized block needed
                System.out.println("Writer successfully added 'Go'!");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        reader2.start();
        writer2.start();
        
        reader2.join();
        writer2.join();
        System.out.println("Final CopyOnWriteArrayList elements: " + cowList);
    }
}


// In Scenario 1, because the reader thread synchronizes on the whole arrayList for the duration of its loop, 
// the writer thread is forced to stop and freeze until the loop finishes. 
// They cannot run concurrently. If that loop takes 5 seconds, your writer thread hangs for 5 seconds.
// Problem: Concurrency is destroyed here. The two threads cannot work at the same time.

// In Scenario 2, the Reader thread completely finishes reading "Java", "Python", and "C++" without needing a single lock.