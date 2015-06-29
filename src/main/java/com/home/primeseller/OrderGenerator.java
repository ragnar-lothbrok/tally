package com.home.primeseller;

import java.util.concurrent.atomic.AtomicInteger;

public class OrderGenerator {

    private static OrderGenerator instance;
    AtomicInteger counter = new AtomicInteger();

    private OrderGenerator() {

    }

    public static OrderGenerator getInstance() {
        if (instance == null) {
            synchronized (OrderGenerator.class) {
                if (instance == null)
                    instance = new OrderGenerator();
            }
        }
        return instance;
    }

    public Integer getOrderNumber() {
        return this.counter.incrementAndGet();
    }
}
