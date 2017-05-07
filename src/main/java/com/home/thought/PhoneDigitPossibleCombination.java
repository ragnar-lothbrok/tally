package com.home.thought;

import java.util.HashMap;
import java.util.Map;
//http://www.geeksforgeeks.org/find-possible-words-phone-digits/
public class PhoneDigitPossibleCombination {

	public static void main(String[] args) {
		
		Map<String,Character[]> map = new HashMap<String, Character[]>();
		
		map.put("2", new Character[] {'A','B','C'});
		
		map.put("3", new Character[] {'D','E','F'});
		
		map.put("4", new Character[] {'G','H','I'});

		String pattern = "234";
		findCombination(map,pattern, "");
	}
	
	private static void findCombination(Map<String,Character[]> map,String str,String output){
		if(str.length() == 0){
			System.out.println(output);
			return;
		}else{
			for(int i=0;str.length() > 0 && i<map.get(str.charAt(0)+"").length;i++){
				findCombination(map,str.substring(1),output+""+map.get(str.charAt(0)+"")[i]);;
			}
		}
	}
}
