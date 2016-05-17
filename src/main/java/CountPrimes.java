import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

///https://www.hackerearth.com/prysm-qa-coding-test/problems/e4773b368150476c9de4dd9c7c37bae3/
public class CountPrimes {
	
	 public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        String line = br.readLine();
	        int buffer[] = new int[1000005];
	        int result[] = new int[1000005];
	        for (int i = 2; i <= 1000000; i++) {
	            if (buffer[i] == 0) {
	                for (int j = i + i; j <= 1000000; j += i) {
	                    if (buffer[j] == 0)
	                        result[i]++;
	                    buffer[j] = 1;
	                }
	            }
	        }
	        int testCases = Integer.parseInt(line);
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < testCases; i++) {
	            sb.append(result[Integer.parseInt(br.readLine())] + 1).append("\n");
	        }
	        System.out.println(sb.toString());
	    }
}
