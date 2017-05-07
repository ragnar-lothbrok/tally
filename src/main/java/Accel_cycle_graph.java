import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Accel_cycle_graph {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int N = Integer.parseInt(line);

		for (int i = 0; i < N; i++) {
			line = br.readLine();

			String split[] = line.trim().split(" ");
			int sides = Integer.parseInt(split[1]);
			int[][] sidesArr = new int[sides][2];
			for (int j = 0; j < sides; j++) {
				line = br.readLine();
				split = line.trim().split(" ");
				int first = Integer.parseInt(split[0]);
				int second = Integer.parseInt(split[1]);
				sidesArr[j][0] = first - 1;
				sidesArr[j][1] = second - 1;
			}
			boolean result = canFinish(Integer.parseInt(split[0]), sidesArr);
			if (result) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null) {
			throw new IllegalArgumentException("illegal prerequisites array");
		}

		int len = prerequisites.length;

		if (numCourses == 0 || len == 0) {
			return true;
		}

		// track visited courses
		int[] visit = new int[numCourses];

		// use the map to store what courses depend on a course
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int[] a : prerequisites) {
			if (map.containsKey(a[1])) {
				map.get(a[1]).add(a[0]);
			} else {
				ArrayList<Integer> l = new ArrayList<Integer>();
				l.add(a[0]);
				map.put(a[1], l);
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (!canFinishDFS(map, visit, i))
				return false;
		}

		return true;
	}

	private static boolean canFinishDFS(HashMap<Integer, ArrayList<Integer>> map, int[] visit, int i) {
		if (visit[i] == -1)
			return false;
		if (visit[i] == 1)
			return true;

		visit[i] = -1;
		if (map.containsKey(i)) {
			for (int j : map.get(i)) {
				if (!canFinishDFS(map, visit, j))
					return false;
			}
		}

		visit[i] = 1;

		return true;
	}

}
