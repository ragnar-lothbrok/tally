package com.he.coditas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

// https://www.hackerearth.com/code-monk-greedy-technique/algorithm/arjit-and-printing-press/
public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            String reserve = br.readLine();

            Comparator<Character> comp = new Comparator<Character>() {
                public int compare(Character c1, Character c2) {
                    if (c1 < c2)
                        return -1;
                    else if (c1 > c2)
                        return +1;
                    else
                        return 0;
                }
            };
            PriorityQueue<Character> pq = new PriorityQueue<Character>(reserve.length(), comp);
            for (char c : reserve.toCharArray())
                pq.add(c);

            char[] wordArr = word.toCharArray();
            String res = new String();
            for (int j = 0; j < wordArr.length; j++) {
                if (!pq.isEmpty()) {
                    if (wordArr[j] > pq.peek())
                        wordArr[j] = pq.poll();
                }
                res = res + wordArr[j];
            }

            System.out.println(res + "\n");
        }
    }
}
