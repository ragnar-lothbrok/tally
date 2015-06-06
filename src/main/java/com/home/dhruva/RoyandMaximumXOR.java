package com.home.dhruva;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RoyandMaximumXOR {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int T = Integer.parseInt(line);
        long N;
        long max    = 1L;
        long count  = 1L;
        long bitN   ;
        StringBuilder sb  = new StringBuilder(4*T);
        
        for (int t = 0; t < T; t++) {
            line = br.readLine();
            N = Long.parseLong(line);
            {
                
                bitN    = 1L << getBits(N-1);
                max     = (bitN - 1);
                count   = (bitN == N) ? bitN :(N -(bitN>>1))<<1 ;
            
                sb.append(max);
                sb.append(" ");
                sb.append(count);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static int getBits(long x){
        int count = 0;
        while(x > 0){
            x = x>>1;
            count++;
        }
        return count;
    }

}
