package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Anagram {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            br.readLine();
            fallingEagle(br.readLine().trim());
        }
    }

    private static void fallingEagle(String inpString) {
        String str[] = inpString.trim().split(" ");
        long sum =0;
        for (int i = 1; i < str.length; i++) {
            int temp1 = Integer.parseInt(str[i-1]);
            int temp2 = Integer.parseInt(str[i]);
            sum += (Math.max(temp1, temp2));
        }
        System.out.println(sum);
    }

    private static void savior(String inpString) {
        String str[] = inpString.trim().split(" ");
        Map<Integer, Integer> evenMap = new HashMap<Integer, Integer>();
        Map<Integer, Integer> oddMap = new HashMap<Integer, Integer>();
        int oddNumbers = 0;
        int evenNumbers = 0;
        for (int i = 0; i < str.length; i++) {
            Integer temp = Integer.parseInt(str[i]);
            if (temp % 2 == 0) {
                if (evenMap.get(temp) != null) {
                    evenMap.put(temp, evenMap.get(temp) + 1);
                } else {
                    evenMap.put(temp, 1);
                }
                evenNumbers++;
            } else {
                if (oddMap.get(temp) != null) {
                    oddMap.put(temp, oddMap.get(temp) + 1);
                } else {
                    oddMap.put(temp, 1);
                }
                oddNumbers++;
            }
        }

        long sum = 0;
        if (oddNumbers > 1) {
            sum += (oddNumbers * (oddNumbers - 1)) / 2;
        }
        if (evenNumbers > 1) {
            sum += (evenNumbers * (evenNumbers - 1)) / 2;
        }

        Set<Entry<Integer, Integer>> entrySet = evenMap.entrySet();
        Iterator<Entry<Integer, Integer>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {
                sum -= ((entry.getValue() * (entry.getValue() - 1)) / 2);
            }
        }

        entrySet = oddMap.entrySet();
        iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Entry<Integer, Integer> entry = iterator.next();
            if (entry.getValue() > 1) {
                sum -= ((entry.getValue() * (entry.getValue() - 1)) / 2);
            }
        }
        System.out.println(sum);
    }

    public static long factorial(long num) {
        if (num <= 1) {
            return 1;
        }
        System.out.println(num);
        return num * factorial(num - 1);
    }

    public static void arrange(String inputString) {
        List<Integer> evenList = new ArrayList<Integer>();
        List<Integer> oddList = new ArrayList<Integer>();
        String str[] = inputString.trim().split(" ");
        for (int i = 0; i < str.length; i++) {
            Integer temp = Integer.parseInt(str[i]);
            if (temp % 2 == 0) {
                evenList.add(temp);
            } else {
                oddList.add(temp);
            }
        }
        Collections.sort(evenList);
        Collections.sort(oddList);
        int sum = 0;
        for (int i = 0; i < evenList.size(); i++) {
            sum += evenList.get(i);
            System.out.print(evenList.get(i) + " ");
        }
        System.out.print(sum + " ");
        sum = 0;
        for (int i = 0; i < oddList.size(); i++) {
            sum += oddList.get(i);
            System.out.print(oddList.get(i) + " ");
        }
        System.out.print(sum);
    }

    private static void isAnagram(String inputString) {
        int[] arr = new int[256];
        for (int i = 0; i < inputString.length(); i++) {
            arr[inputString.charAt(i)] += 1;
        }

        int noOfOdd = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 != 0) {
                noOfOdd++;
            }
        }

        if (noOfOdd > 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

}
