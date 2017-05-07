import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class TestClass1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int vertex = Integer.parseInt(line);
		int mat[][] = new int[vertex + 1][vertex + 1];
		Integer edges = Integer.parseInt(br.readLine());
		for (int i = 0; i < edges; i++) {
			line = br.readLine();
			String split[] = line.split(" ");
			int x = Integer.parseInt(split[0]);
			int y = Integer.parseInt(split[1]);
			mat[x+1][y+1] = 1;
			mat[y+1][x+1] = 1;
		}
		isConnected(mat, Integer.parseInt(br.readLine()));
	}

	private static void isConnected(int mat[][], Integer vertex) {
		boolean visited[] = new boolean[mat.length];
		for (int i = 0; i < mat.length; i++) {
			mat[vertex + 1][i] = 0;
			mat[i][vertex + 1] = 0;
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		visited[1] = true;
		while (!stack.isEmpty()) {
			Integer popped = stack.pop();
			for (int i = 1; i < mat.length; i++) {
				if (mat[popped][i] == 1 && !visited[i]) {
					stack.push(i);
					visited[i] = true;
				}
			}
		}

		Boolean connected = true;
		for (int i = 1; i < visited.length; i++) {
			if (!visited[i] && i != vertex+1) {
				connected = false;
				break;
			}
		}
		if (connected) {
			System.out.println("Connected");
		} else {
			System.out.println("Not Connected");
		}
	}
}
