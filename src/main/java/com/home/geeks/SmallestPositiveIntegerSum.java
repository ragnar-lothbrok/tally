package com.home.geeks;

//http://www.geeksforgeeks.org/find-smallest-value-represented-sum-subset-given-array/
public class SmallestPositiveIntegerSum {

	public static void main(String[] args) {
		
		System.out.println(Integer.toBinaryString(~2)+"\n"+Integer.toBinaryString(3));
		int arr[] = { 3, 4, 5 };
		findSmallest(arr);
		
		
		String str = "abc";
		String str1 = "a" + "bc";
		String str2 = "ab" + "c";
		String str3 = new String("abc");
		
		System.out.println(str == str1);
		System.out.println(str == str3.intern());
		
//		ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(2);
//		abq.add("abc1");
//		abq.add("abc2");
//		abq.add("abc3");
		
//		System.out.println(abq);
	}

	private static void findSmallest(int arr[]) {
		int sum = 1;
		for (int i = 0; i < arr.length && arr[i] <= sum; i++) {
			sum += arr[i];	
		}
		System.out.println("###"+sum);
	}
}
