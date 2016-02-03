package com.home.chegg;

public class Point {

	private static Long count = 0l;
	private Integer xCo;
	private Integer yCo;

	public Point(Integer xCo, Integer yCo) {
		super();
		this.xCo = xCo;
		this.yCo = yCo;
		count++;
	}

	public Point() {
		this.xCo = 0;
		this.yCo = 0;
		count++;
	}

	public String __str__() {
		return "(" + this.xCo + "," + this.yCo + ")";
	}

	public String distance(Point p1) {
		return "The distance between (" + p1.xCo + "," + p1.yCo + ") and (" + this.xCo + "," + this.yCo + ") is "
				+ Math.sqrt(Math.pow(p1.xCo - this.xCo, 2) + Math.pow(p1.yCo - this.yCo, 2));
	}

	public Double _distanceFromOrigin() {
		return Math.sqrt(Math.pow(0 - this.xCo, 2) + Math.pow(0 - this.yCo, 2));
	}

	public String getCount() {
		return "Number of point objects created is " + count;
	}

	public void compare(Point p1) {
		if (p1 != null && p1 instanceof Point) {
			Double d1 = Math.sqrt(Math.pow(0 - this.xCo, 2) + Math.pow(0 - this.yCo, 2));
			Double d2 = Math.sqrt(Math.pow(0 - p1.xCo, 2) + Math.pow(0 - p1.yCo, 2));
			System.out.println("p1 < p2 " + (d1 < d2 ? true : false));
			System.out.println("p1 <= p2 " + (d1 <= d2 ? false : true));
			System.out.println("p1 > p2 " + (d1 > d2 ? true : false));
			System.out.println("p1 >= p2 " + (d1 >= d2 ? true : false));
			System.out.println("p1 == p2 " + (d1 == d2 ? false : true));
			System.out.println("p1 != p2 " + (d1 != d2 ? true : false));
		} else {
			System.out.println("p1 == p2 " + false);
			System.out.println("p1 != p2 " + true);
		}
	}

	@Override
	public String toString() {
		return "(" + xCo + "," + yCo + ")";
	}

}
