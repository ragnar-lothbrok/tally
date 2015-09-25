package com.home.flipkart;

import java.util.HashMap;
import java.util.Map;

public class MatchingWordPercentage {

    public static void main(String[] args) {
        getPercentage("This phone is very good", "A very very good cell phone");
        getPercentage("Liked it. Nice one", "Very Nice Phone");
    }

    private static void getPercentage(String s1, String s2) {

        String str[] = s1.split(" ");
        Map<String,Integer> firstMap = new HashMap<String,Integer>();
        for(int i=0;i<str.length;i++){
            if(firstMap.containsKey(str[i])){
                firstMap.put(str[i], firstMap.get(str[i])+1);
            }else{
                firstMap.put(str[i], 1);
            }
        }
        
        str = s2.split(" ");
        int matchCount =0;
        for(int i=0;i<str.length;i++){
            if(firstMap.get(str[i]) != null){
                matchCount++;
            }
        }
        
        float percentage = (float) ((matchCount*1.0/str.length)*100);;
        System.out.println(Math.ceil(percentage));
    }
}
