package com.home.strings;

public class BinarySearch {

    private static int[] arr = { 1, 3, 5, 7, 9, 11, 13, 15, 18 };

    public static void main(String[] args) {
        binarySearch(arr, 0, arr.length, 18);
        getTwoNumSum();
        getTripletSum();
    }

    private static void getTwoNumSum() {
        int sum = 34;
        int k = arr.length - 1;
        int i = 0;
        while (i < k) {
            if (arr[i] + arr[k] == sum) {
                System.out.println(i + " " + k);
                i++;
                k--;
            } else if (arr[i] + arr[k] > sum) {
                k--;
            } else {
                i++;
            }
        }
    }

    private static void getTripletSum() {
        int sum = 34;
        int left;
        int right;
        for (int i = 0; i < arr.length; i++) {
            left = i+1;
            right = arr.length-1;
            while(left < right){
                if(arr[i]+arr[left]+arr[right] == sum){
                    System.out.println(arr[i]+" "+arr[left]+" "+arr[right]);
                    left++;
                    right--;
                }else if(arr[i]+arr[left]+arr[right] < sum){
                    left++;
                }else{
                    right--;
                }
            }
        }

    }

    private static int binarySearch(int[] array, int lower, int upper, int target) {
        int index = 0;
        int mid = (lower + upper) / 2;
        while (mid > 0) {
            mid = (lower + upper) / 2;
            if (array[mid] < target) {
                lower = mid + 1;
            } else if (array[mid] > target) {
                upper = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        System.out.println(index);
        return index;
    }

}
