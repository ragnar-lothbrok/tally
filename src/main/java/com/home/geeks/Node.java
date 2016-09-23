package com.home.geeks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Node implements Comparable<Node> {
	Integer data;
	Node left, right;
	Integer score = 0;

	Node(int item) {
		data = item;
		left = right = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public static void main(String[] args) {
		random(8);
	}

	public static void random(int noOfAdsToBeServed) {
		int productScoreBiasProbPower = 4;
		double productScoreBiasIndexPower = 1d / productScoreBiasProbPower;
		int maxProductsToConsider = 200;
		boolean[] selectionStatusArray = new boolean[list.size()];
		Random random = new Random();
		double max = Math.pow((double) (Math.min(list.size(), maxProductsToConsider)), productScoreBiasProbPower) - 1.00;
		for (int i = 0; i < noOfAdsToBeServed; i++) {
			double randomNumber = max * random.nextDouble();
			int index = (int) (Math.floor(Math.pow(randomNumber, productScoreBiasIndexPower)));
			int attemptIndex = index;
			System.out.print(attemptIndex+" ");
			boolean descCheck = true;
			while (selectionStatusArray[attemptIndex]) {
				if (attemptIndex == selectionStatusArray.length - 1) {
					descCheck = false;
					attemptIndex = index;
				}
				attemptIndex = descCheck ? attemptIndex + 1 : attemptIndex - 1;
			}
			selectionStatusArray[attemptIndex] = true; // This index is used..
		}
		Node[] filteredCreatives = new Node[noOfAdsToBeServed];
		int addIndex = 0;
		System.out.println();
		for (int selectIndex = selectionStatusArray.length - 1; selectIndex >= 0; selectIndex--) {
			if (selectionStatusArray[selectIndex]) {
				filteredCreatives[addIndex++] = list.get(selectIndex);
				System.out.print(list.get(selectIndex).getData()+" ");
			}
		}
	}

	static TreeSet<Node> set = new TreeSet<Node>(new NodeComp());
	static List<Node> list = new ArrayList<Node>();
	static {
		for (int i = 10; i < 17; i++) {
			list.add(new Node(i));
		}
	}

	/*static {
		for (int i = 10; i < 50; i++) {
			list.add(new Node(i));
		}
		set.add(new Node(7));
		set.add(new Node(8));
		set.add(new Node(8));
//		System.out.println("$$$" + set);

		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				getFromSet();
			}
		});
//		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
		}

		System.out.println("%%%" + set.size());
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(set.size());

	}*/
	private static Object obj = new Object();

	private static void getFromSet() {
		synchronized (obj) {
			set = null;
			System.out.println("Set : " + set);
		}
	}

	@Override
	public int compareTo(Node o) {
		int score = ((Integer) o.getScore()).compareTo(this.getScore());
		if (score == 0) {
			return 1;
		}
		return score;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

}

class NodeComp implements Comparator<Node> {

	@Override
	public int compare(Node o1, Node o2) {
		int score = o1.score.compareTo(o2.score);
		if (score == 0) {
			return 1;
		}
		return score;
	}

}
