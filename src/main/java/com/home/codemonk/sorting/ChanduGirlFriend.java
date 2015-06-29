package com.home.codemonk.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ChanduGirlFriend {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        try{
            
            for (int i = 0; i < N; i++) {
                Integer length = Integer.parseInt(br.readLine());
                if(length >0){
                    line = br.readLine();
                    line = line.replace("  ", " ").trim();
                    String str[] = line.split(" ");
                    int[] intArr = new int[length];
                    for (int j = 0; j < str.length; j++) {
                        intArr[j] = Integer.parseInt(str[j]);
                    }
                    if(length==1){
                        displayContent(intArr);
                    }else{
//                        int[] tempArr = new int[length];
//                        sort_Merge(intArr, tempArr, 0, length-1);
//                        displayContent(tempArr);
                        quickSort(intArr,0,intArr.length-1);
                        displayContent(intArr);
                    }
                }
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
    
    private static int[] quickSort(int[] inputArr,int low, int high) {
        int i = low;
        int j = high;
        // calculate pivot number, I am taking middle element as pivot
        int pivot =inputArr[low+(high-low)/2];
        while (i <= j) {
            /**
             * We will make sure left side small element and at right side
             * greater than pivot should be present.Once the search 
             * is done, then we exchange both numbers.
             */
            while (inputArr[i] < pivot) {
                i++;
            }
            while (inputArr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j,inputArr);
                i++;
                j--;
            }
        }
        if (low < j)
            inputArr = quickSort(inputArr,low, j);
        if (i < high)
            inputArr = quickSort(inputArr,i, high);
        return inputArr;
    }
    
    public static void sort_Merge(int[] userArr1,int[] userArr2, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            sort_Merge(userArr1,userArr2,low,mid);
            sort_Merge(userArr1,userArr2,mid+1,high);
            merge(userArr1,userArr2,low,mid,high);
        }
    }
 
    private static void merge(int[] userArr1,int[] userArr2, int low, int mid, int high){
        int h = low, i = low, j = mid+1, k;
        while ((h <= mid) && (j <= high)) {
            if (userArr1[h] <= userArr1[j]) {
                userArr2[i++] = userArr1[h++]; 
            }
            else { 
                userArr2[i++] = userArr1[j++]; 
            }
        }
 
        if (h > mid) {
            for (k=j; k<=high; k++) {
                userArr2[i++] = userArr1[k];
            }
        }
        else{
            for (k=h; k<=mid; k++) {
                userArr2[i++] = userArr1[k];
            }
        }
        for (k=low; k <= high; k++) 
            userArr1[k] = userArr2[k];
    }
 
    public static void displayContent(int[] userArr){
        for(int count =userArr.length-1; count>=0; count--)
        {
            System.out.print(userArr[count]+" ");
        }
        System.out.println();
    }
 
    public static void swap(int pos1,int pos2,int[] userArr){
        int temp = 0;
        temp = userArr[pos1];
        userArr[pos1] = userArr[pos2];
        userArr[pos2] = temp;
    }
}
