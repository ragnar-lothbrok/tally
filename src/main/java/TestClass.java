import java.util.HashMap;
import java.util.Map;

public/* IMPORTANT: class must not be public. */
class TestClass {
    // public static void main(String args[]) throws Exception {
    // int arr[] = { 10,-1,20, -2};
    // int maxSum = Integer.MIN_VALUE;
    // int currSum = 0;
    // int start = -1;
    // int end = -1;
    // int start2 = -1;
    //
    // for (int i = 0; i < arr.length; i++) {
    // currSum += arr[i];
    // if (currSum >= maxSum) {
    // maxSum = currSum;
    // start2 = (start == -1 ? 0 : start);
    // end = i;
    // }
    // if (currSum < 0) {
    // currSum = 0;
    // start = i + 1;
    // }
    // }
    //
    // for (int i = start2; i <= end; i++) {
    // System.out.print(arr[i] + " ");
    // }
    //
    // }

    public static void main(String args[]) throws Exception {

        int arr[] = { 1, 3, 46, 1, 3, 9 };
        int sum = 47;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < arr.length; i++) {
            int temp = sum - arr[i];
            if (map.get(temp) != null) {
                System.out.println("(" + arr[map.get(temp)] + "," + arr[i] + ")");
                map.remove(temp);
            } else {
                map.put(arr[i], i);
            }
        }
    }
}
