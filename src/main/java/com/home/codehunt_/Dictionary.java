package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
//https://www.hackerearth.com/code_mania_20/algorithm/listing-names-3/
public class Dictionary {

    public static void main(String args[]) throws Exception {
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            int N = Integer.parseInt(line);
            Map<String,Integer> treeMap = new TreeMap<String,Integer>();
            for (int i = 0; i < N; i++) {
                line = br.readLine().trim();
                if(treeMap.get(line) == null){
                    treeMap.put(line, 1);
                }else{
                    treeMap.put(line, treeMap.get(line)+1);
                }
            }
            
            for(Entry<String,Integer> entry : treeMap.entrySet()){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }catch(Exception exception){
            
        }
    }

}
