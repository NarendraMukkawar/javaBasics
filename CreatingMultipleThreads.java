public class CreatingMultipleThreads {

    public static void main(String args[]) {
        MyThread obj1 = new MyThread();
        MyThread obj2 = new MyThread();
        Thread T1 = new Thread(obj1, "Thread-1");
        Thread T2 = new Thread(obj2, "Thread-2");

        T1.start();
        T2.start();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        // We lock [current object using this] because both threads share the same 'obj'
        synchronized (CreatingMultipleThreads.class) {
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName() + " loop value: " + i);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                }
            }
        }
    }
}