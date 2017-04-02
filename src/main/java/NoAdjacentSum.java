public class NoAdjacentSum {

	public static void main(String[] args) {

//		NoAdjacentSUm();
		//
//		System.out.println(GetJumpCount(5, 1, new int[] { 9, 10 }));
//		System.out.println(GetJumpCount(10, 1, new int[] { 10 }));
//		System.out.println(GetJumpCount(4, 2, new int[] { 10 }));
//		System.out.println(GetJumpCount(1, 0, new int[] { 10 }));
//		System.out.println(GetJumpCount(5, 2, new int[] { 10 }));

		System.out.println(solution("02002"));
	}

	private static void NoAdjacentSUm() {
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

	public static int solution(String S) {
		java.math.BigInteger result = new java.math.BigInteger("0");
		int arr[] = new int[10];
		for (int i = 1; i <= S.length(); i++) {
			for (int j = 0; j+i <= S.length(); j++) {
				for (int k = 0; k < 10; k++) {
					arr[k] = 0;
				}
				int temp = j;
				while (temp < j + i && temp < S.length()) {
					arr[S.charAt(temp) - '0']++;
					temp++;
				}
				int oddCount = 0;

				for (int k = 0; k < 10; k++) {
					if (arr[k] % 2 != 0) {
						oddCount++;
					}
				}
				if (!(oddCount > 1)) {
					result = result.add(new java.math.BigInteger("1"));
				}
			}
		}
		return result.mod(new java.math.BigInteger("1000000007")).intValue();
	}

	public static int GetJumpCount(int input1, int input2, int[] input3) {
		int attempts = 0;
		for (int i = 0; i < input3.length; i++) {
			if (input3[i] > 0) {
				if (input1 == input2 && input3[i] <= input1) {
					attempts++;
				} else {
					if (input3[i] <= input1) {
						attempts++;
					} else {
						attempts++;
						int rest = input3[i] - input1;
						attempts += Math.ceil((rest * 1.0 / (input1 - input2)));
					}
				}
			}
		}
		return attempts;
	}

	public static int GetJumpCount1(int input1, int input2, int[] input3) {
		int attempts = 0;
		for (int i = 0; i < input3.length; i++) {
			if (input3[i] > 0) {
				if (input1 == input2 && input3[i] <= input1) {
					attempts++;
				} else {
					if (input3[i] <= input1) {
						attempts++;
					} else {
						int temp = input1;
						while (temp < input3[i]) {
							attempts++;
							temp = temp - input2;
							temp = temp + input1;
						}
						attempts++;
					}
				}
			}
		}
		return attempts;
	}

}
