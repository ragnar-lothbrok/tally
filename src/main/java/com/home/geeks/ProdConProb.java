package com.home.geeks;

import java.util.concurrent.locks.ReentrantReadWriteLock;

class Prod {
	void doStuff(ReentrantReadWriteLock lock) throws InterruptedException {
		lock.writeLock().lock();
		Thread.currentThread().sleep(10000);
		System.out.println("Producing Data...");
		lock.writeLock().unlock();
	}
}

class Cons {
	void doStuff(ReentrantReadWriteLock lock) {
		lock.readLock().lock();
		System.out.println("Consuming Data...");
		lock.readLock().unlock();
	}
}

public class ProdConProb {

	public static void main(String[] args) throws InterruptedException {
		ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
		new Prod().doStuff(lock);
		new Cons().doStuff(lock);
	}

}
