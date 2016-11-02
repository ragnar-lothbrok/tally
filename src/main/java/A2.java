import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class A2 {
	public static PrintWriter out;
	public static MS sc = new MS();

	public static void main(String[] arg) throws Exception {
		out = new PrintWriter(new BufferedOutputStream(System.out));

		int R, C, K, X;
		int A[][], dp[][];
		int i, j, k;

		R = sc.nextInt();
		C = sc.nextInt();
		K = sc.nextInt();
		X = sc.nextInt();

		A = new int[R][C];
		dp = new int[R][C];
		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				A[i][j] = sc.nextInt();
				if (j == 0)
					dp[i][j] = 0;
				else
					dp[i][j] = dp[i][j - 1];
				if (A[i][j] == X)
					dp[i][j]++;
			}
		}

		for (i = 0; i < R; i++) {
			for (j = 0; j < C; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}

		int ans = 0;

		for (i = 0; i < R - 1; i++) {
			for (j = 0; j < C - 1; j++) {
				int ii = i + 1, jj = j + 1;
				while (true) {
					if (jj >= C) {
						ii++;
						jj = j + 1;
					}
					if (ii >= R)
						break;

					if (A[i][j] == A[i][jj] || A[i][j] == A[ii][j] || A[i][j] == A[ii][jj] || A[i][jj] == A[ii][j] || A[i][jj] == A[ii][jj]
							|| A[ii][j] == A[ii][jj]) {
						int ct = 0;
						for (int iii = i; iii <= ii; iii++) {
							ct += dp[iii][jj];
							if (j > 0)
								ct -= dp[iii][j - 1];
							if (ct >= K)
								break;
						}
						if (ct >= K)
							ans++;
					}
					jj++;
				}
			}
		}
		out.print(ans);

		out.close();
	}

	public static class MS {
		BufferedReader br;
		StringTokenizer st;

		public MS() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}

		long nextLong() {
			return Long.parseLong(next());
		}

		double nextDouble() {
			return Double.parseDouble(next());
		}

		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}