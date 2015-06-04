package com.home.codemonk;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ReverseString {

    public static String YES = "YES";
    public static String NO = "NO";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String countAndSum = br.readLine();
            countAndSum = countAndSum.trim().replace("  ", " ");
            String[] str = countAndSum.trim().split(" ");
            int numCount = Integer.parseInt(str[0]);
            Long totalMoney = Long.parseLong(str[1]);
            Long costArr[] = new Long[numCount];
            for (int j = 0; j < numCount; j++) {
                costArr[j] = Long.parseLong(br.readLine());
            }
            System.out.println(isInvited(costArr, totalMoney));
        }
    }

    public static String isInvited(Long[] costArr, Long totalMoney) {
        long currSum = costArr[0];
        int start = 0, i;
        for (i = 1; i <= costArr.length; i++) {
            while (currSum > totalMoney && start < i - 1) {
                currSum = currSum - costArr[start];
                start++;
            }
            if (currSum == totalMoney) {
                return YES;
            }
            if (i < costArr.length)
                currSum = currSum + costArr[i];
        }
        return NO;
    }

    public static void printGoodSring(String line) {
        StringBuffer buffer = new StringBuffer();
        if (line.length() > 0) {
            for (int i = 0; i < line.length(); i++) {
                if (buffer.length() == 0)
                    buffer.append(line.charAt(i));
                else if (buffer.length() > 0 && line.charAt(i) != buffer.charAt(buffer.length() - 1)) {
                    buffer.append(line.charAt(i));
                }
            }
        }
        System.out.println(buffer.toString());
    }

    public static void printReverse(String line) {
        if (line.length() > 0) {
            for (int i = line.length() - 1; i >= 0; i--) {
                System.out.print(line.charAt(i) + "");
            }
        }
        System.out.println();
    }
}
