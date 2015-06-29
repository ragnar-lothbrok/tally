package com.home.zoomcar;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class TestClass {

    public int OPT[][]; // contains the optimal solution
    // during every recurrence step.
    public String optimalChange[][]; // string representation of optimal
                                     // solutions.

    /**
     * List of all possible solutions for the target
     */
    public ArrayList<String> allPossibleChanges = new ArrayList<String>();

    /**
     * The target amount.
     */
    private int target;

    /**
     * Copy of the denominations that was used to generate this solution
     */
    public int[] denoms;

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
    }

    private static void findAllCombinationsRecursive(String tsoln, int startIx, int remainingTarget, TestClass answer) {
        for (int i = startIx; i < answer.denoms.length; i++) {
            int temp = remainingTarget - answer.denoms[i];
            String tempSoln = tsoln + "" + answer.denoms[i] + ",";
            if (temp < 0) {
                break;
            }
            if (temp == 0) {
                answer.allPossibleChanges.add(tempSoln);
                break;
            } else {
                findAllCombinationsRecursive(tempSoln, i, temp, answer);
            }
        }
    }

    public TestClass(int target, int[] denoms) {
        this.target = target;
        this.denoms = denoms;
    }

    public static TestClass findAllPossibleCombinations(int target, int[] denoms) {
        TestClass soln = new TestClass(target, denoms);
        String tempSoln = new String();
        findAllCombinationsRecursive(tempSoln, 0, target, soln);
        return soln;
    }

    public static void calculateProbability(Integer steps, Integer probability) {
        float twoProbability = (probability * 1.0f / 100);
        float threeProbability = 1 - twoProbability;
        float totalProbability = 0;
        TestClass testClass = findAllPossibleCombinations(steps, new int[] { 2, 3 });
        if (testClass.allPossibleChanges.size() > 0) {
            for (String value : testClass.allPossibleChanges) {
                value = value.replaceAll(",,", ",");
                int noOfTwo = 0;
                int noOfThree = 0;
                for (int i = 0; i < value.length(); i++) {
                    if (value.charAt(i) == '2') {
                        noOfTwo++;
                    } else if (value.charAt(i) == '3') {
                        noOfThree++;
                    }
                }
                StoreSteps storeSteps = new StoreSteps();
                storeSteps.setNoofThree(noOfThree);
                storeSteps.setNoOfTwo(noOfTwo);
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
