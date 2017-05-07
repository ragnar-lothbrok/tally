import java.util.Scanner;

public class Codechef {

	public static void bubble(String[] name, int[] a, int n) {
		// int n=a.length;
		String temp_l;
		String temps;
		int[] name_l = new int[100000];

		int temp;
		for (int i = 0; i < n - 1; i++) {
			// n-i-1 for ignoring the element which has already used in
			// comparison
			for (int j = 0; j < n - i - 1; j++) {
				if (a[j] > a[j + 1]) {
					temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;

					// Sort them according to their name
					temps = name[j];
					name[j] = name[j + 1];
					name[j + 1] = temps;
				}else if(a[j] == a[j + 1]){
					int result = name[j].compareTo(name[j + 1]);
					if(result < 0){
						temps = name[j];
						name[j] = name[j + 1];
						name[j + 1] = temps;
					}
				}
			}
			temp_l = name[i];
			name_l[i] = temp_l.length();
		}
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int t = scan.nextInt();
		String[] name = new String[100000];
		int[] length = new int[1000000];
		int[] love = new int[10000000];

		for (int i = 0; i < n; i++) {
			name[i] = scan.next();
			love[i] = scan.nextInt();
		}
		bubble(name, love, n);

		int[] name_l = new int[n];
		String temp;

		for (int i = 0; i < n; i++) {

			temp = name[i];
			name_l[i] = temp.length();

		}

		// printing total t selection
		int test = n - 1;
		for (int i = t; i > 0; i--) {

			System.out.println(name[test]);
			test--;
		}

	}
}
