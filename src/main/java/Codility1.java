
public class Codility1 {

	public static void main(String[] args) {
		int arr[] = new int[] { 1, 2, 4, 5, 7, 29, 30 };

		arr = new int[] { 1, 2, 4, 7, 27, 28, 29, 30 };

		arr = new int[] { 1, 2, 4, 7, 23, 27, 28, 30 };

		arr = new int[] { 1, 2, 3, 4, 7, 23, 27, 28, 30 };

		arr = new int[] { 1, 2, 3, 4, 7, 23, 27, 28, 30 };

		arr = new int[] { 1, 3, 5, 7, 9, 11, 13, 17, 19, 21, 23, 25, 29 };

		System.out.println(new Codility1().solution(arr));
	}

	public int solution(int[] A) {
		java.util.List<Integer> set = new java.util.ArrayList<Integer>();
		for (Integer value : A) {
			set.add(value);
		}

		if (A.length >= 23) {
			return 25;
		}

		int cost[] = new int[A.length];
		cost[0] = 2;

		for (int i = 1; i < A.length; i++) {
			cost[i] = cost[i - 1] + 2;
			if (cost[i] > 7) {
				int diff = A[i] - 7 + 1;
				diff = diff < 0 ? A[0] : diff;
				while (diff <= A[i]) {
					if (set.indexOf(diff) != -1) {
						break;
					}
					diff++;
				}
				if (diff != A[i]) {
					int index = set.indexOf(diff);
					if (index > 0 && (cost[i] - cost[index] + 2) > 7) {
						cost[i] = cost[index - 1] + 7;
					} else if (index == 0) {
						cost[i] = 7;
					}
				}
			}
		}
		return cost[A.length - 1];
	}
}
