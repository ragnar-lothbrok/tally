
public class TestC {

	public static final int N = 4;

	private static int getMin(int arr[]) {
		int minInd = 0;
		for (int i = 1; i < N; i++)
			if (arr[i] < arr[minInd])
				minInd = i;
		return minInd;
	}

	private static int getMax(int arr[]) {
		int maxInd = 0;
		for (int i = 1; i < N; i++)
			if (arr[i] > arr[maxInd])
				maxInd = i;
		return maxInd;
	}

	private static int minOf2(int x, int y) {
		return (x < y) ? x : y;
	}

	private static void minCashFlowRec(int amount[]) {
		int mxCredit = getMax(amount), mxDebit = getMin(amount);

		if (amount[mxCredit] == 0 && amount[mxDebit] == 0)
			return;

		int min = minOf2(-amount[mxDebit], amount[mxCredit]);
		amount[mxCredit] -= min;
		amount[mxDebit] += min;

		System.out.println("Person " + mxDebit + " pays " + min + " to Person " + mxCredit);

		minCashFlowRec(amount);
	}

	private static void minCashFlow(int graph[][]) {
		int amount[] = { 0, 0, 0, 0 };

		for (int p = 0; p < N; p++)
			for (int i = 0; i < N; i++){
				amount[p] += (graph[i][p] - graph[p][i]);
				System.out.println(amount[p]);
			}
		minCashFlowRec(amount);
	}

	public static void main(String[] args) {
		int[][] graph = { { 0, 0, 150, 150 }, { 100, 0, 100, 0 }, { 150, 150, 0, 0 }, { 0, 250, 0, 0 } };

		minCashFlow(graph);
	}
}
