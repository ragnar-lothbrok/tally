package com.home.observers;

public interface Subject {

	public void registerObserver(Observer observer);

	public void unRegisterObserver(Observer observer);

	public void notifyObservers();

	public Object getUpdate(Observer obj);
	
	public void postMessage(String msg);
}
