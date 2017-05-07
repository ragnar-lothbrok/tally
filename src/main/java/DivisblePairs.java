import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
//https://www.hackerearth.com/jigsaw-academy-hiring-challenge/problems/e23ca9676bbe4f788c717279105d709d/
public class DivisblePairs {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		String split[] = line.trim().split(" ");
		int num = Integer.parseInt(split[0]);
		int denom = Integer.parseInt(split[1]);
		BigInteger arr[] = new BigInteger[num];
		line = br.readLine();
		split = line.trim().split(" ");
		for (int i = 0; i < split.length; i++) {
			arr[i] = new BigInteger(split[i]);
		}

		int count = 0;
		for (int i = 0; i < num; i++) {
			if(arr[i].longValue() % denom == 0){
				count = count + num -i-1;
				continue;
			}
			for (int j = i + 1; j < num; j++) {
				if (i != j) {
					if (arr[i].multiply(arr[j]).longValue() % denom == 0) {
						count++;
					}
				}
			}
		}
		System.out.println(count);
	}
}
