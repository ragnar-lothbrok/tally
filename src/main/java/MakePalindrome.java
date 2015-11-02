public class MakePalindrome {

    static int findMinInsertionsDP(char str[]) {
        int n = str.length;
        int table[][] = new int[n][n];
        int l, h, gap;

        // Fill the table
        for (gap = 1; gap < n; ++gap)
            for (l = 0, h = gap; h < n; ++l, ++h)
                table[l][h] = (str[l] == str[h]) ? table[l + 1][h - 1]
                        : (Math.min(table[l][h - 1], table[l + 1][h]) + 1);

        return table[0][n - 1];
    }
    
    public static void main(String[] args) {
        
        System.out.println(findMinInsertionsDP("ab".toCharArray()));
        
    }

}
