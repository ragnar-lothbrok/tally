package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    
    public static void generateQuery(){
        StringBuffer sb = new StringBuffer();
        for(int i=1;i<=28;i++){
            sb.append("{ \"featureId\": "+i+", \"permissionId\": 2 },");
        }
        System.out.println(sb.toString());
    }

    public static String swapString(String inputStr) {
        StringBuffer sb = new StringBuffer(inputStr);
        int i = 0, j = sb.length() - 1;
        while (i < j) {
            while (i < sb.length() && sb.charAt(i) == '0') {
                i++;
            }
            while (j >= 0 && sb.charAt(j) == '1') {
                j--;
            }
            if (i < j) {
                char temp = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(j));
                sb.setCharAt(j, temp);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        generateQuery();
        
        System.out.println(swapString("10"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testCases = br.readLine();
        int N = Integer.parseInt(testCases);
        for (int i = 0; i < N; i++) {
            // BufferedReader brr = new BufferedReader(new
            // InputStreamReader(System.in));
            String line = br.readLine();
            try {
                long n = Long.parseLong(line);
                if (n == 0 || n == 1) {
                    System.out.println(n + " can be fitted in:");
                    System.out.println("* boolean");
                    System.out.println("* byte");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                    continue;
                } else if (n == (byte) n) {
                    System.out.println(n + " can be fitted in:");
                    System.out.println("* byte");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                    continue;
                } else if (n == (short) n) {
                    System.out.println(n + " can be fitted in:");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                    continue;
                } else if (n == (int) n) {
                    System.out.println(n + " can be fitted in:");
                    System.out.println("* int");
                    System.out.println("* long");
                    continue;
                } else {
                    System.out.println(n + " can be fitted in:");
                    System.out.println("* long");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println(line + " can't be fitted anywhere.");
                continue;

            }
        }
    }
}
