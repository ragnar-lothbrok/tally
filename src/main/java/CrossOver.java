import java.util.Arrays;

class BC{
	static {
		System.out.println("A");
	}
	{
		System.out.println("A1");
	}
	
	public BC() {
		System.out.println("CONS A");
	}
}

public class CrossOver extends BC {

	static {
		System.out.println("B");
	}
	{
		System.out.println("B1");
	}
	
	public CrossOver() {
		System.out.println("cross");
	}
	
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString("\u0041".getBytes()));

		int[] i = { 1 };

		new CrossOver().increment(i);

		System.out.println(i[i.length - 1]);
		
//		System.out.println(first(5, 3));
	}

	void increment(int[] i) {
		i[i.length - 1]++;
	}

	private static int first(int a, int b) {
		if (b == 0)
			return a;
		else
			return second(a, a - b);
	}

	private static int second(int a, int b) {
		if (a == 0)
			return b;
		else
			return first(b,a);
	}
}
