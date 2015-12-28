import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/problem/algorithm/panda-and-maximum-product/?utm_campaign=user-activity-email&utm_medium=email&utm_source=user-recommend-problem&utm_campaign=mailers&utm_source=email&utm_medium=sendgrid
public class PandaMaximumProduct {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boys = Integer.parseInt(br.readLine());
		String[] line = br.readLine().split(" ");
		long firstMax = Long.MIN_VALUE;
		long secondMax = Long.MIN_VALUE;
		long firstMin = Long.MAX_VALUE;
		long secondMin = Long.MAX_VALUE;
		boolean zeroPresent = false;
		long[] arr = new long[boys];
		for (int i = 0; i < line.length; i++) {
			arr[i] = Long.parseLong(line[i]);
			if (arr[i] > 0) {
				if (arr[i] > firstMax) {
					secondMax = firstMax;
					firstMax = arr[i];
				} else if (arr[i] > secondMax) {
					secondMax = arr[i];
				}
			} else if (arr[i] < 0) {
				if (arr[i] < firstMin) {
					secondMin = firstMin;
					firstMin = arr[i];
				} else if (arr[i] < secondMin) {
					secondMin = arr[i];
				}
			} else {
				zeroPresent = true;
			}
		}
		long product = Long.MIN_VALUE;
		if (secondMax != Long.MIN_VALUE) {
			product = firstMax * secondMax;
		}

		if (secondMin != Long.MAX_VALUE) {
			if (product < (secondMin * firstMin)) {
				product = secondMin * firstMin;
			}
		}

		if (product == Long.MIN_VALUE) {
			if(zeroPresent){
				product = 0;
			}
		}
		System.out.println(product);
	}

}
