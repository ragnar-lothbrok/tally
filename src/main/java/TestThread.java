public class TestThread {

    public static Object Lock1 = new Object();
    public static Object Lock2 = new Object();

    public static void main(String[] args) {

        test();
        testDeadlock();

    }

    private static void test() {
        System.out.println("test method...");
        Runnable runnable1 = new Runnable() {

            public void run() {
                synchronized (Lock1) {
                    System.out.println("Thread 1: Holding lock 1...");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 1: Waiting for lock 2...");
                    synchronized (Lock2) {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {

            public void run() {
                synchronized (Lock1) {
                    System.out.println("Thread 1: Holding lock 1...");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 1: Waiting for lock 2...");
                    synchronized (Lock2) {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }

    private static void testDeadlock() {
        
        System.out.println("testDeadlock method...");
        Runnable runnable1 = new Runnable() {

            public void run() {
                synchronized (Lock1) {
                    System.out.println("Thread 1: Holding lock 1...");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 1: Waiting for lock 2...");
                    synchronized (Lock2) {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    }
                }
            }
        };

        Runnable runnable2 = new Runnable() {

            public void run() {
                synchronized (Lock2) {
                    System.out.println("Thread 1: Holding lock 2...");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                    System.out.println("Thread 1: Waiting for lock 1...");
                    synchronized (Lock1) {
                        System.out.println("Thread 1: Holding lock 1 & 2...");
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
