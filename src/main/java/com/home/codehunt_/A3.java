package com.home.codehunt_;

import java.util.HashSet;
import java.util.Set;

public class A3 {

    public static void main(String[] args) {
        System.out.println(getFirstRepeting(new int[] { 10, 5, 3, 4, 3, 5, 6 }));
        
        System.out.println(visibleBuilding(new int[] {3, 1, 4}));
        
        System.out.println(visibleBuilding(new int[] {4, 5,2,3,6}));
    }

    public static int getFirstRepeting(int arr[]) {
        int min = 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (set.contains(arr[i]))
                min = i;
            else
                set.add(arr[i]);
        }
        return min;
    }

    public static int visibleBuilding(int arr[]) {
        int count = 1;
        int lastMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > lastMax) {
                lastMax = arr[i];
                count++;
            }
        }
        return count;

    }
}
