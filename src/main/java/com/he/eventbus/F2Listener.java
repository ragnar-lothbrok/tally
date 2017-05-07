package com.he.eventbus;

import com.google.common.eventbus.Subscribe;

public class F2Listener {

	@Subscribe
	public void task(String s) {
		System.out.println("do task(" + s + ")");
	}
}
