public class NoAdjacentSum {

    public static void main(String[] args) {

        int arr[] = { 1, 5, 1, 1, 7 };

        int incl = arr[0];
        int excl = 0;

        for (int i = 1; i < arr.length; i++) {
            int temp = incl;
            incl = Math.max(excl + arr[i], incl);
            excl = temp;
        }

        System.out.println((excl > incl ? excl : incl));

    }

}
