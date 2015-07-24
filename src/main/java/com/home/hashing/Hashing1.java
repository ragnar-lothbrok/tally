package com.home.hashing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Hashing1 {

    public static void main(String args[]) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int N = Integer.parseInt(br.readLine());
        for (int k = 0; k < N; k++) {
            String str[] = br.readLine().split(" ");
            Integer l1 = Integer.parseInt(str[0]);
            Integer r1 = Integer.parseInt(str[1]);
            Integer l2 = Integer.parseInt(str[2]);
            Integer r2 = Integer.parseInt(str[3]);
            if (Math.abs(l1 - r1) == Math.abs(l2 - r2)) {
               /* boolean isEqual = true;
                for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
                    if (line.charAt(i - 1) != line.charAt(j - 1)) {
                        System.out.println("No");
                        isEqual = false;
                        break;
                    }
                }
                if (isEqual) {
                    System.out.println("Yes");
                }*/
                if(line.substring(l1-1, r1).equals(line.substring(l2-1, r2))){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            } else {
                System.out.println("No");
            }
        }
    }

}
