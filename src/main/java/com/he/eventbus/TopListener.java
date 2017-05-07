package com.he.eventbus;

import com.google.common.eventbus.EventBus;

public class TopListener {

	private static final EventBus eventBus = new EventBus();

	public TopListener() {
		eventBus.register(new F1Listener());
	}

	public static void main(String[] args) {
		for(int i=0;i<10;i++){
			eventBus.post("Simple EventBus Example"+i);
		}
	}
}
