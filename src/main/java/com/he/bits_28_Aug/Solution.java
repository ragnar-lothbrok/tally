package com.he.bits_28_Aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import org.codehaus.jackson.map.ObjectMapper;

public class Solution {

    public void getPairs(int[] arr, int sum) {
        
         int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] > sum) {
                j--;
            } else if (arr[i] + arr[j] < sum) {
                i++;
            } else if (arr[i] + arr[j] == sum) {
                i++;
                j--;
                System.out.println(i+" "+j);
            }
        }
        
        int num = 19;
        
        
//        int a = 0123;
//        int a = 0678;
//        int a = 0xfda; 
//        int a = 1 2 3;
//        int a = 123;
//       int a = 1_2_3;
    }

    public static void printFib(int n) {
        int febCount = n;
        if (n == 1) {
            System.out.print("0");
        } else if (n == 0) {
            return;
        }

        else {
            int[] feb = new int[febCount];
            feb[0] = 0;
            feb[1] = 1;
            for (int i = 2; i < febCount; i++) {
                feb[i] = feb[i - 1] + feb[i - 2];
            }

            for (int i = 0; i < febCount; i++) {
                System.out.print(feb[i] + " ");
            }
        }
        System.out.println();
    }

    static int correctPosition(int items[], int l, int r, int key) {
        int m;
        while (r - l > 1) {
            m = l + (r - l) / 2;
            if (items[m] >= key) {
                r = m;
            } else {
                l = m;
            }
        }
        return r;
    }

    static int LongestIncreasingSubsequenceLength(int items[]) {
        int size = items.length;
        // Add boundary case, when array size is one
        int[] tempArr = new int[size];
        int len; // always points empty slot

        tempArr[0] = items[0];
        len = 1;
        for (int i = 1; i < size; i++) {
            if (items[i] < tempArr[0])
                // new smallest value
                tempArr[0] = items[i];
            else if (items[i] > tempArr[len - 1])
                // A[i] wants to extend largest subsequence
                tempArr[len++] = items[i];
            else
                // A[i] wants to be current end candidate of an existing
                // subsequence
                // It will replace ceil value in tempArr
                tempArr[correctPosition(tempArr, -1, len - 1, items[i])] = items[i];
        }
        return len;
    }

    public static void main(String[] args) throws IOException {
    	
    	List<Map<String, String>> list = new ArrayList<Map<String,String>>();
    	Map<String, String> staticmap = new HashMap<String, String>();
    	staticmap.put("dsdf", "dfsdfs");
    	staticmap.put("dsdewerf", "dfwerwersdfs");
    	Map<String, String> dynamic = new HashMap<String, String>();
    	dynamic.put("234234", "dfsdfs");
    	dynamic.put("234324", "dfwerwersdfs");
    	list.add(dynamic);
    	list.add(staticmap);
//    	System.out.println("##"+new ObjectMapper().writeValueAsString(list));
    	
    	Set<String> set = new HashSet<String>();
    	set.add("ssdsdf");
    	set.add("dsdfsdfsdf");
//    	System.out.println("##$$$$"+new ObjectMapper().writeValueAsString(set));
     	
    	String next = "https://graph.facebook.com/v2.4/dXNlcl9jb250ZAXh0OgGQvhtWziW5WpkytLLmAqhzptdffwHhX6ZBP3H6WpWBOrUzwfdiQK5jwrbQ8QOShk69Vq2LF9I67Hymp85EdAMNQLjQvDRiJglfwbR2a2CTOxZCEZD/mutual_likes?limit=25&after=NjY1MzM0NDYxNDYZD";
    	int index = next.indexOf("?");
        System.out.println(next.substring(0, index));
        ConcurrentHashMap<String,String> premiumPhone = new ConcurrentHashMap<String,String>();
        premiumPhone.put("Apple", "iPhone6");
        premiumPhone.put("HTC", "HTC one");
        premiumPhone.put("Samsung","S6");
        
        Iterator iterator = premiumPhone.keySet().iterator();
        
        while (iterator.hasNext())
        {
            System.out.println(premiumPhone.get(iterator.next()));
            premiumPhone.put("Sony", "Xperia Z");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // String line = br.readLine();
        // String str[] = line.split(" ");
        // int [] arr = new int[str.length];
        // for(int i=0;i<arr.length;i++){
        // arr[i] = Integer.parseInt(str[i]);
        // }
        // LongestIncreasingSubsequenceLength(arr);
        Long inputNum = Long.parseLong(br.readLine().trim());
        String ans = "", result = "";
        String s = Long.toBinaryString(inputNum);
        for (int i = 0, j = s.length() - 1; i < 32; i++) {
            if (j >= 0 && s.charAt(j) == '1') {
                ans = ans + "0";
            } else {
                ans = ans + "1";
            }
            {
                j--;
            }
        }
        for (int i = 31; i >= 0; i--) {
            result = result + ans.charAt(i);
        }
        String bin = result;
        long number = 0;
        int dig;
        for (int i = 0; i < bin.length(); i++) {
            dig = bin.charAt(i) - '0';
            number = 2 * number + dig;
        }
        System.out.println(Long.toString(number));
    }

}