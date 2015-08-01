package com.he.codesteller_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

// https://www.hackerearth.com/codestellar-5/algorithm/level-selections/
public class Solution3 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String str[] = line.split(" ");
        int numOfSwap = Integer.parseInt(str[1]);
        line = br.readLine();
        str = line.split(" ");
        String[] tempArr = new String[str.length];
        tempArr = Arrays.copyOf(str, str.length);
        Arrays.sort(tempArr, new StringComparator());

        for (int i = 0; i < numOfSwap; i++) {
            int pos = -1;
            for(int k=0;k<str.length;k++){
                if(tempArr[0] == str[k]){
                    pos = k;
                    break;
                }
            }
            if (!tempArr[i].equals(str[i])) {
                String temp = str[i];
                str[i] = str[pos];
                str[pos] = temp;
            } else if (pos == i) {
                i--;
            } else {
                break;
            }
        }
        for (int j = 0; j < str.length; j++) {
            System.out.println(str[j] + " ");
        }

    }
}

class StringComparator implements Comparator<String> {

    public int compare(String s1, String s2) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append(s1).append(s2);

        StringBuilder sb2 = new StringBuilder();
        sb2.append(s2).append(s1);

        return sb1.toString().compareTo(sb2.toString());
    }

}
