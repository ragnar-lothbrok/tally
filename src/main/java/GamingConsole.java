import java.util.LinkedHashMap;
import java.util.Map;

//http://www.writeulearn.com/techgig-gaming-console/
public class GamingConsole {

	public static void main(String[] args) {
		System.out.println(combinationCounts(2));
	}

	private static Map<String, char[]> possibleMap = new LinkedHashMap<String, char[]>();
	static {
		possibleMap.put("A", new char[] { 'A', 'B', 'D' });
		possibleMap.put("B", new char[] { 'A', 'B', 'C', 'E' });
		possibleMap.put("C", new char[] { 'F', 'B', 'C' });
		possibleMap.put("D", new char[] { 'A', 'G', 'D', 'E' });
		possibleMap.put("E", new char[] { 'F', 'B', 'D', 'E', 'H' });
		possibleMap.put("F", new char[] { 'I', 'F', 'C', 'E' });
		possibleMap.put("G", new char[] { 'D', 'G', 'H' });
		possibleMap.put("H", new char[] { 'G', 'H', 'I', 'E', 'J' });
		possibleMap.put("I", new char[] { 'H', 'I', 'F' });
		possibleMap.put("J", new char[] { 'H', 'J' });
	}

	public static int combinationCounts(int input1) {
		int[][] aux = new int[input1][10];
		for (int i = 0; i < 10; i++) {
			aux[0][i] = 1;
		}
		for (int i = 1; i < input1; i++) {
			int j = 0;
			for (String key : possibleMap.keySet()) {
				int count = 0;
				char[] values = possibleMap.get(key);
				System.out.println("i = "+i+" ");
				for (int k = 0; k < values.length; k++) {
					count += aux[i - 1][values[k] - 'A'];
					System.out.print(aux[i - 1][values[k] - 'A']+" ");
				}
				System.out.println();
				aux[i][j] = count;
				j++;
			}
		}
		int sum = 0;
		for (int i = 0; i < 10; i++)
			sum += aux[input1 - 1][i];
		return sum;
	}
}
