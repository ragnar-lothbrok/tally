package com.home.codehunt1_0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int num = Integer.parseInt(str[0]);
        line = br.readLine();
        str = line.split(" ");
        int coinArr[] = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            coinArr[i] = Integer.parseInt(str[i]);
        }
        System.out.println(dispenceCoint(num, coinArr, coinArr.length));
    }
    
    

    public static int dispenceCoint(int num, int[] S, int m) {
        int table[] = new int[num+1];;
        table[0] = 1;
     
        // Pick all coins one by one and update the table[] values
        // after the index greater than or equal to the value of the
        // picked coin
        for(int i=0; i<m; i++){
            for(int j=S[i]; j<=num; j++)
                table[j] += table[j-S[i]];
            for(int k=0;k<table.length;k++){
                System.out.print(table[k]+" ");
            }
            System.out.println();
        }
     
        return table[num];
        
//        if (num == 0)
//            return 1;
//        else if (num < 0) {
//            return 0;
//        } else if (coinCount <= 0 && num > 0) {
//            return 0;
//        }
//        return dispenceCoint(num, coinArr, coinCount - 1)
//                + dispenceCoint(num - coinArr[coinCount - 1], coinArr, coinCount);
    }

}
