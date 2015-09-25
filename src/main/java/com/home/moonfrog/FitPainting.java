package com.home.moonfrog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/moonfrog-hiring-challenge/algorithm/fitthepaintings/
public class FitPainting {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String frame = br.readLine();
        String painting1 = br.readLine();
        String painting2 = br.readLine();
        
        String str[] = frame.split(" ");
        int fWidth = Integer.parseInt(str[0]);
        int fHeight = Integer.parseInt(str[1]);
        
        str = painting1.split(" ");
        int p1Widht = Integer.parseInt(str[0]);
        int p1Height = Integer.parseInt(str[1]);
        
        str = painting2.split(" ");
        int p2Widht = Integer.parseInt(str[0]);
        int p2Height = Integer.parseInt(str[1]);
        
        int max  = Integer.MIN_VALUE;
        if(max < p1Height ){
            max = p1Height;
        }
        if(max < p1Widht ){
            max = p1Widht;
        }
        if(max < p2Height ){
            max = p2Height;
        }
        if(max < p2Widht ){
            max = p2Widht;
        }
        
        if(max > fWidth && max > fHeight){
            System.out.println("No");
            return;
        }
        
        if(((p1Height + p2Widht > fWidth && p1Height + p2Height> fWidth) && (p1Height + p2Widht > fHeight && p1Height + p2Height> fHeight))
                && ((p1Height + p2Widht > fWidth && p1Widht + p2Widht> fWidth) &&(p1Height + p2Widht > fHeight && p1Widht + p2Widht> fHeight))
                &&((p1Height + p2Widht > fWidth && p1Height + p2Height> fWidth) && (p1Height + p2Widht > fHeight && p1Height + p2Height> fHeight))
                &&((p1Height + p2Height > fWidth && p1Widht + p2Height> fWidth) &&(p1Height + p2Height > fHeight && p1Widht + p2Height> fHeight))){
            System.out.println("No");
            return;
        }
        
        if(fHeight * fWidth >= (p1Height*p1Widht + p2Height*p2Widht)){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
