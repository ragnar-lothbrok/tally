package com.test.Shopsense;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {

    public static void main(String[] args) {
        
        List<String[]> outerArr = new ArrayList<String[]>();    
        String[] myString1= {"hey","hey","hey","hey"};  
        outerArr .add(myString1);
        String[] myString2= {"you","printcat","you","you"};
        outerArr .add(myString2);
        System.out.println(Arrays.toString(outerArr.get(1)));
        System.out.println(outerArr.get(1)[1]);
        
    }
}
