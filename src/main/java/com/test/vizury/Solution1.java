package com.test.vizury;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
///https://www.hackerearth.com/vizury-sdet-hiring-challenge/problems/ec8ed7aa550a492db80678d9ee5748c2/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.split(" ");
            int numOfRows = Integer.parseInt(str[0]);
            int numOfCols = Integer.parseInt(str[1]);
            if(numOfRows ==numOfCols){
                BigDecimal bigDecimal = new BigDecimal(numOfRows).multiply(new BigDecimal(2).add(new BigDecimal(
                        numOfRows - 1).multiply(new BigDecimal(numOfCols + 1))));
                if (i == N - 1)
                    sb.append(bigDecimal);
                else
                    sb.append(bigDecimal + "\n");
            }else{
                if (numOfRows > numOfCols) {
                    int temp = numOfCols;
                    numOfCols = numOfRows;
                    numOfRows = temp;
                }
                BigDecimal bigDecimal1 = new BigDecimal(numOfRows).multiply(new BigDecimal(2).add(new BigDecimal(
                        numOfRows - 1).multiply(new BigDecimal(numOfCols + 1)))).divide(new BigDecimal(2));
                BigDecimal bigDecimal2 = new BigDecimal(numOfRows).multiply(new BigDecimal(2).add(new BigDecimal(
                        numOfRows - 1).multiply(new BigDecimal(numOfRows + 1)))).divide(new BigDecimal(2));
                if (i == N - 1)
                    sb.append(bigDecimal1.add(bigDecimal2));
                else
                    sb.append(bigDecimal1.add(bigDecimal2) + "\n");
            }
        }
        System.out.println(sb.toString());
    }
}
