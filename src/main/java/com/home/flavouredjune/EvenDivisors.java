package com.home.flavouredjune;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EvenDivisors {

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        for (int i = 0; i < N; i++) {
            totalEvenDivisors(Long.parseLong(br.readLine()));
        }
    }

    public static void totalEvenDivisors(long numbers) {
        if (numbers <= 1 || (numbers % 2 != 0)) {
            System.out.println(0);
        } else {
            Long n = numbers;
            Map<Long, Integer> factors = new HashMap<Long, Integer>();
            for (long i = 2; i <= n / i; i++) {
                while (n % i == 0) {
                    factors.put(i, factors.get(i) == null ? 1 : factors.get(i) + 1);
                    n /= i;
                }
            }
            if (n > 1) {
                factors.put(n, factors.get(n) == null ? 1 : factors.get(n) + 1);
            }

            int totalCount = 1;
            int oddCount = 0;
            for (Entry<Long, Integer> entry : factors.entrySet()) {
                if(factors.size() ==1){
                    totalCount = entry.getValue();
                }else{
                    if (entry.getKey() % 2 != 0) {
                        if (oddCount == 0)
                            oddCount = 1;
                        oddCount *= (entry.getValue() + 1);
                    }
                    totalCount *= (entry.getValue() + 1);
                }
            }
            System.out.println(totalCount - oddCount);
        }
    }
}
