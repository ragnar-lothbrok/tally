package com.he.codesteller_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

// /https://www.hackerearth.com/codestellar-5/algorithm/detecting-the-fraud-registrations/
public class Solution1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        Set<String> set = new HashSet<String>();
        Set<String> duplicateSet = new TreeSet<String>();
        for (int j = 0; j < N; j++) {
            line = br.readLine();
            if (set.contains(line)) {
                duplicateSet.add(line);
            } else
                set.add(line);
        }
        if(duplicateSet.size() > 0){
            System.out.println(duplicateSet.size());
            Iterator<String> iterator = duplicateSet.iterator();
            while(iterator.hasNext()){
                System.out.println(iterator.next());
            }
        }
    }

}
