package com.he.coditas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
///https://www.hackerearth.com/code-monk-greedy-technique/algorithm/the-legend-of-tanmay/
public class Solution4 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            line = br.readLine();
            String str[] = line.split(" ");
            List<Integer> positiveList = new ArrayList<Integer>();
            List<Integer> negativeList = new ArrayList<Integer>();
            for (int k = 0; k < str.length; k++) {
                int temp = Integer.parseInt(str[k]);
                if (temp >= 0) {
                    if (!(temp == 0 && positiveList.contains(temp)) || temp > 0) {
                        positiveList.add(temp);
                    }
                } else {
                    negativeList.add(temp);
                }
            }
            long min = 0;
            long max = 1;

            if (negativeList.size() > 0) {
                min = getMinimumFromNegative(negativeList);
                min = min * (getMaximum(positiveList) != 0 ? getMaximum(positiveList) : 1);
            } else {
                min = getMinimum(positiveList);
            }

            if (negativeList.size() > 0) {
                max = getMaximumFromNegative(negativeList);
                if (positiveList.size() > 0) {
                    max = max * getMaximum(positiveList);
                } else {
                    if (negativeList.size() == 1) {
                        max = negativeList.get(0);
                    }
                }
            } else {
                max = max * getMaximum(positiveList);
            }

            System.out.println(max + " " + min);
        }
    }

    private static long getMaximum(List<Integer> positiveList) {
        Long result = 1l;
        Collections.sort(positiveList);
        if (positiveList.size() == 1) {
            return positiveList.get(0);
        } else {
            Iterator<Integer> iterator = positiveList.iterator();
            while (iterator.hasNext()) {
                int temp = iterator.next();
                if (temp != 0)
                    result *= temp;
            }
        }
        return result;
    }

    private static long getMinimum(List<Integer> positiveList) {
        Collections.sort(positiveList);
        return positiveList.get(0);

    }

    private static long getMaximumFromNegative(List<Integer> negativeList) {
        Long result = 1l;
        Collections.sort(negativeList);
        if (negativeList.size() == 1) {
            return result;
        }
        if (negativeList.size() % 2 == 0) {
            for (int i = 0; i < negativeList.size(); i++) {
                result *= negativeList.get(i);
            }
        } else {
            for (int i = 0; i < negativeList.size() - 1; i++) {
                result *= negativeList.get(i);
            }
        }
        return result;
    }

    private static long getMinimumFromNegative(List<Integer> negativeList) {
        Long result = 1l;
        Collections.sort(negativeList);
        if (negativeList.size() % 2 == 0) {
            for (int i = 0; i < negativeList.size() - 1; i++) {
                result *= negativeList.get(i);
            }
        } else {
            for (int i = 0; i < negativeList.size(); i++) {
                result *= negativeList.get(i);
            }
        }
        return result;
    }
}
