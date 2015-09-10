package com.he.seagate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.hackerearth.com/kaybus-hiring-challenge/problems/05750f4d144742d2938d6544afcca932/
public class Solution4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int num = Integer.parseInt(line);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; i++) {
            line = br.readLine();
            if(line.length() > 0){
                if(line.charAt(0) == 'a'){
                    sb.append(line+"\n");
                }else{
                    int index = line.charAt(0) - 97+1;
                    int diff = 27 - index;
                    for(int j=0;j<line.length();j++){
                        index = line.charAt(j) - 97+1;
                        index = index +diff;
                        int mod = index%26;
                        sb.append(((char)(97 + mod-1)));
                    }
                    sb.append("\n");
                }
            }else{
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
