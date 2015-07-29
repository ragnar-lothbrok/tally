package com.test.Shopsense;

public class ThreadDemo2 extends Thread {
    public static void main(String[] args) {
        try {
            ThreadDemo2 A = new ThreadDemo2();
            A.start();
            A.run();
            A.wait();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void start() {
        System.out.println("inside start");
    }

    public void run() {
        System.out.println("inside run");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

}
