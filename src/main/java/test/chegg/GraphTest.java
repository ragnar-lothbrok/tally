package test.chegg;

public class GraphTest {

	public static void main(String[] args) {

		int adjacet[][] = new int[8][8];
		adjacet[1][2] = 1;
		adjacet[1][6] = 1;
		adjacet[2][5] = 1;
		adjacet[2][7] = 1;
		adjacet[2][3] = 1;
		adjacet[3][5] = 1;
		adjacet[3][4] = 1;
		adjacet[4][3] = 1;
		adjacet[5][1] = 1;
		adjacet[6][2] = 1;
		adjacet[7][3] = 1;

		int edgeCount = 0;

		for (int i = 1; i < adjacet.length; i++) {
			for (int j = 1; j < adjacet.length; j++) {
				if (adjacet[i][j] != 0) {
					edgeCount++;
				}
				System.out.print(adjacet[i][j]+" ");
			}
			System.out.println(); 
		}

		System.out.println("Edges Count : " + edgeCount);

	}
}
