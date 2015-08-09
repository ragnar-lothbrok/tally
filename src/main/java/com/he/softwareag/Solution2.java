package com.he.softwareag;

import java.io.BufferedReader;
import java.io.InputStreamReader;
///https://www.hackerearth.com/software-ag-hiring-challenge/problems/347bb2c12fd849869c5f834a47dce3cd/
public class Solution2 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        long num = Long.parseLong(line);
        while (num > 0) {
            long totalValue = 0;
            line = br.readLine();
            Integer n = Integer.parseInt(line);
            double cuts = n * 12;
            line = br.readLine();
            String str[] = line.split(" ");
            int[] arr = new int[str.length];
            int total = 0;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
                total += arr[i];
            }
            if(cuts < 26){
                for(int i=0;i<cuts;i++){
                    totalValue += arr[i];
                }
            }else{
                long res = (long) (cuts/26);
                totalValue += (26 * ((res-1)*(res)/2))+(total * res);
                int remainder = (int) (cuts%26);
                for(int i=0;i<remainder;i++){
                    totalValue += (arr[i]+res);
                }
            }
            System.out.println(totalValue);
            num--;
        }

    }

}
