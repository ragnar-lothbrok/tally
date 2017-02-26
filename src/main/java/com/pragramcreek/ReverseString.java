package com.pragramcreek;

//http://www.programcreek.com/2014/05/leetcode-reverse-words-in-a-string-ii-java/
public class ReverseString {

	public static void main(String[] args) {
		reverse("abc");
		reverse("abcd");
	}
	
	private static void reverse(String str){
		char ch[] = str.toCharArray();
		for(int i=0;i<ch.length/2;i++){
			char temp = ch[ch.length-i-1];
			ch[ch.length-i-1] = ch[i];
			ch[i] =temp;
		}
		System.out.println(new String(ch));
	}
}
