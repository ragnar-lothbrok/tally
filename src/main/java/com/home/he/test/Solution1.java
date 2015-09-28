package com.home.he.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    public static void main(String[] args) throws IOException {

        // int arr[] = { 14, 31, 15, 7, 2 };
        // swap_array(arr);

        String arr[] = { "GR.", "BG.", "..." };

    }

    static int gridColouring(String[] grid) {
        int count = 0;
        if (grid != null && grid.length > 0) {
            int row = grid.length;
            int col = grid[0].trim().length();
            char[][] gridArr = new char[row][col];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < col; j++) {
                    gridArr[i][j] = grid[i].charAt(j);
                }
            }
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    switch (gridArr[i][j]) {
                        case 'G':
                            count = count + 2;
                            break;
                        case 'R' : 
                            if(gridArr[i][j-1] == 'R' && gridArr[i][j+1] == 'R'){
                                count++;
                            }
                    }
                }
            }
        }

        return count;

    }

    static void swap_array(int[] a) {
        if (a != null && a.length > 0) {
            List<Block> blockList = new ArrayList<Block>();
            for (int i = 0; i < a.length; i++) {
                blockList.add(new Block(a[i], Integer.bitCount(a[i])));
            }
            Collections.sort(blockList);
            for (Block block : blockList) {
                System.out.println(block.getValue());
            }
        }
    }

    static class Block implements Comparable<Block> {
        private Integer value;
        private Integer bitCount;

        public Block(Integer value, Integer bitCount) {
            super();
            this.value = value;
            this.bitCount = bitCount;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Integer getBitCount() {
            return bitCount;
        }

        public void setBitCount(Integer bitCount) {
            this.bitCount = bitCount;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + value;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Block other = (Block) obj;
            if (value != other.value)
                return false;
            return true;
        }

        public int compareTo(Block block) {
            int result = block.getBitCount().compareTo(this.getBitCount());
            if (result == 0) {
                result = block.getValue().compareTo(this.getValue());
            }
            return result;
        }

        @Override
        public String toString() {
            return "Block [value=" + value + ", bitCount=" + bitCount + "]";
        }

    }

}
