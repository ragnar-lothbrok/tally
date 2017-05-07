import java.io.BufferedReader;
import java.io.InputStreamReader;

public class PaintingProblem {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		Integer testCases = Integer.parseInt(line);
		for (int i = 0; i < testCases; i++) {
			line = br.readLine();
			line = line.replaceAll("  ", " ");
			String colorCount[] = line.trim().split(" ");
			Integer white = Integer.parseInt(colorCount[0].trim());
			Integer red = Integer.parseInt(colorCount[1].trim());
			Integer green = Integer.parseInt(colorCount[2].trim());

			int smallest = -1;
			if (white > red) {
				if (red > green) {
					smallest = green;
				} else {
					smallest = red;
				}
			} else {
				if (white > green) {
					smallest = green;
				} else {
					smallest = white;
				}
			}

			int numOfPaintings = 0;
			if (white == green && green == red) {
				numOfPaintings = white;
			} else {
				numOfPaintings = smallest;
			}

			System.out.println(numOfPaintings);
		}
	}
}
