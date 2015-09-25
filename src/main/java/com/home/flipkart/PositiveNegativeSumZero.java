package com.home.flipkart;

import java.util.HashMap;
import java.util.Map;

public class PositiveNegativeSumZero {

    public static void main(String[] args) {

        int arr[] = /* {12,8,1,3,2,-5} */{ 4, 2, -3, 1, 6 };
        findZeroSum(arr);
    }

    private static void findZeroSum(int[] arr) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum == 0) {
                System.out.println("Start Index : " + 0 + " End Index : " + i);
            } else if (arr[i] == 0) {
                System.out.println("Start Index : " + i + " End Index : " + i);
            } else if (map.get(sum) != null) {
                System.out.println("Start Index : " + (map.get(sum)+1) + " End Index : " + i);
            } else {
                map.put(sum, i);
            }
        }
    }

}
