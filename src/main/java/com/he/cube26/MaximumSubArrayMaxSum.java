package com.he.cube26;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
///https://www.hackerrank.com/challenges/maxsubarray
public class MaximumSubArrayMaxSum {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine().trim();
        int testCaseCount = Integer.parseInt(line);
        for(int j=0;j<testCaseCount;j++){
            int count = Integer.parseInt(br.readLine().trim());
            String str[] = br.readLine().split(" ");
            int arr[] = new int[count];
            for(int i=0;i<str.length;i++){
                arr[i] = Integer.parseInt(str[i].trim());
            }
            System.out.println(contiguousArraySum(arr)+" "+nonContiguousArraySum(arr));
        }
    }
    
    private static int contiguousArraySum(int arr[]){
        int currSum =arr[0];
        int maxSum = arr[0];
        for(int i=1;i<arr.length;i++){
            if(currSum < 0){
                currSum = arr[i];
            }else{
                currSum += arr[i];
            }
            if(currSum > maxSum ){
               maxSum = currSum;
            }
        }
        return maxSum;
    }
    private static int nonContiguousArraySum(int arr[]){
        int sum =0;
        int min = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > 0){
                sum += arr[i];
            }
            if(arr[i] <= 0 && min < arr[i]){
                min = arr[i];
            }
        }
        return (sum > 0 ? sum : min);
    }
}
