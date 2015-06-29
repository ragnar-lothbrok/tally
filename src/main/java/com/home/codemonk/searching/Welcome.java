package com.home.codemonk.searching;

import java.util.TreeMap;


public class Welcome extends java.util.TreeSet{

    String title;
    int value;
    
    public static void main(String [] args) 
    {
        java.util.TreeSet t = new java.util.TreeSet();
        t.clear();
    }
    public void clear() 
    {
        TreeMap m = new TreeMap();
        m.clear();
    }
    
    static
    { 
       System.out.print("Planet "); 
//       System.exit(0);
       } 
      
       static { 
       System.out.print("Welcome "); 
//       System.exit(0);
       } 

    public Welcome() {
        title += " Planet";
    }

    public void Welcome() {
        System.out.println(title + " " + value);
    }

    public Welcome(int value) {
        this.value = value;
        title = "Welcome";
        Welcome();
    }

   /* public static void main(String args[]) {
        Welcome t = new Welcome(5);
        int[] x_tuple;
        int q=0;
        
        final int i = 22;
        byte b = i;
        System.out.println(i + ", " + b);
        
        
        String s1 = "Hello";
        StringBuffer sb = new StringBuffer(s1);
        sb.reverse();
        s1.concat(sb.toString());
        System.out.println(s1 + sb + s1.length() + sb.length());
    }*/
}
