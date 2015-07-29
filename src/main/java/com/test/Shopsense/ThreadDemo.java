package com.test.Shopsense;

public class ThreadDemo implements Runnable {
    static Boolean A1 = true;
    static Boolean A2 = true;

    public static void main(String[] args) {
        try {
            Thread tobj1 = new Thread(new ThreadDemo());
            tobj1.start();
            Thread tobj2 = new Thread(new ThreadDemo());
            tobj2.start();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public synchronized void run() {
        for (int i = 0; i < 1; i++) {
            if (A1) {
                System.out.println(Thread.currentThread().getName() + "\t is active");
                A1 = false;
                A2 = true;
            }
            if (A2) {
                System.out.println(Thread.currentThread().getName() + " \t is active");
                A2 = false;
                A1 = true;
            }
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
