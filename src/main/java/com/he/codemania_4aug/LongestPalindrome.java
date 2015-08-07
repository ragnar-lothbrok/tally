package com.he.codemania_4aug;

public class LongestPalindrome {

    public static void main(String[] args) {
        // longestPalindromeSimple("abcba");
        // longestPalindromeSimple("1234");
        // longestPalindromeSimple("12321");
        // longestPalindromeSimple("9912321456");
        // longestPalindromeSimple("9912333321456");
        // longestPalindromeSimple("12145445499");
        // longestPalindromeSimple("1223213");
        // longestPalindromeSimple("abb");
        longestPalindromeSimple("thisisapalindromeemordnilapasisiht");
        countPalindrome("thisisapalindromeemordnilapasisiht");
        // palindrome("dskjkd");
        // longestPalindromeSimple("dddd");
        // longestPalindromeSimple("caad");
        // modifyString("abaaba", new int[13]);
        // modifyString("abababa", new int[15]);
    }

    static public void countPalindrome(String line) {
        int len = line.length();
        int l = len;
        for (int i = 0; i < l; i++) {
            for (int j = i + 2; j < l + 1; j++) {
                String str = line.substring(i, j);
                StringBuilder b = new StringBuilder(str);
                if (b.reverse().toString().equals(str)) {
                    len++;
                }
            }
        }
        System.out.println(len);
    }

    /*
     * static public String modifyString(String str, int arr[]) { StringBuffer
     * sb = new StringBuffer(); sb.append("|"); for (int i = 0; i <
     * str.length(); i++) { sb.append(str.charAt(i) + "|"); } int count = 0; for
     * (int i = 0; i < sb.length(); i++) { int low = i; int high = i; if
     * (sb.charAt(i) == '|') count = 0; else count = 1; while (low >= 0 && high
     * < sb.length() && sb.charAt(low) == sb.charAt(high)) { if (sb.charAt(low)
     * == '|' || sb.charAt(high) == '|') { low--; high++; continue; } else if
     * (low < high) { count = count + 2; } low--; high++; } arr[i] = count; }
     * for (int i = 0; i < arr.length; i++) { System.out.print(arr[i] + " "); }
     * return sb.toString(); }
     */

    static int count1 = 0;

    static public String intermediatePalindrome(String s, int left, int right) {
        if (left > right)
            return null;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
            count1++;
        }
        return s.substring(left + 1, right);
    }

    public static void longestPalindromeSimple(String s) {
        count1 = 0;
        if (s != null) {
            String longest = s.substring(0, 1);
            for (int i = 0; i < s.length(); i++) {
                // odd cases like 121
                String palindrome = intermediatePalindrome(s, i, i);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
                // even cases like 1221
                palindrome = intermediatePalindrome(s, i, i + 1);
                if (palindrome.length() > longest.length()) {
                    longest = palindrome;
                }
            }
            System.out.println(longest+" "+count1);
        }
    }
}
