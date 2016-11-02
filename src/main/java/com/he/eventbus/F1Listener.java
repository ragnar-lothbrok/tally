package com.he.eventbus;

import java.io.IOException;

import com.google.common.base.Charsets;
import com.google.common.eventbus.Subscribe;
import com.google.common.io.Resources;

public class F1Listener {

	@Subscribe
	public void task(String s) {
		System.out.println("do task(" + s + ")");
	}
}
