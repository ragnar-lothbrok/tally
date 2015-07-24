//Rank of the student in given marks
package com.home.mayhum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompetitiveClass {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = br.readLine().trim().split(" ");
        short[] arr = new short[1001];
        for (int i = 0; i < str.length; i++) {
            arr[Integer.parseInt(str[i])] += 1;
        }
        int temp = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp2 = arr[i];
            if (i == arr.length - 1 && arr[i] > 1) {
                temp = arr[i];
                arr[i] = 1;
            } else if (i != arr.length - 1) {
                if (temp <= 1) {
                    if (arr[i] != 0) {
                        arr[i] = (short) (1 + arr[i + 1]);
                    } else {
                        arr[i] = (short) (arr[i + 1]);
                    }
                } else {
                    if(arr[i] !=0){
                        arr[i] = (short) (arr[i + 1] + temp);
                    }else{
                        arr[i] = (short) (arr[i + 1] + temp - 1);
                    }
                }
            }
            temp = temp2;
        }

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str.length; i++) {
            sb.append(arr[Integer.parseInt(str[i])] + " ");
        }
        sb.substring(0, sb.length() - 1);
        System.out.println(sb.toString());
    }
}
