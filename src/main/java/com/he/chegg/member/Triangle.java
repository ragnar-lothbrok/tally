package com.he.chegg.member;

import java.util.Scanner;

public class Triangle extends GeometricObject {

	private double side1;
	private double side2;
	private double side3;

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	public Triangle(double side1, double side2, double side3) {
		super();
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}

	public Triangle() {
		super();
		this.side1 = this.side2 = this.side3 = 1;
	}

	private double getArea() {
		double temp = (side1 + side2 + side3) / 2;
		return Math.sqrt(temp * (temp - side1) * (temp - side2) * (temp - side3));
	}

	private double getPerimeter() {
		return side1 + side2 + side3;
	}

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter side 1 : ");
		double side1 = scanner.nextDouble();

		System.out.println("Please enter side 2 : ");
		double side2 = scanner.nextDouble();
		System.out.println("Please enter side 3 : ");
		double side3 = scanner.nextDouble();
		System.out.println("Please enter color : ");
		String color = scanner.next();
		System.out.println("Please enter filled / not filled : ");
		boolean filled = scanner.nextBoolean();
		Triangle tr = new Triangle(side1, side2, side3);
		tr.setFilled(filled);
		tr.setColor(color);

		System.out.println(tr.toString());

	}

	@Override
	public String toString() {
		return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + "]";
	}

}
