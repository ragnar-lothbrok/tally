package com.home.strings;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DecimalToRoman {
    private static Map<Integer, String> romanMap = new LinkedHashMap<Integer, String>();

    static {
        romanMap.put(1000, "M");
        romanMap.put(500, "D");
        romanMap.put(100, "C");
        romanMap.put(50, "L");
        romanMap.put(10, "X");
        romanMap.put(5, "V");
        romanMap.put(1, "I");
    }

    public static void main(String[] args) {
        convertIntoRoman(114);
    }

    private static void convertIntoRoman(int number) {
        StringBuffer sb = new StringBuffer();
        for (Entry<Integer, String> entry : romanMap.entrySet()) {
            if (number > 0 && number == entry.getKey() - 1) {
                sb.append("I" + entry.getValue());
                number = 0;
            } else if (number >= entry.getKey()) {
                int mul = (number / entry.getKey());
                while (mul > 0) {
                    sb.append(entry.getValue());
                    mul--;
                }
                number = number % entry.getKey();
            }
        }
        System.out.println(sb.toString());
    }

}
