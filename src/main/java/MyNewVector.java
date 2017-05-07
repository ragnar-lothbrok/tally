import java.util.Vector;

/*private*/ class MyVector extends Vector {
	int i = 1; /* Line 5 */

	public MyVector() {
		i = 2;
	}
}

public class MyNewVector extends MyVector {
	public MyNewVector() {
		i = 4; /* Line 15 */
	}

	public static void main(String args[]) {
		MyVector v = new MyNewVector(); /* Line 19 */
	}
}
