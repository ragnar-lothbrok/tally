package com.home.primeseller;

import java.util.Date;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chef implements Runnable {

    ExecutorService executorService = Executors.newFixedThreadPool(5);

    private BlockingQueue<Order> chefOrderQueue;

    public Chef(BlockingQueue<Order> chefOrderQueue) {
        super();
        this.chefOrderQueue = chefOrderQueue;
    }

    public void run() {
        while (true) {
            if (chefOrderQueue.size() > 0) {
                final Order order = chefOrderQueue.poll();
                if (order != null) {
                    Runnable runnable = new Runnable() {
                        public void run() {
                            System.out.println("Chef" + (order.getChefId() + 1) + " : Picked up " + order.getOrderId()
                                    + " at " + Restaurant.dateFormat.format(new Date()) + " from Waiter : "
                                    + (order.getWaiterId() + 1));
                            System.out.println("Chef" + (order.getChefId() + 1) + ":   Cooking "
                                    + ItemEnum.getItemEnum(order.getItemNumber()) + "...  ");
                            try {
                                Thread.currentThread();
                                Thread.sleep(ItemEnum.getItemCookingTime(order.getItemNumber()) * 1000);
                                System.out.println("Chef" + (order.getChefId() + 1) + ":   Finished making "
                                        + ItemEnum.getItemEnum(order.getItemNumber()) + " for " + order.getOrderId()
                                        + " at " + Restaurant.dateFormat.format(new Date()));
                                Restaurant.getChefAvailable()[order.getChefId()] = true;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    };

                    executorService.submit(runnable);
                }
            }
        }
    }

}
