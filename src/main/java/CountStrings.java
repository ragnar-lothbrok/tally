import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//https://www.hackerearth.com/makemytrip-backend-hiring-challenge/problems/5ada2269980c41d79edfc88638f3ff7e/
public class CountStrings {

	public static void main(String[] args) throws Exception {
		countSubStrings();
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String line = bReader.readLine();
		String countNum[] = line.split(" ");
		int numCount = Integer.parseInt(countNum[0].trim());
		int testCaseCount = Integer.parseInt(countNum[1].trim());
		int arr[] = new int[numCount];
		line = bReader.readLine();
		countNum = line.split(" ");
		for (int i = 0; i < numCount; i++) {
			arr[i] = Integer.parseInt(countNum[i]);
		}

		for (int i = 0; i < testCaseCount; i++) {
			countNum = bReader.readLine().split(" ");
			switch (countNum[0].trim().charAt(0)) {
			case '1':
				int inputNumber = Integer.parseInt(countNum[1].trim());
				boolean isFound = false;
				for (int j = 0; j < numCount; j++) {
					if (inputNumber < arr[j]) {
						System.out.println(j + 1);
						isFound = true;
						break;
					}
				}
				if (!isFound) {
					System.out.println(-1);
				}
				break;
			case '0':
				int first = Integer.parseInt(countNum[1].trim());
				int second = Integer.parseInt(countNum[2].trim());
				arr[first - 1] = second;
				break;
			}
		}
	}

	private static void countSubStrings() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String inputLine = bufferedReader.readLine();
		int arr[] = new int[26];
		int charNum = Integer.parseInt(inputLine);
		String inputString = bufferedReader.readLine();
		for (int i = 0; i < inputString.length(); i++) {
			arr[inputString.charAt(i) - 'a'] = arr[inputString.charAt(i) - 'a'] + 1;
		}
		int testCount = Integer.parseInt(bufferedReader.readLine());
		for (int i = 0; i < testCount; i++) {
			inputLine = bufferedReader.readLine();
			char char1 = inputLine.trim().split(" ")[0].charAt(0);
			char char2 = inputLine.trim().split(" ")[1].charAt(0);
			long a1 = arr[char1 - 'a'] ;
			long a2 = arr[char1 - 'a'] ;
			if (char1 == char2) {
				System.out.println((a1 * (a1 - 1)) / 2);
			} else {
				System.out.println(a1 * a2);
			}
		}
	}
}
