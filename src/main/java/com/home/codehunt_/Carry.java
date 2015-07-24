package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Carry {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            String str[] = line.trim().split(" ");
            countCarry(str[0],str[1]);
        }
    }

    private static void countCarry(String inString1, String inString2) {
        Long num1 = Long.parseLong(inString1);
        Long num2 = Long.parseLong(inString2);
        int carryCount =0;
        if(num1 < num2){
            long temp = num2;
            num2 = num1;
            num1= temp;
        }
        while (num1 > 0) {
            if(num1%10 + num2%10 > 9){
                carryCount++;
            }
            num1= num1/10;
            num2 = num2/10;
        }
        if(carryCount ==0)
            System.out.println("No carry operation");
        else if(carryCount ==1)
            System.out.println(carryCount+" carry operation");
        else
            System.out.println(carryCount+" carry operations");
    }

}
