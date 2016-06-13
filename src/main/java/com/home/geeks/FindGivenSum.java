package com.home.geeks;

public class FindGivenSum {

	static Node root;

	public static void main(String[] args) {
		int sum = 12;
		root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.left.right = new Node(5);
		root.right.left = new Node(2);

		System.out.println(existsAnyGivenSum(root, sum, sum));
//		System.out.println(maxSum(root));

	}

	public static int maxSoFar = 0;

	public static int maxSum(Node root) {
		if (root != null) {
			int sumCurrent = 0;
			int leftSum = maxSum(root.getLeft());
			int rightSum = maxSum(root.getRight());
			if (leftSum < 0 && rightSum < 0) {
				sumCurrent = root.getData();
			} else {
				sumCurrent = Math.max(Math.max(leftSum, rightSum), leftSum + rightSum + root.getData());
			}
			if (maxSoFar < sumCurrent) {
				maxSoFar = sumCurrent;
			}

			return Math.max(leftSum, rightSum) + root.data;

		} else {
			return 0;
		}
	}

	public static boolean existsAnyGivenSum(Node node, int reducedSum, int sum) {
		if (node == null && reducedSum == 0) {
			return true;
		} else if (reducedSum < 0 || node == null) {
			return false;
		} else {
			return existsAnyGivenSum(node.getLeft(), reducedSum - node.getData(), sum)
					|| existsAnyGivenSum(node.getRight(), reducedSum - node.getData(), sum)
					|| existsAnyGivenSum(node.getLeft(), sum - node.getData(), sum) || existsAnyGivenSum(node.getRight(), sum - node.getData(), sum);
		}
	}

	public static boolean existsGivenSum(Node node, int reducedSum) {
		if (node == null && reducedSum == 0) {
			return true;
		} else if (reducedSum < 0 || node == null) {
			return false;
		} else {
			return existsGivenSum(node.getLeft(), reducedSum - node.getData()) || existsGivenSum(node.getRight(), reducedSum - node.getData());
		}
	}
}
