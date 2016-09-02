package com.home.geeks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

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

//	public void main1(String[] args) {
//
//		Cache<String, List<Node>> productEntityCache = CacheBuilder.newBuilder().build();
//		List<byte[]> nodess = null;
//		List<Node> nodes = new ArrayList<Node>();
//		nodes.add(new Node(7));
//		nodes.add(new Node(8));
//		nodes.add(new Node(5));
//
//		productEntityCache.put("a", nodes);
//		// System.out.println(productEntityCache.getIfPresent("a"));
//
//	}
	
	static TreeSet<Node> set = new TreeSet<Node>(new NodeComp());
	
	static{
		set.add(new Node(7));
		set.add(new Node(8));
		set.add(new Node(8));
		System.out.println("$$$" + set);
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				getFromSet();
			}
		});
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("%%%"+set.size());
		try {
			Thread.currentThread().sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(set.size());
		
	}
	private static Object obj = new Object();
	
	private static void getFromSet(){
		synchronized (obj) {
			set = null;
			System.out.println("Set : "+set);
		}
	}
	@Override
	public int compareTo(Node o) {
		int score = ((Integer) o.getScore()).compareTo(this.getScore());
		if(score == 0){
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
		int score =  o1.score.compareTo(o2.score);
		if(score == 0){
			return 1;
		}
		return  score;
	}

}
