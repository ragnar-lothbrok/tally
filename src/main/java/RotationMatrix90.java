//http://www.geeksforgeeks.org/inplace-rotate-square-matrix-by-90-degrees/
public class RotationMatrix90 {

	static int[][] mat_3 = { { 1, 2, 3 }, 
							 { 4, 5, 6 }, 
							 { 7, 8, 9 } };

	static int[][] mat_4 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

	public static void main(String[] args) {
		int x = mat_3.length;
		
		for(int i=0;i<mat_3.length;i++){
			for(int j=0;j<mat_3[0].length;j++){
				System.out.print(mat_3[i][j]+" ");
			}
			System.out.println();
		}
		
		System.out.println("\n\n");
		for (int i = 0; i < x / 2; i++) {
			for (int j = i; j < x - i - 1; j++) {
				int temp = mat_3[i][j];
				mat_3[i][j] = mat_3[j][x-i-1];
				mat_3[j][x-i-1] = mat_3[x-i-1][x-j-1];
				mat_3[x-i-1][x-j-1] = mat_3[x-j-1][i];
				mat_3[x-j-1][i] = temp;
			}
		}
		
		for(int i=0;i<mat_3.length;i++){
			for(int j=0;j<mat_3[0].length;j++){
				System.out.print(mat_3[i][j]+" ");
			}
			System.out.println();
		}
	}

}
