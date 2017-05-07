import java.io.IOException;
import java.util.Arrays;
//https://www.codechef.com/problems/TAUT
public class Main {
	static char[] exp;
	static int pos;
	static int[] lookup = new int[26];
	static int state;
	static int varcount;

	static boolean yes(char type) {
		return (state & (1 << lookup[type - 'a'])) != 0;
	}

	public static String iteration(String input1) {
		try {
			exp = input1.toCharArray();
			lookup = new int[26];
			Arrays.fill(lookup, -1);
			pos = 0;
			varcount = 0;
			Exp full = parse();
			for (state = (1 << varcount) - 1; state >= 0; state--) {
				if (!full.yes()) {
					return "NO";
				}
			}
			return "YES";
		} catch (Exception exception) {
		}
		return "Invalid";
	}

	public static void main(String[] args) throws IOException {
		System.out.println(iteration("NPCF"));
	}

	static Exp parse() {
		Exp ret = new Exp();
		ret.type = exp[pos++];
		switch (ret.type) {
		case 'A':
		case 'O':
		case 'I':
		case 'F':
			ret.left = parse();
			ret.right = parse();
			break;
		case 'N':
			ret.left = parse();
			break;
		default:
			if (lookup[ret.type - 'a'] == -1) {
				lookup[ret.type - 'a'] = varcount++;
			}
		}
		return ret;
	}

	static class Exp {
		char type;
		Exp left, right;

		boolean yes() {
			switch (type) {
			case 'A':
				return left.yes() && right.yes();
			case 'O':
				return left.yes() || right.yes();
			case 'I':
				return !left.yes() || right.yes();
			case 'F':
				return left.yes() == right.yes();
			case 'N':
				return !left.yes();
			default:
				return Main.yes(type);
			}
		}
	}
}
