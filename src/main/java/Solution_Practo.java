import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://www.hackerearth.com/code-monk-string-algorithms/problems/
public class Solution_Practo {

	public static void main(String[] args) throws IOException {

		final Map<String, String> map = new HashMap<String, String>();
		for (int i = 0; i < 120; i++) {
			map.put(i + "", i + "");
		}
		System.out.println(map);
		// BufferedReader br = new BufferedReader(new
		// InputStreamReader(System.in));
		// String line = br.readLine();
		// numOfSubStrigs(line);
		// modifiedString(line);
	}

	private static void modifiedString(String str) {
		StringBuffer sb = new StringBuffer();
		String tokens[] = str.split(" ");
		for (int i = 0; i < tokens.length; i++) {
			try {
				if (i > 0) {
					sb.append(" ");
				}
				sb.append(Character.toUpperCase(tokens[i].charAt(0)));
				if (tokens[i].length() > 1) {
					sb.append(tokens[i].substring(1));
				}
			} catch (Exception ex) {
				System.out.println(" " + tokens[i]);
			}
		}
		System.out.println(sb.toString());
	}

<<<<<<< HEAD
    private static void numOfSubStrigs(String inputStr) {
        Set<String> hashSet = new HashSet<String>();
        for (int i = 0; i < inputStr.length(); i++) {
          for (int j = i; j < inputStr.length(); j++) {
            hashSet.add(inputStr.substring(i, j+1));
          }
        }
        System.out.println(hashSet.size());
    }
=======
	@SuppressWarnings("unused")
	private static void numOfSubStrigs(String inputStr) {
		Set<String> hashSet = new HashSet<String>();
		for (int i = 0; i < inputStr.length(); i++) {
			for (int j = i; j < inputStr.length(); j++) {
				hashSet.add(inputStr.substring(i, j + 1));
			}
		}
		System.out.println(hashSet.size());
	}
>>>>>>> 8ab8b8d6fce89645b824101d1544b86c1b40ba3c

}
