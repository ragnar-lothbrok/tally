package com.he.capillary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.hackerearth.com/capillary-java-hiring-challenge-2015/problems/b8446db6ffcf4296a640b6b4138ea4c8/
public class MMORPG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int numOfSS = Integer.parseInt(str[0]);
        int numOfTT = Integer.parseInt(str[1]);
        int numOfTTRange = Integer.parseInt(str[2]);
        line = br.readLine();
        line = br.readLine();
        str = line.split(" ");
        int intArr[] = new int[str.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(intArr);
        int result = 0;
        int i = 0;
        while (i < intArr.length) {
            if (intArr[i] <= numOfTTRange) {
                i++;
            } else {
                break;
            }
        }
        if (i * numOfSS > numOfTT) {
            result += numOfTT;
        }else{
            result += (i*numOfSS);
        }
        result += (intArr.length - i) * (numOfSS);
        System.out.println(result);
    }
}
