package com.home.codehunt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RamsLoveforSita {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            try{
                line = br.readLine();
                String str[] = line.split(" ");
                System.out.println(getTotalChoclates(Integer.parseInt(str[0]),Integer.parseInt(str[1]),Integer.parseInt(str[2])));
            }catch(Exception exception){
            }
        }
    }
    
    public static Integer getTotalChoclates(Integer totalMoney, Integer chocPrice, Integer wrapperPrice){
        Integer totalChoclates = null;
        totalChoclates = (totalMoney/chocPrice);
        totalChoclates += ((totalChoclates / wrapperPrice ) + (((totalChoclates / wrapperPrice)+(totalChoclates % wrapperPrice ))/wrapperPrice));
        return totalChoclates;
    }
}
