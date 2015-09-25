package com.home.flipkart;

//You have N friends and you have to distribute the choclates such that if arr[i] > arr[i+1] den i+1 should have more choclates den i. 
public class ChoclateProblem {

    public static void main(String[] args) {
        
        int arr[] = {1,2,3,4,3,2,1,2,3,4,4};
        int arr1[] = {4,3,2,1};
        int arr2[] = {1,2,4,3,2,1,2};
        System.out.println(countMinChoclates(arr));
        
    }
    
    public static int countMinChoclates(int arr[]){
        int count =0;
        int chocValue = 1;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i] < arr[i+1]){
                count += chocValue;
                chocValue++;
            }else if(arr[i] == arr[i+1]){
                count += chocValue;
            }else {
                int start = i;
                while(i+1 < arr.length && arr[i] > arr[i+1]){
                    i++;
                }
                count = count + (i-start+1)* (i-start+1+1)/2;
                if(chocValue < (i-start+1+1)){
                    chocValue =2;
                }else{
                    chocValue = (chocValue - (i-start+1-1));
                    count += ((i-start+1) * (chocValue-1));
                }
                if(i ==  arr.length-1){
                    break;
                }else{
                    i--;
                }
                
            }
        }
        return count;
    }
}
