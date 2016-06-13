import java.io.BufferedReader;
import java.io.InputStreamReader;

//https://www.hackerearth.com/jigsaw-academy-hiring-challenge/problems/9c26c6bdc1264751894a60f5626631dc/
public class MilkyChoclates {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String split[] = null;
		int testCases = Integer.parseInt(line);
		for (int i = 0; i < testCases; i++) {
			int index = 0;
			int minTime = Integer.MAX_VALUE;
			int time = 0;
			line = br.readLine();
			split = line.split(" ");
			int numOfChoc = Integer.parseInt(split[0]);
			int breakT = Integer.parseInt(split[1]);
			int waitT = Integer.parseInt(split[2]);

			line = br.readLine();
			split = line.split(" ");
			int arr[] = new int[split.length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(split[j]);
			}

			for (int j = 0; j < arr.length; j++) {
				time = 0;
				split = br.readLine().split(" ");
				for (int k = 0; k < split.length; k++) {
					time += Integer.parseInt(split[k]);
					time += +breakT;
				}
				if (split.length > 1) {
					time += ((split.length - 1) * waitT);
				}
				if (minTime > time) {
					minTime = time;
					index = i + 1;
				}
			}
			System.out.println(index + " " + minTime);
		}
	}
}
