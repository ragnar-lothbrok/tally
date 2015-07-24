package com.home.codehunt_;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Solution2 {

    public static void test() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 64 * 1024);

        final int N = Integer.parseInt(br.readLine().trim(), 10);
        final String[] data = br.readLine().trim().split(" ");
        final long[] hist = new long[N];

        for (int i = 0; i < N; i++) {
            final long v = Long.parseLong(data[i], 10);
            hist[i] = v;
        }

        long res0 = 0L;
        for (int i = 0; i < N; i++) {
            int prevIndex = i;
            for (; prevIndex >= 1; prevIndex--) {
                if (hist[prevIndex - 1] < hist[i]) {
                    break;
                }
            }
            int postIndex = i;
            for (; postIndex < hist.length - 1; postIndex++) {
                if (hist[postIndex + 1] < hist[i]) {
                    break;
                }
            }
            final long area = hist[i] * (postIndex - prevIndex + 1);
            if (area > res0) {
                res0 = area;
            }
        }
        System.out.println(res0);

        br.close();
        br = null;
    }

    public static void main(String[] args) {
        longestConsecutive(new int[] { 100, 4, 200, 1, 3/*, 2*/ });
    }
    
    public static int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length == 0) return 0;
        int max = 1;
        HashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
        for(int d : num){
            if(!map.containsKey(d)){
                map.put(d, 1);
                if(map.containsKey(d-1)) max = Math.max(max, mergeInterval(map, d-1, d));
                if(map.containsKey(d+1)) max = Math.max(max, mergeInterval(map, d, d+1));
            }
        }
        System.out.println(map);
        return max;
    }
    public static int mergeInterval(HashMap<Integer, Integer> map, int left, int right){

        int leftBorder = left - map.get(left) + 1;
        int rightBorder = right + map.get(right) - 1;
        int len = rightBorder - leftBorder + 1;
        map.put(leftBorder, len);
        map.put(rightBorder, len);
        return len;
    }

//    public static int longestConsecutive(int[] num) {
//        // if array is empty, return 0    
//        if (num.length == 0) {
//            return 0;
//        }
//
//        Set<Integer> set = new HashSet<Integer>();
//        int max = 1;
//
//        for (int e : num)
//            set.add(e);
//
//        for (int e : num) {
//            if (!set.contains(e))
//                continue;
//            int left = e - 1;
//            int right = e + 1;
//            int count = 1;
//
//            while (set.contains(left)) {
//                count++;
//                set.remove(left);
//                left--;
//            }
//
//            while (set.contains(right)) {
//                count++;
//                set.remove(right);
//                right++;
//            }
//
//            max = Math.max(count, max);
//        }
//
//        return max;
//    }

}
