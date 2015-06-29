package com.home.primeseller;

import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Waiter implements Runnable {

    private BlockingQueue<Order> waitWaiterQueue;

    private BlockingQueue<Order> waiterOrderQueue;

    private BlockingQueue<Order> chefOrderQueue;

    public Waiter(BlockingQueue<Order> waitWaiterQueue, BlockingQueue<Order> waiterOrderQueue,
            BlockingQueue<Order> chefOrderQueue) {
        super();
        this.waitWaiterQueue = waitWaiterQueue;
        this.waiterOrderQueue = waiterOrderQueue;
        this.chefOrderQueue = chefOrderQueue;
    }

    public void run() {
        while (true) {
            synchronized (this) {
                if (waitWaiterQueue.size() > 0) {
                    Integer waiterNumber = Restaurant.getWaiterNumber();
                    if (waiterNumber != -1) {
                        Order order = waitWaiterQueue.poll();
                        if (order != null) {
                            order.setWaiterId(waiterNumber);
                            order.setWaiterConsumeTime(new Date());
                            waiterOrderQueue.offer(order);
                            System.out.println("waitWaiterQueue :>>" + waitWaiterQueue.size());
                            System.out.println("waiterOrderQueue :>>" + waitWaiterQueue.size());
                        } else {
                            Restaurant.getWaiterAvailable()[waiterNumber] = true;
                        }
                    }
                }
            }
            synchronized (this) {
                if (waiterOrderQueue.size() > 0) {
                    Integer chefNumber = Restaurant.getChefNumber();
                    if (chefNumber != -1) {
                        Order order = waiterOrderQueue.poll();
                        if (order != null) {
                            order.setChefId(chefNumber);
                            chefOrderQueue.offer(order);
                            Restaurant.getWaiterAvailable()[order.getWaiterId()] = true;
                            System.out.println("chefOrderQueue :>>" + chefOrderQueue.size());
                        } else {
                            Restaurant.getChefAvailable()[chefNumber] = true;
                        }
                    }
                }
            }
        }
    }

}
