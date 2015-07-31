package com.he.code_mania_30;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.hackerearth.com/code_mania_30/algorithm/maximum-resistance-5/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Integer N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            Stack<Integer> stack = new Stack<Integer>();
            line = br.readLine();
            String resistance[] = br.readLine().trim().split(" ");
            int k = resistance.length - 1;
            for (int j = line.length() - 1; j >= 0; j--) {
                if (line.charAt(j) == 'A') {
                    int num1 = 0, num2 = 0;
                    if (!stack.isEmpty())
                        num1 = stack.pop();
                    if (!stack.isEmpty())
                        num2 = stack.pop();
                    if (num1 != 0)
                        stack.push(num1 + num2);
                } else if (line.charAt(j) == 'B') {
                    int num1 = 0, num2 = 0;
                    if (!stack.isEmpty())
                        num1 = stack.pop();
                    if (!stack.isEmpty())
                        num2 = stack.pop();
                    if (num1 != 0)
                        stack.push(Math.max(num1, num2));
                } else if (line.charAt(j) == 'X') {
                    if (k >= 0)
                        stack.push(Integer.parseInt(resistance[k--]));
                }
            }
            int sum = 0;
            while (!stack.isEmpty()) {
                sum += stack.pop();
            }
            System.out.println(sum);
        }
    }

}
