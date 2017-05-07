import java.util.Iterator;
import java.util.TreeMap;

public class TreeMapDemo {
	public static void main(String args[]) {
		// Create a hash map
		TreeMap<String, int[]> tm = new TreeMap<String, int[]>();
		int indexDesired;
		String planetNameVariable = "test";
		String crewMemberName;

		// Scan input using Scanner and assign planet name and crew name to
		// correct variables (code provided by instructor)

		// Put elements to the map
		// if(planet doesn't already exist in tm)
		tm.put(planetNameVariable, new int[14]);

		// Decides which element of the array must be incremented
		indexDesired = 1;

		int visits[] = null;
		// Increments visit count of crewMemberName on planetNameVariable
		visits = tm.get(planetNameVariable);
		if (visits == null) {
			tm.put(planetNameVariable, new int[14]);
			visits = tm.get(planetNameVariable);
		}
		visits[indexDesired]++;

		// Get an iterator
		Iterator<String> iterator = tm.keySet().iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			int[] temp = tm.get(key);
			if (temp != null) {
				for (int i = 0; i < temp.length; i++) {
					System.out.println(key + " " + temp[i]);
				}
			}
		}

		// Display element
		// Code not designed yet
	}
}
