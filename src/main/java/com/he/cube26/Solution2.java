package com.he.cube26;
///https://www.hackerearth.com/national-instruments-hiring-challenge/problems/34b595c132e44ed98f309dc02c67da68/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int count = Integer.parseInt(line);
        String str[] = br.readLine().split(" ");
        long arr[] = new long[count];
        for(int i=0;i<arr.length;i++){
            arr[i] = Long.parseLong(str[i]);
        }
        Arrays.sort(arr);
        getTotal(arr);
    }
    
    private static void getTotal(long arr[]){
        long sum = 0;
        int low =0;
        int high = arr.length-1;
        while( low < arr.length  && high >= 0 &&low <= high){
            sum += Math.abs(arr[low] - arr[high]);
            sum += Math.abs(arr[high] - arr[low+1]);
            low++;
            high--;
        }
        sum += Math.abs(arr[high+1] - arr[0]);
        System.out.println(sum);
    }
}
