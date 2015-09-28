package com.home.techgig.wipro;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {

        // System.out.println(collegecomparison(new int[] { 12, 11, 5, 2, 7, 5,
        // 11 }, new int[] { 5, 0, 5, 7, 11, 2 }));
        // System.out
        // .println(collegecomparison(new int[] { 12, 11, 5, 2, 7, 5, 11 }, new
        // int[] { 5, 0, 5, 7, 11, 2, 11 }));
        // System.out
        // .println(collegecomparison(new int[] { 12, 11, 5, 2, 7, 5, 11 }, new
        // int[] { 5, 12, 5, 7, 11, 2, 11 }));
        // System.out
        // .println(collegecomparison(new int[] { 12, 11, 5, 2, 7, 5, -11 }, new
        // int[] { 5, 0, 5, 7, 11, 2, 11 }));

        System.out.println(operations_seq(3, new String[] { "11#3#44", "12#26#13", "21#33#21" }, new String[] {
                "33#44#11", "3#13#12", "21#26#21" }));
        
        System.out.println(operations_seq(1, new String[] { "11" }, new String[] {
                "21" }));
        
        System.out.println(operations_seq(2, new String[] { "11#3", "12#26"}, new String[] {
                "11#26", "12#3"}));

    }

    public static final String iNVALID = "invalid";
    public static final String YES = "yes";
    public static final String NO = "no";

    public static String operations_seq(int input1,String[] input2,String[] input3){
        String result = iNVALID;
        int[][] input = null;
        int[][] output = null;
        if (input1 > 0) {

            input = new int[input1][input1];
            output = new int[input1][input1];
            String str[] = null;
            if ((input2 != null && input2.length == input1) && (input3 != null && input3.length == input1)) {
                for (int i = 0; i < input2.length; i++) {
                    str = input2[i].split("#");
                    for (int j = 0; j < str.length; j++) {
                        input[i][j] = Integer.parseInt(str[j]);
                    }
                }

                for (int i = 0; i < input3.length; i++) {
                    str = input3[i].split("#");
                    for (int j = 0; j < str.length; j++) {
                        output[i][j] = Integer.parseInt(str[j]);
                    }
                }

                Map<Integer, Integer> map = new HashMap<Integer, Integer>();
                for (int i = 0; i < output.length; i++) {
                    if (map.get(output[0][i]) == null) {
                        map.put(output[0][i], 1);
                    } else {
                        map.put(output[0][i], map.get(output[0][i]) + 1);
                    }
                }

                int count = 0;
                int index = -1;
                for (int i = 0; i < input.length; i++) {
                    if (map.get(input[0][i]) == null) {
                        count++;
                        index = i;
                    } else if (map.get(input[0][i]) == 1) {
                        map.remove(input[0][i]);
                    } else {
                        map.put(input[0][i], map.get(input[0][i]) - 1);
                    }
                }
                if (count != 1 || map.size() > 1) {
                    result = iNVALID;
                } else {
                    result = testRotation(input, output, 0, index);
                }

            } else {
                result = iNVALID;
            }
        } else {
            result = iNVALID;
        }
        return result;
    }

    public static String testRotation(int[][] input, int[][] output, int x, int y) {
        String result = null;
        int temp = input[input.length - 1][y];
        for (int i = input.length - 1; i > 0; i--) {
            input[i][y] = input[i - 1][y];
        }
        input[0][y] = temp;

        for (int i = 0; i < input.length; i++) {
            if (isRotate(input, output, i)) {
                continue;
            } else {
                result = NO;
                break;
            }
        }

        if (result == null) {
            result = YES;
        }
        return result;
    }

    private static boolean isRotate(int[][] input, int[][] output, int i) {
        String str = null;
        String str2 = null;
        for (int j = 0; j < input.length; j++) {
            if (str == null) {
                str = input[i][j] + "";
            } else {
                str += "," + input[i][j];
            }

            if (str2 == null) {
                str2 = output[i][j] + "";
            } else {
                str2 += "," + output[i][j];
            }
        }

        str = str + "," + str;

        if (str.indexOf(str2) == -1) {
            return false;
        } else {
            return true;
        }

    }

    public static final String INVALID = "Invalid";
    public static final String EQUAL = "Equal";
    public static final String UNEQUAL = "Unequal";

    public static String collegecomparison(int[] input1, int[] input2) {
        String result = null;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if (input1 != null && input1.length > 0) {
            for (int value : input1) {
                if (value < 0) {
                    result = INVALID;
                    break;
                } else if (map.get(value) == null) {
                    map.put(value, 1);
                } else {
                    map.put(value, map.get(value) + 1);
                }
            }

            if (result == null) {
                if (input2 != null && input2.length > 0) {
                    for (int value : input2) {
                        if (value < 0) {
                            result = INVALID;
                            break;
                        } else if (map.get(value) == null) {
                            result = UNEQUAL;
                            break;
                        } else {
                            if (map.get(value).intValue() == 1) {
                                map.remove(value);
                            } else {
                                map.put(value, map.get(value) - 1);
                            }
                        }
                    }
                } else {
                    result = UNEQUAL;
                }
            }
        } else if (input2 != null && input2.length > 0) {
            result = UNEQUAL;
        }
        if (result == null)
            result = EQUAL;
        return result;
    }

    public static String[] getHorizon(int input1, String[] input2) {
        List<String> list = new ArrayList<String>();
        List<Coordinates> coList = new ArrayList<Coordinates>();
        String[] str = null;
        if (input2 != null && input2.length > 0) {
            for (String value : input2) {
                str = value.split("#");
                coList.add(new Coordinates(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2])));
            }
        }
        str = new String[list.size()];
        list.toArray(str);
        return str;
    }

    static class Coordinates {
        private int x;
        private int y;
        private int z;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }

        public Coordinates(int x, int y, int z) {
            super();
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public String toString() {
            return "Coordinates [x=" + x + ", y=" + y + ", z=" + z + "]";
        }
    }

    static class Horizon {
        private int x;
        private int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public Horizon(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Coordinates [x=" + x + ", y=" + y + "]";
        }
    }
}
