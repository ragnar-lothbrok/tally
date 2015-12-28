import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://www.hackerearth.com/problem/algorithm/divide-apples/?utm_campaign=user-activity-email&utm_medium=email&utm_source=user-recommend-problem&utm_campaign=mailers&utm_source=email&utm_medium=sendgrid
public class DivideApples {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int boys = Integer.parseInt(br.readLine());
		long[] apples = new long[boys];
		String[] line = br.readLine().split(" ");
		long sum = 0;
		for (int i = 0; i < boys; i++) {
			apples[i] = Long.parseLong(line[i]);
			sum += apples[i];
		}

		long average = sum / boys;
		long[] applesPassed = new long[boys];
		applesPassed[0] = 0;
		for (int i = 0; i < boys - 1; i++) {
			applesPassed[i + 1] = applesPassed[i] + apples[i] - average;
		}
		Arrays.sort(applesPassed);

		long median = applesPassed[boys / 2];
		long output = 0;
		for (int i = 0; i < boys; i++) {
			output += Math.abs(applesPassed[i] - median);
		}

		System.out.println(output);

	}
}
