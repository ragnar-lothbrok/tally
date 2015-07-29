package com.home.thought;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* IMPORTANT: class must not be public. */

class Solution1 {
    public static void main(String args[]) throws Exception {
        int num = 0;
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int testCases = Integer.parseInt(line);
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < testCases; i++) {

                long noOfcards = Long.parseLong(br.readLine());
                long moves = (noOfcards) / 3;
                if (noOfcards == 0)
                    result.append(0 + "\n");
                else if (noOfcards < 3)
                    result.append(1 + "\n");
                else if (noOfcards % 3 == 0) {
                    result.append(moves + "\n");
                }

                else if (noOfcards % 3 == 1 && noOfcards > 3) {
                    result.append((noOfcards) + "\n");
                } else if (noOfcards % 3 == 2 && noOfcards > 3) {
                    result.append((noOfcards) + "\n");
                }
            }
            System.out.println(result);
        } catch (Exception exception) {
            System.out.println(num);
        }

    }
}
