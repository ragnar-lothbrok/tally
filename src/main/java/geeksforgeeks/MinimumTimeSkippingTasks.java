package geeksforgeeks;

//http://www.geeksforgeeks.org/minimum-time-to-finish-tasks-without-skipping-two-consecutive/
public class MinimumTimeSkippingTasks {

	public static void main(String[] args) {
		int arr[] = {10, 5, 2, 4, 8, 6, 7, 10}/*{ 10, 5, 7, 10 }*/;

		int excl = 0, incl = arr[0];
		for (int i = 1; i < arr.length; i++) {
			int incl_new = arr[i] + Math.min(excl, incl);
			excl = incl;
			incl = incl_new;
		}
		
		System.out.println(Math.min(incl, excl));
	}
}
