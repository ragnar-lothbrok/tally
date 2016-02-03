package com.home.chegg;

public class GenArrayQueue<T> {

	private Object[] object;
	private Integer currSize = 0;
	private static final Integer DEFAULT_SIZE = 100;
	private Integer maxSize;

	public GenArrayQueue() {
		this.object = new Object[DEFAULT_SIZE];
		this.maxSize = DEFAULT_SIZE;
	}

	public GenArrayQueue(Integer maxSize) {
		this.object = new Object[maxSize];
		this.maxSize = maxSize;
	}

	public void enqueue(T t) {
		if (currSize == 0) {
			object[currSize++] = t;
		} else {
			if (currSize != maxSize) {
				object[currSize++] = t;
			}
		}
	}

	public T dequeue() {
		T value = null;
		if (currSize != 0) {
			value = (T) object[0];
			for (int i = 0; i < currSize-1; i++) {
				object[i] = object[i + 1];
			}
			currSize--;
		}
		return value;
	}

	public T peek() {
		T value = null;
		if (currSize != 0) {
			value = (T) object[0];
		}
		return value;
	}

	public void showQueue() {
		if (currSize != 0) {
			for (int i = 0; i < currSize; i++) {
				System.out.println(object[i]);
			}
		}
	}

}
