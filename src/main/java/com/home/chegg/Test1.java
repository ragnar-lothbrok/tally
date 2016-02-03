package com.home.chegg;

public class Test1 {
	public static void main(String[] args) {
		Point p0 = new Point();
		System.out.println(p0.toString());
		Point p1 = new Point(3,4);
		System.out.println(p1.toString());
		Point p2 = new Point(3,0);
		System.out.println(p2.toString());
		System.out.println(p1.distance(p2));
		System.out.println(p1.getCount());
		p1.compare(p2);
	}
}
