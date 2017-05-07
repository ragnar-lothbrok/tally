package com.home.chegg;

public class QueuesTester {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Testing Generic Linked List Queue");
		System.out.println("Enqueue'ing 10 numbers 0-9");
		GenLLQueue<Integer> qLLInts = new GenLLQueue();
		for (int i = 0; i < 10; i++) {
			qLLInts.enqueue(i);
		}
		System.out.println("Dequeue'ing all numbers and printing them out.");
		for (int i = 0; i < 10; i++) {
			System.out.println(qLLInts.dequeue());
		}
		System.out.println("Testing peek");
		qLLInts.enqueue(5);
		System.out.println(qLLInts.peek());
		System.out.println("Testing show queue");
		for (int i = 0; i < 10; i += 2) {
			qLLInts.enqueue(i);
		}
		qLLInts.showQueue();

		System.out.println("Testing Generic Array Queue");
		System.out.println("Enqueue'ing 10 numbers 0-9");
		GenArrayQueue<Integer> qArrayInts = new GenArrayQueue();
		for (int i = 0; i < 10; i++) {
			qArrayInts.enqueue(i);
		}
		System.out.println("Dequeu'ing all numbers and printing them out.");
		for (int i = 0; i < 10; i++) {
			System.out.println(qArrayInts.dequeue());
		}
		System.out.println("Testing peek");
		qArrayInts.enqueue(5);
		System.out.println(qArrayInts.peek());
		System.out.println("Testing show queue");
		for (int i = 0; i < 10; i += 2) {
			qArrayInts.enqueue(i);
		}
		qArrayInts.showQueue();
	}
}
