package com.home.zoomcar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class TestClass {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        try {
            line = line.replace("  ", "");
            String[] str = line.trim().split(" ");
            if (str.length == 2) {
                Integer steps = Integer.parseInt(str[0]);
                Integer probability = Integer.parseInt(str[1]);
                calculateProbability(steps, probability);
            }
        } catch (Exception exception) {
        }
//        
        findMaximumProfit(new int[]{23,12,25,32,8,26,48,4});
        findMaximumProfit(new int[]{3,10,1,20});
    }

    private static void findMaximumProfit(int[] inputArr) {
        int startPos1 = 0;
        int startPos2 = 0;
        int endPos = -1;
        int profit = 0;

        for (int i = 1; i < inputArr.length; i++) {
            if (startPos1 != -1 && inputArr[startPos1] > inputArr[i]){
                startPos2 = startPos1;
                startPos1 = i;
            }
            else if (inputArr[i] - inputArr[startPos1] > profit) {
                endPos = i;
                profit = inputArr[endPos] - inputArr[startPos1];
            }
        }
        System.out.println(" Profit :" + profit+" startPos1 : "+(startPos2 == 0 ? startPos1 : startPos2)+" End Pos : "+endPos);
    }

    public static void calculateProbability(Integer steps, Integer probability) {
        float twoProbability = (probability * 1.0f / 100);
        float threeProbability = 1 - twoProbability;

        float totalProbability = 0;
        List<StoreSteps> stepsListSix = new ArrayList<StoreSteps>();
        if (steps < 2) {
            System.out.println("0");
        }
        int remainder = steps % 6;
        if (steps / 6 >= 1) {
            StoreSteps storeSteps1 = new StoreSteps();
            storeSteps1.setNoOfTwo(3 * (steps / 6));
            stepsListSix.add(storeSteps1);

            StoreSteps storeSteps2 = new StoreSteps();
            storeSteps2.setNoofThree(2 * (steps / 6));
            stepsListSix.add(storeSteps2);
        }
        if (remainder >= 2) {
            int stepArr[] = getSteps(remainder);
            if (stepsListSix != null && stepsListSix.size() > 0) {
                for (StoreSteps step : stepsListSix) {
                    step.setNoOfTwo(step.getNoOfTwo() + stepArr[0]);
                    step.setNoofThree(step.getNoofThree() + stepArr[1]);
                }
            } else {
                StoreSteps storeSteps = new StoreSteps();
                storeSteps.setNoOfTwo(stepArr[0]);
                storeSteps.setNoofThree(stepArr[1]);
                stepsListSix.add(storeSteps);
            }
        }

        List<StoreSteps> stepsListFive = new ArrayList<StoreSteps>();
        remainder = steps % 5;
        if (steps / 5 >= 1) {
            StoreSteps storeSteps = new StoreSteps();
            storeSteps.setNoOfTwo(1 * (steps / 5));
            storeSteps.setNoofThree(1 * (steps / 5));
            if (!stepsListSix.contains(storeSteps))
                stepsListFive.add(storeSteps);
        }
        if (remainder >= 2) {
            int stepArr[] = getSteps(remainder);
            if (stepsListFive != null && stepsListFive.size() > 0) {
                for (StoreSteps step : stepsListFive) {
                    step.setNoOfTwo(step.getNoOfTwo() + stepArr[0]);
                    step.setNoofThree(step.getNoofThree() + stepArr[1]);
                }
            } else {
                StoreSteps storeSteps = new StoreSteps();
                storeSteps.setNoOfTwo(stepArr[0]);
                storeSteps.setNoofThree(stepArr[1]);
                if (!stepsListSix.contains(storeSteps))
                    stepsListFive.add(storeSteps);
            }
        }
        stepsListSix.addAll(stepsListFive);
        if (stepsListSix != null && stepsListSix.size() > 0) {
            for (StoreSteps storeSteps : stepsListSix) {
                if (storeSteps.getNoofThree() != 0 && storeSteps.getNoOfTwo() != 0) {
                    totalProbability = totalProbability
                            + (((storeSteps.getNoofThree() * threeProbability) * (storeSteps.getNoOfTwo() * twoProbability)) * (factorial(storeSteps
                                    .getNoofThree() + storeSteps.getNoOfTwo()) / (factorial(storeSteps.getNoofThree()) * factorial(storeSteps
                                    .getNoOfTwo()))));
                } else {
                    totalProbability = totalProbability + (storeSteps.getNoofThree() * threeProbability);
                    totalProbability = totalProbability + (storeSteps.getNoOfTwo() * twoProbability);
                }
            }
        }
        System.out.printf("%.6f", totalProbability);
    }

    public static int[] getSteps(int remainder) {
        int[] stepType = new int[2];
        switch (remainder) {
            case 2:
                stepType[0] = 1;
                break;
            case 3:
                stepType[1] = 1;
                break;
            case 4:
                stepType[0] = 2;
                break;
            case 5:
                stepType[0] = 1;
                stepType[1] = 1;
                break;
        }
        return stepType;
    }

    static class StoreSteps {
        Integer noOfTwo = 0;
        Integer noofThree = 0;

        public Integer getNoOfTwo() {
            return noOfTwo;
        }

        public void setNoOfTwo(Integer noOfTwo) {
            this.noOfTwo = noOfTwo;
        }

        public Integer getNoofThree() {
            return noofThree;
        }

        public void setNoofThree(Integer noofThree) {
            this.noofThree = noofThree;
        }

        @Override
        public boolean equals(Object obj) {
            StoreSteps other = (StoreSteps) obj;
            if (obj != null && other != null && noOfTwo.equals(other.noOfTwo) && noofThree.equals(other.noofThree))
                return true;
            return false;
        }

        @Override
        public String toString() {
            return "StoreSteps [noOfTwo=" + noOfTwo + ", noofThree=" + noofThree + "]";
        }

    }

    public static int factorial(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
