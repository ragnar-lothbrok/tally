package com.home.codemonk.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MonkintheGrassFields {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String firstStr[] = line.replace("  ", " ").trim().split(" ");
            int[][] intArr = new int[Integer.parseInt(firstStr[0])][Integer.parseInt(firstStr[0])];
            int curse = Integer.parseInt(firstStr[1]);
            for (int j = 0; j < intArr.length; j++) {
                String str[] = br.readLine().replace("  ", " ").trim().split(" ");
                for (int k = 0; k < str.length; k++) {
                    intArr[j][k] = Integer.parseInt(str[k]);
                }
            }
            getTotalPoison(intArr, curse);
        }
    }

    public static void getTotalPoison(int[][] intArr, int curse) {
        Integer result = 0;
        for (int j = 0; j < intArr.length; j++) {
            for (int k = 0; k < intArr[j].length; k++) {
                if (curse == 0) {
                    break;
                }
                if(k>0/*k == intArr[j].length -1*/){
                    result += getRowSum(intArr,j);
                    incrementRow(intArr,j);
                }else{
                    result += getColumnSum(intArr,k);
                    incrementColumn(intArr,k);
                }
                curse--;
            }
            if (curse == 0) {
                break;
            }
        }
        System.out.println(result);
    }
    
    private static void incrementRow(int[][] intArr, int row) {
        for (int j = 0; j < intArr.length; j++) {
            intArr[row][j] = intArr[row][j] + 1;
        }        
    }
    
    public static int getColumnSum(int[][] intArr, int col){
        int result =0;
        for (int j = 0; j < intArr.length; j++) {
            result+= intArr[j][col];
        }
        return result;
    }

    public static int getRowSum(int[][] intArr, int row){
        int result =0;
        for (int j = 0; j < intArr.length; j++) {
            result+= intArr[row][j];
        }
        return result;
    }

    public static void incrementColumn(int[][] intArr, int column) {
        for (int j = 0; j < intArr.length; j++) {
            intArr[j][column] = intArr[j][column] + 1;
        }
    }
}
