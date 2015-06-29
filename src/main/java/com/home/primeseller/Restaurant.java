package com.home.primeseller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Restaurant {

    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private BlockingQueue<Order> waitWaiterQueue = new ArrayBlockingQueue<Order>(100);

    private BlockingQueue<Order> waiterOrderQueue = null;

    private BlockingQueue<Order> chefOrderQueue = null;

    private static volatile boolean isWaiterAvailable[];

    private static volatile boolean isChefAvailable[];

    synchronized public static boolean[] getWaiterAvailable() {
        return isWaiterAvailable;
    }

    synchronized public static boolean[] getChefAvailable() {
        return isChefAvailable;
    }

    public static void main(String[] args) {

        Restaurant restaurant = new Restaurant();

        if (args.length != 2) {
            System.out.println("Please add counts of Chef and Waiter.");
        }

        restaurant.waiterOrderQueue = new ArrayBlockingQueue<Order>(Integer.parseInt(args[0]));
        isWaiterAvailable = new boolean[Integer.parseInt(args[0])];
        Arrays.fill(isWaiterAvailable, true);

        restaurant.chefOrderQueue = new ArrayBlockingQueue<Order>(Integer.parseInt(args[1]));
        isChefAvailable = new boolean[Integer.parseInt(args[1])];
        Arrays.fill(isChefAvailable, true);

        Thread waiterThread = new Thread(new Waiter(restaurant.waitWaiterQueue, restaurant.waiterOrderQueue,
                restaurant.chefOrderQueue));
        waiterThread.start();

        Thread chefThread = new Thread(new Chef(restaurant.chefOrderQueue));
        chefThread.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            while (true) {
                String line = br.readLine();
                try{
                    line = line.trim();
                    String str[] = line.split(":");
                    int itemNumber = Integer.parseInt(str[1]);
                    Order order = new Order();
                    order.setItemNumber(itemNumber);
                    order.setOrderTime(new Date());
                    order.setOrderId("ORD" + OrderGenerator.getInstance().getOrderNumber());
                    System.out.println(restaurant.waitWaiterQueue.offer(order));
                }catch(Exception exception){
                    System.out.println("Excepiton occured : "+line);
                }
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public synchronized static Integer getWaiterNumber() {
        Integer waiterNumber = -1;
        for (int i = 0; i < isWaiterAvailable.length; i++) {
            if (isWaiterAvailable[i] == true) {
                isWaiterAvailable[i] = false;
                waiterNumber = i;
                break;
            }
        }
        return waiterNumber;
    }

    public synchronized static Integer getChefNumber() {
        Integer chefNumber = -1;
        for (int i = 0; i < isChefAvailable.length; i++) {
            if (isChefAvailable[i] == true) {
                isChefAvailable[i] = false;
                chefNumber = i;
                break;
            }
        }
        return chefNumber;
    }

}
