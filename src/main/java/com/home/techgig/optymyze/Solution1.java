package com.home.techgig.optymyze;

import java.util.Hashtable;

public class Solution1 implements Runnable {
	public void run() {
		System.out.println();
		super.toString();
	}
	
	private static int a = 2;

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		Hashtable<String, String> h = new Hashtable<String, String>();
		h.put("sdsdf", "dsfsdf");
		h.clear();
		System.out.println(h.size());
		synchronized (args) {
			try {
				args.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("1");
	}
}
