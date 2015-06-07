package com.home.codehunt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HostelMess {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            try {
                line = br.readLine();
                System.out.println(getTotalArrangments(Integer.parseInt(line)));
            } catch (Exception exception) {
            }
        }
    }

    public static Long getTotalArrangments(Integer cols) {
        Long result = 0l;
        if(cols == 1){
            result = 2l;
        }else if(cols == 2){
            result = 3l;
        }else{
            result = getNumber(cols);
        }
        return result*result;
    }
    
    public static Long getNumber(Integer cols){
        Long num1 =2l;
        Long num2 =3l;
        while(cols >= 3){
            long temp = num1;
            num1 = num2;
            num2 = num2 + temp;
            cols--;
        }
        return num2;
    }
}
