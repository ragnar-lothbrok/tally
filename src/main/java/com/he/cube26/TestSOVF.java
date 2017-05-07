package com.he.cube26;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

class Producer_Events implements Runnable {
	private BlockingQueue<ArrayList<String>> queue;
	ArrayList<String> batch_list = new ArrayList<String>();

	public Producer_Events(BlockingQueue<ArrayList<String>> queue,
			ArrayList<String> batch_list) {
		this.queue = queue;
		this.batch_list = batch_list;

	}

	public void run() {
		try {

			ArrayList<Long> tymstamp = new ArrayList<Long>();

			BufferedReader reader = new BufferedReader(new FileReader("timestamp_20.csv"));

			String line = "";
			while ((line = reader.readLine()) != null) {

				String[] event = line.trim().split(",");
				float millis = Float.parseFloat(event[0]);
				long num = (long) millis;
				tymstamp.add(num);
			}
			System.out.println("Timestamp added");
			for (int m = 0; m < batch_list.size(); m++) {

				String operator = new String();
				operator = batch_list.get(m);
				ArrayList<String> batch1 = new ArrayList<>();
				Thread.sleep(tymstamp.get(m));
				batch1.add(operator);
				if (m != batch_list.size()) {
					queue.put(batch1);
					System.out.println("Event Added: " + m);
				} else {
					// inject a poison
					ArrayList<String> batch2 = new ArrayList<>(-1);
					queue.put(batch2);
					System.out.println("Producer STOPPED.");
				}

			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ConsumerWorker implements Runnable {

	private BlockingQueue<ArrayList<String>> inputQueue;
	private ArrayList<ArrayList<String>> cr_event_pooler = new ArrayList<ArrayList<String>>();
	private final static ArrayList<String> POISON = new ArrayList<String>(1);

	public ConsumerWorker(BlockingQueue<ArrayList<String>> inputQueue) {
		this.inputQueue = inputQueue;

	}

	@Override
	public void run() {
		// worker loop keeps taking en element from the queue as long as the
		// producer is still running or as
		// long as the queue is not empty:
		while (true) {
			System.out.println("Consumer " + Thread.currentThread().getName() + " START");
			try {
				ArrayList<String> queueElement = inputQueue.take();
				System.out.println("Event Send to Crowd: ");
				if (queueElement == POISON) {
					break;
				} else {
					List<String> ans_matrix = new ArrayList<String>();
					cr_event_pooler.add((ArrayList<String>) ans_matrix);
				}
				// executor.shutdown();

				// process queueElement
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("Consumer " + Thread.currentThread().getName() + " END");
		}
	}

	public void stopRunning() {
		try {
			inputQueue.put(POISON);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class TestSOVF {

	public static void main(String[] args) throws InterruptedException {
		ArrayList<String> batch_list = new ArrayList<String>();
		for(int i=0;i<20;i++){
			batch_list.add(new Random().nextInt()+"");
		}
		Schedule_Batch1(batch_list);
	}
	
	public static void Schedule_Batch1(ArrayList<String> batch_list) throws InterruptedException{
	    ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);
	    // create a blocking queue......
	    BlockingQueue<ArrayList<String>> queue = new ArrayBlockingQueue<ArrayList<String>>(20);
	    //ArrayList<ArrayList<String>> cr_event_pooler = new ArrayList<ArrayList<String>>();
	    Producer_Events producer = new Producer_Events(queue,batch_list);
	   ConsumerWorker consumer = new ConsumerWorker(queue);
	    System.out.println("OK");
	    new Thread(producer).start();
	    executor.execute(consumer);
	}
}
