import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.google.common.hash.Hashing;

// class MyThread extends Thread {
// public String text;
//
// public void run() {
// System.out.print(text);
// }
// }
//
// public class Test {
// public static void main(String args[]) {
// MyThread t1 = new MyThread();
// MyThread t2 = new MyThread();
// t1.start();
// t2.start();
// System.out.print("three ");
//
// }
//
// }
class A {
	public int GetResult(int a, int b) {
		return 0;
	}
}

class B extends A {
	public int GetResult(int a, int b) {
		return 1;
	}
}

public class Test {

	private Integer age;

	private int number;

	private String role = "";

	static int countUneatenLeaves(int n, int[] a) {
		Arrays.sort(a);
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < i; j++) {
				if (a[j] != 0 && a[i] % a[j] == 0) {
					a[i] = 0;
					break;
				}
			}
		}
		int lcm = 1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				lcm = findLCM(lcm, a[i]);
			}
		}
		int res = n % lcm;
		int[] mark = new int[Math.min(lcm, n) + 1];
		for (int i = 0; i < a.length; i++) {
			if (a[i] != 0) {
				for (int j = a[i]; j <= Math.min(lcm, n); j += a[i]) {
					mark[j] = 1;
				}
			}
		}
		int count = 0;
		int count1 = 0;
		for (int i = 1; i < Math.min(lcm, n); i++) {
			if (mark[i] == 0) {
				count++;
				if (i <= res)
					count1++;
			}
		}
		if (n < lcm)
			return count;
		else {
			return n / lcm * count + count1;
		}
	}

	private static int findGCD(int num1, int num2) {
		if (num2 == 0) {
			return num1;
		}
		return findGCD(num2, num1 % num2);
	}

	private static int findLCM(int num1, int num2) {
		return num1 * (num2 / findGCD(num1, num2));
	}

	private void lol() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Test obj = new Test();
		for (Method m : obj.getClass().getDeclaredMethods()) {
			if (m.getName().startsWith("get") && m.getParameterTypes().length == 1) {
				System.out.println("===" + m.getName());
				if (m.getReturnType().equals(String.class)) {
					String value = "ABCD";
					Method method = Test.class.getDeclaredMethod(m.getName(), String.class);
					method.invoke(obj, value);
				}
			}
		}
	}

	private void testNull() {
		Test ob = new Test();
		List<String> fieldsAsNull = new LinkedList<>();
		for (Field f : ob.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (Objects.isNull(f.get(ob)) || (f.getType().getName().equals("int") && ((Integer) f.get(ob)).intValue() == 0)) {
					fieldsAsNull.add(f.getName());
				}
			} catch (Exception e) {
				e.getMessage();
				e.printStackTrace();
			}
		}
		System.out.println(fieldsAsNull);
	}

	private String getString(String lol) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$4" + lol);
		return null;
	}

	private Long getLong() {
		return null;
	}

	private static void l1(Object o) {
		System.out.println("0");
	}

	private static void l1(NullPointerException o) {
		System.out.println("2");
	}

	private static void l1(Exception o) {
		System.out.println("1");
	}

	public Test() {
		Test t = new Test();
	}

	private static Integer saveYears() {
		Integer birthYear = 0;
		do {
			try {
				birthYear = Integer.parseInt(JOptionPane.showInputDialog("enter year you were born"));
			} catch (NumberFormatException e) {
				birthYear = -1;
			}
			if (birthYear < 1900 || birthYear > 2016) {
				JOptionPane.showMessageDialog(null, "Invalid number birth year.");
			}
		} while (birthYear < 1900 || birthYear > 2016);

		return birthYear;
	}

	static int factorialRemainder(int n) {
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (isPrime(i)) {
				result++;
			}
		}
		return result;
	}

	static boolean isPrime(int n) {
		if (n != 2 && n % 2 == 0)
			return false;
		for (int i = 3; i * i <= n; i += 2) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, Exception {

		{

			System.out.println(countUneatenLeaves(20, new int[] { 3, 7, 5 }));
			System.out.println(countUneatenLeaves(10, new int[] { 2, 4, 5 }));
			System.exit(1);
			String abc = "asdasd$4adsasd";
			String split[] = abc.split("\\$4");
			System.out.println(split);
			System.out.println((int) '0');
			Scanner Keyboard = new Scanner(System.in);
			System.out.println("Enter a two-digit number:");
			String entered_digits = Keyboard.nextLine();
			int FirstDigit = entered_digits.charAt(0) - 48;
			System.out.println("The first digit that was entered was:" + " " + FirstDigit);
			int SecondDigit = entered_digits.charAt(1) - 48;
			System.out.println("The second digit that was entered was:" + " " + SecondDigit);
			int EnteredNumberPlusTen = ((++FirstDigit * 10) + SecondDigit);
			System.out.println("This new number:" + " " + EnteredNumberPlusTen + " " + "Is the original number plus ten");

			Integer number = Keyboard.nextInt();
			int first = number / 10;
			int second = number % 10;
			EnteredNumberPlusTen = ((++first * 10) + second);
			System.out.println("This new number:" + " " + EnteredNumberPlusTen + " " + "Is the original number plus ten");
		}

		saveYears();

		{
			String word = "k";
			String empty = "";
			StringBuffer sb1 = new StringBuffer(word);
			StringBuffer sb2 = new StringBuffer(empty);
			Random randomChar = new Random();

			while (word.length() != 0 && sb1.length() != 0) {
				int charIndex = randomChar.nextInt(word.length());
				if (sb1.length() > charIndex) {
					char character = sb1.charAt(charIndex);
					sb2.append(character);
					sb1.deleteCharAt(charIndex);
				}
			}

			System.out.println(word.length());
			System.out.println(word);
			System.out.println(sb2);
		}

		l1(null);
		int sum = 0;
		for (int i = 0, j = 0; i < 5 & j < 5; ++i, j = i + 1)
			sum += i;
		System.out.println(sum);

		boolean b1 = true;
		boolean b2 = false;
		boolean b3 = true;
		if (b1 & b2 | b2 & b3 | b2 | b1)
			System.out.println("ok");

		new Test().testNull();

		System.exit(0);
		System.out.println(Long.TYPE == Long.class);
		String str = "abc";
		System.out.println(str.split("~")[0]);

		Map<String, String> mapOk = new HashMap<String, String>();
		mapOk.put("ok", "ok1");
		mapOk.put("ok", "ok2");
		System.out.println(mapOk);

		System.out.println(Math.abs(Hashing.murmur3_32().hashString("ahhhkhk3444444444444444444444444", StandardCharsets.UTF_8).hashCode()));

		int x = 3 | 5 & 3 | 5 & 1;
		System.out.println(x);

		Calendar cal = Calendar.getInstance();
		Date date = new Date(cal.getTimeInMillis());
		SimpleDateFormat SQL_TIMESTAMP_FORMAT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(SQL_TIMESTAMP_FORMAT.format(date));

		for (int i = 0; i < 9; i++) {
			System.out.println("$$$$" + new Random().nextInt(6));
		}

		List<String> test = new ArrayList<String>();
		test.add("asddsdf");
		test.add("dsdfsdf");
		// System.out.println(new ObjectMapper().writeValueAsString(test));

		Map<String, String> map = new HashMap<String, String>();
		map.put("asdasdff", "sdfsdf");
		map.put("sdfsdf", "324234");
		// System.out.println(new ObjectMapper().writeValueAsString(map));
		B b = new B();
		System.out.println("x = " + b.GetResult(0, 1));
		new Test().start();

		System.out.println(daysCount("15-10-2015", "15-10-2015"));
		System.out.println(daysCount("10-06-2012", "15-10-2015"));

	}

	public static int daysCount(String input1, String input2) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date1 = sdf.parse(input1);
			Date date2 = sdf.parse(input2);
			if (date1.getTime() == date2.getTime()) {
				return 0;
			}
			return (int) (1l + TimeUnit.DAYS.convert(Math.abs(date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS));
		} catch (ParseException e) {
		}
		return 0;
	}

	// void start()
	// {
	// long [] a1 = {3,4,5};
	// long [] a2 = fix(a1);
	// System.out.print(a1[0] + a1[1] + a1[2] + " ");
	// System.out.println(a2[0] + a2[1] + a2[2]);
	// }
	//
	// long [] fix(long [] a3)
	// {
	// a3[1] = 7;
	// return a3;
	// }

	void start() {
		String s1 = "slip";
		String s2 = fix(s1);
		System.out.println(s1 + " " + s2);
	}

	String fix(String s1) {
		s1 = s1 + "stream";
		System.out.print(s1 + " ");
		return "stream";
	}
}