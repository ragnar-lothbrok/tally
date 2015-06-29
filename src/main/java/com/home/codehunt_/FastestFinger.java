package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class FastestFinger {

    public static void main(String[] args) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int N = Integer.parseInt(line);
            Stack<String[]> stack = new Stack<String[]>();
            for (int i = 0; i < N; i++) {
                String call[] = br.readLine().trim().split(" ");
                if (call.length == 1) {
                    if (stack.isEmpty()) {
                        System.out.println("No Food");
                    } else {
                        System.out.println(stack.pop()[1].trim());
                    }
                } else {
                    stack.push(call);
                }
            }
        } finally {

        }
    }

}
