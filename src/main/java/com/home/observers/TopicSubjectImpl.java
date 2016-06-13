package com.home.observers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TopicSubjectImpl implements Subject {

	List<Observer> observerList = new ArrayList<Observer>();

	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

	private String message;

	private boolean changed;

	@Override
	public void registerObserver(Observer observer) {
		lock.writeLock().lock();
		try {
			this.observerList.add(observer);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		lock.writeLock().unlock();
	}

	@Override
	public void unRegisterObserver(Observer observer) {
		lock.writeLock().lock();
		try {
			this.observerList.remove(observer);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		lock.writeLock().unlock();
	}

	@Override
	public void notifyObservers() {
		lock.readLock().lock();
		try {
			for (Observer observer : this.observerList) {
				if (changed) {
					observer.update();
				}
			}
			changed = false;
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		lock.readLock().unlock();

	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}

	@Override
	public void postMessage(String msg) {
		System.out.println("Message Posted to Topic:" + msg);
		this.message = msg;
		this.changed = true;
		notifyObservers();
	}

}
