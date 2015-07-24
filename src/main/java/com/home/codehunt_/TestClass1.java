package com.home.codehunt_;

public class TestClass1 {

    static int equilibrium(int arr[]) {
        int n = arr.length;
        int sum = 0;
        int leftsum = 0;
        int i;

        for (i = 0; i < n; ++i)
            sum += arr[i];

        for (i = 0; i < n; ++i) {
            sum -= arr[i];

            if (leftsum == sum)
                return 1;

            leftsum += arr[i];
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] intr = get_ranks1(new String[] { "lucknow", "bac", "aaa", "abba" });
        for (int i = 0; i < intr.length; i++) {
            System.out.println(intr[i]);

        }
    }

    static int[] get_ranks1(String[] words) {
        int[] intArr = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            if (countDuplicates(words[i]) != 0) {
                intArr[i] = findRank(words[i]) / countDuplicates(words[i]);
            } else {
                intArr[i] = findRank(words[i]);
            }
        }
        return intArr;
    }

    static int countDuplicates(String str) {
        int count = 0;
        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) != null) {
                count++;
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        return count;
    }

    static int findRank(String str) {
        int len = str.length();
        int rank = 1, i;
        int buffer[] = new int[256];
        changeCount(buffer, str);
        for (i = 0; i < len; ++i) {
            rank += buffer[((int) str.charAt(i)) - 1] * fact(len - i - 1);
            updatecount(buffer, str.charAt(i));
        }
        return rank;
    }

    static int fact(int n) {
        return (n <= 1) ? 1 : n * fact(n - 1);
    }

    static void changeCount(int[] count, String str) {
        int i;
        for (i = 0; i < str.length(); ++i)
            count[(int) str.charAt(i)] = count[(int) str.charAt(i)] + 1;
        for (i = 1; i < 256; ++i)
            count[i] += count[i - 1];
    }

    static void updatecount(int[] count, char ch) {
        int i;
        for (i = ch; i < 256; ++i)
            count[i] = count[i] - 1;
    }

}
