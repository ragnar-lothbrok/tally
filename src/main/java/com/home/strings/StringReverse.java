package com.home.strings;

public class StringReverse {

    private static final String inputStr = "Do or do not, there is no try";

    public static void main(String[] args) {

        reverseStringApproach1();

        reverseStringApproach2();

    }

    private static void reverseStringApproach2() {
        StringBuffer sb = new StringBuffer();
        for (int i = inputStr.length() - 1; i >= 0; i--) {
            int k = i;
            while (i >= 0 && inputStr.charAt(i) != ' ') {
                if (i == 1) {
                    i = 0;
                    break;
                }
                i--;
            }
            if (i != 0) {
                sb.append(inputStr.substring(i + 1, k + 1) + " ");
            } else {
                sb.append(inputStr.substring(i, k + 1) + " ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void reverseStringApproach1() {
        String str[] = inputStr.trim().split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = (str.length - 1); i >= 0; i--) {
            sb.append(str[i] + " ");
        }

        System.out.println(sb.toString());
    }

}
