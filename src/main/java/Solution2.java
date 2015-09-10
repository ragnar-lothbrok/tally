import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int testCase = Integer.parseInt(line);
        int arr[] = new int[5000];
        for (int j = 0; j < arr.length; j++) {
            arr[j] = j + 1;
        }

        for (int i = 0; i < testCase; i++) {
            line = br.readLine();
            int num = Integer.parseInt(line);

            // findCount(arr, 5000, num);
            summain(arr);
        }
    }

    static void summain(int a[]) {
        int findSum = 4;
        int aCount = a.length; // total array elements
        int sum = 0;
        int j = 0;
        int index = 0;

        for (int i = 1; i < ((Math.pow(2.0, aCount) - 1)); i++) 
        {
            sum = 0;
            j = i;
            index = aCount - 1;
            while (j != 0) {
                if ((j & 0x1) == 1) /* check for set bit */
                {
                    sum = sum + a[index]; /* Keep on calculating sum */
                }
                j = j >> 1; /* right shift */
                index--;
                if (sum > findSum) /* sum exceeds, break from loop */
                    break;
            }

            if (sum == findSum) /* we found the sum */
            {
                j = i;
                index = aCount - 1;
                System.out.println("Array Indexes are ");
                while (j != 0) {
                    if ((j & 0x1) == 1) /*
                                         * check the set bit, find the array
                                         * indexes
                                         */
                    {
                        System.out.printf("%d ", index);
                    }
                    j = j >> 1;
                    index--;
                }
                System.out.println();
            }
        }
    }

    static void findCount(int A[], int n, int X) {
        int count = 0;
        int l, r;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                l = 0;
                r = n - 1;
                while (l < r) {
                    if (A[i] + A[j] + A[l] + A[r] == X) {
                        System.out.println(A[i] + " " + A[j] + " " + A[l] + " " + A[r]);
                        count++;
                        l++;
                        r--;
                    } else if (A[i] + A[j] + A[l] + A[r] < X)
                        l++;
                    else
                        r--;
                }
            }
        }
        System.out.println(count);
    }
}
