package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class A2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        String line = "";
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            br.readLine();
            line = br.readLine().trim();
            String str[] = line.split(" ");
            for (int k = 0; k < str.length; k++) {
                list.add(Integer.parseInt(str[k]));
            }
            boolean isInverse = true;
            for (int k = 0; k < str.length; k++) {
                if(list.get(list.get(k)-1) != list.get(k)){
                    isInverse = false;
                    break;
                }
            }
            if(!isInverse){
                System.out.println("not inverse");
            }else{
                System.out.println("inverse");
            }
            list.clear();
        }
    }
}
