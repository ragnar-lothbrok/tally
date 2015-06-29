package com.test.hackerjune;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BankersAlgorithm {

    private int need[][], allocated[][], max[][], available[], numOfProcess, numOfResources;

    public void initialize() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Please Entere process and resources : ");
        String line = br.readLine();
        String str[] = line.trim().split(" ");
        numOfProcess = Integer.parseInt(str[0]);
        numOfResources = Integer.parseInt(str[1]);
        
        allocated = new int[numOfProcess][numOfResources];
        need = new int[numOfProcess][numOfResources];
        max = new int[numOfProcess][numOfResources];
        available = new int[numOfResources];

        System.out.println("Please enter allocation matrix : ");
        for (int i = 0; i < numOfProcess; i++) {
            line = br.readLine();
            str = line.trim().split(" ");
            for (int j = 0; j < numOfResources; j++) {
                allocated[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println("Please enter max matrix : ");
        for (int i = 0; i < numOfProcess; i++) {
            line = br.readLine();
            str = line.trim().split(" ");
            for (int j = 0; j < numOfResources; j++) {
                max[i][j] = Integer.parseInt(str[j]);
            }
        }

        System.out.println("Please enter available matrix : ");
        line = br.readLine();
        str = line.trim().split(" ");
        for (int i = 0; i < numOfResources; i++) {
            available[i] = Integer.parseInt(str[i]);
        }
    }

    private void calculateNeedMatrix() {
        for (int i = 0; i < numOfProcess; i++) {
            for (int j = 0; j < numOfResources; j++) {
                need[i][j] = max[i][j] - allocated[i][j];
            }
        }
        display();
    }
    
    private void display() {
        for (int i = 0; i < numOfProcess; i++) {
            for (int j = 0; j < numOfResources; j++) {
                System.out.print(need[i][j]+" ");
            }
            System.out.println();
        }
    }

    private boolean check(int i) {
        for (int j = 0; j < numOfResources; j++) {
            if (available[j] < need[i][j]) {
                return false;
            }
        }
        return true;
    }

    public void isSafeState() throws Exception {
        initialize();
        calculateNeedMatrix();
        boolean[] done = new boolean[numOfProcess];
        int k = 0;
        while (k < numOfProcess) {
            boolean allocated = false;
            for (int i = 0; i < numOfProcess; i++) {
                if (!done[i] && check(i)) {
                    for (int j = 0; j < numOfResources; j++) {
                        available[j] = available[j] - need[i][j] + max[i][j];
                    }
                    System.out.println("Allocated process : "+i);
                    allocated = done[i] = true;
                    k++;
                }
            }
            if(!allocated)
                break;
        }
        if(k == numOfProcess)
            System.out.println("Can be Safely allocated");
        else
            System.out.println("Can't be Safely allocated");
        
    }
    
    public static void main(String[] args) throws Exception {
        BankersAlgorithm bankersAlgorithm = new BankersAlgorithm();
        bankersAlgorithm.isSafeState();
    }
}


/*
Please Enter process and resources : 
3 4
Please enter allocation matrix : 
1 2 2 1
1 0 3 3
1 2 1 0
3 3 4 2 
1 1 3 4
1 3 5 0
3 1 1 2
Please enter max matrix : 
Please enter available matrix : 

2 1 0 1 
0 1 0 1 
0 1 4 0 
 */
