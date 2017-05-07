package com.home.observers;

public class ObserverImpl implements Observer {

	private Subject subject;
	private String observerName;
	
	public ObserverImpl(String name) {
		this.observerName = name;
	}

	@Override
	public void subcribeSubject(Subject subject) {
		this.subject = subject;
		this.subject.registerObserver(this);
	}

	@Override
	public void update() {
		System.out.println(observerName+" Message received : "+subject.getUpdate(this));
	}

}
