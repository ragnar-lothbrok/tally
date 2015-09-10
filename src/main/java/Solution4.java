public class Solution4 {
    static int getInvCount(int arr[][]) {
        int inv_count = 0;
        for (int i = 0; i < 16 - 1; i++)
            for (int j = i + 1; j < 16; j++)
                if (arr[j / 4][j % 4] != 0 && arr[i / 4][i % 4] != 0 && arr[i / 4][i % 4] > arr[j / 4][j % 4])
                    inv_count++;
        return inv_count;
    }

    static boolean isSolvable(int puzzle[][]) {
        int invCount = getInvCount(puzzle);

        return (invCount % 2 == 0);
    }

    public static void main(String args[]) {
        int puzzle[][] = { { 2, 1, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 0 } };

        System.out.println(isSolvable(puzzle));
    }
}
