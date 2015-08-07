package com.he.codehack_05_aug;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer testCases = Integer.parseInt(line);
        for (int i = 0; i < testCases; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            Integer num = Integer.parseInt(str[0]);
            int result = 0;
            line = br.readLine();
            if (num > 1) {
                Integer numOfGroups = Integer.parseInt(str[1]);
                str = line.split(" ");
                Integer urWealth = Integer.parseInt(str[0]);
                Integer arr[] = new Integer[str.length];
                for (int j = 0; j < arr.length; j++) {
                    arr[j] = Integer.parseInt(str[j]);
                }
                Arrays.sort(arr, new IntegerComparator());
                int index = 0;
                for (int k = 0; k < arr.length; k++) {
                    if (urWealth == arr[k].intValue()) {
                        index = k;
                        break;
                    }
                }
                int groupNo = (index + 1) % numOfGroups;
                int temp = groupNo;
                while (temp < arr.length) {
                    if (arr[temp - 1].intValue() == urWealth) {

                    } else if (arr[temp - 1] > urWealth) {
                        result++;
                    }
                    temp = temp + numOfGroups;
                }
            }
            System.out.println(result);
        }
    }
}

class IntegerComparator implements Comparator<Integer> {

    public int compare(Integer o1, Integer o2) {
        return o2.compareTo(o1);
    }
}