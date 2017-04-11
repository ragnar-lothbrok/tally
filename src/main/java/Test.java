import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.hash.Hashing;
import com.google.gson.Gson;

import net.minidev.json.JSONObject;

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

public class Test implements Cloneable {

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

	private void lol() throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
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
		List<String> fieldsAsNull = new LinkedList<String>();
		for (Field f : ob.getClass().getDeclaredFields()) {
			f.setAccessible(true);
			try {
				if (Objects.isNull(f.get(ob))
						|| (f.getType().getName().equals("int") && ((Integer) f.get(ob)).intValue() == 0)) {
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
		// Test t = new Test();
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

	public static int landingPosition(int[] input1, String[] input2) {
		if (input2 == null || input1 == null || (input2.length != input1[1])) {
			return -1;
		}

		int arr[][] = new int[input1[1]][input1[0]];
		for (int i = 0; i < input2.length; i++) {
			String split[] = input2[i].split("#");
			for (int j = 0; j < input1[0]; j++) {
				if (split[j].equals("x")) {
					arr[i][j] = 0;
				} else {
					arr[i][j] = 1;
				}
			}
		}
		return maxSize(arr);
	}

	private static int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}

	public static int maxSize(int arr[][]) {

		int result[][] = new int[arr.length][arr[0].length];
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			result[i][0] = arr[i][0];
			if (result[i][0] == 1) {
				max = 1;
			}
		}

		for (int i = 0; i < arr[0].length; i++) {
			result[0][i] = arr[0][i];
			if (result[0][i] == 1) {
				max = 1;
			}

		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (arr[i][j] == 0) {
					continue;
				}
				int t = min(result[i - 1][j], result[i - 1][j - 1], result[i][j - 1]);
				result[i][j] = t + 1;
				if (result[i][j] > max) {
					max = result[i][j];
				}
			}
		}
		return max;
	}

	private static String append(StringBuilder sb, Node node) {
		sb.append(node.getDisplayName());
		if (node.getBucketId() != null) {
			sb.append("|" + node.getBucketId());
		}
		return sb.toString();
	}

	private static String append(StringBuilder sb, int commaCount) {
		while (commaCount > 0) {
			sb.append(",");
			commaCount--;
		}
		return sb.toString();
	}

	private static void writeListInFile(String possibleCombinations) {
		try {
			PrintWriter writer = new PrintWriter("/home/raghunandangupta/Downloads/bucket_details.csv", "UTF-8");
			writer.println(possibleCombinations);
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
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

	public static int nochange_bits(String input1, int input2, int input3) {
		if (input2 <= 0 || input3 <= 0) {
			return -1;
		}
		int result = input1.length();

		if (input2 == input3) {
			return result;
		} else {
			int lcm = findLCM(input2, input3);
			int rem1 = result / lcm;
			int rem2 = result / input2;
			int rem3 = result / input3;

			result = result + (2 * rem1) - rem2 - rem3;
		}

		return result;
	}

	public static String minimumCost(String[] input1, int input2) {
		if (input1 != null && input1.length > 0) {
			int rowCount = input1.length;
			int colCount = input1[0].split("#").length;
			int mat[][] = new int[rowCount][colCount];
			for (int i = 0; i < input1.length; i++) {
				String split[] = input1[i].split("#");
				for (int j = 0; j < colCount; j++) {
					mat[i][j] = Integer.parseInt(split[j]);
				}
			}
			findMinimumPath("", mat[0][0], 0, 0, rowCount - 1, colCount - 1, mat);
		}
		return result.toString();
	}

	private static Result result = new Result();

	static int X[] = { 1, 1, 0 };
	static int Y[] = { 1, 0, 1 };
	static String direc[] = { "D", "B", "R" };

	public static void findMinimumPath(String path, int cost, int srcX, int srcY, int destX, int destY, int mat[][]) {
		if (srcX == destX && srcY == destY) {
			if (path.equals("BDDR"))
				System.out.println();
			if (result.getPath() == null) {
				result = new Result();
				result.setPath(path);
				result.setCost(cost);
			} else {
				if (result.getCost() > cost) {
					result.setPath(path);
					result.setCost(cost);
				}
			}
			return;
		}

		for (int i = 0; i < X.length; i++) {
			if ((srcY + Y[i]) < mat.length && (srcX + X[i]) < mat[0].length) {
				if (path.equals("B") || path.equals("BD") || path.equals("BDD") || path.equals("BDDR")) {
					System.out.println();
				}
				findMinimumPath(path + direc[i], cost + mat[srcX + X[i]][srcY + Y[i]], srcX + X[i], srcY + Y[i], destX,
						destY, mat);
				System.out.println();
			}
		}
	}

	static class Result {
		private String path;
		private Integer cost = 0;

		public String getPath() {
			return path;
		}

		public void setPath(String path) {
			this.path = path;
		}

		public Integer getCost() {
			return cost;
		}

		public void setCost(Integer cost) {
			this.cost = cost;
		}

		@Override
		public String toString() {
			return cost + "," + path;
		}

	}

	public static int traveltime(int[] input1, int input2) {
		int shortestDistance = 0;
		int maximumWeight = 0;
		for (int i = 0; i < input2; i++) {
			for (int j = i + 1; j < input2; j++) {
				int temp1 = input1[i] + input1[j] + (Math.abs(i - j));

				System.out.println();

				if (temp1 > maximumWeight) {
					maximumWeight = temp1;
					shortestDistance = Math.abs(i - j);
				}

				if (maximumWeight == temp1 && shortestDistance < Math.abs(i - j)) {
					shortestDistance = Math.abs(i - j);
				}

			}
		}
		return maximumWeight;
	}

	public static int ball_count(int[] input1, int input2, int input3) {
		if (input3 > input1.length) {
			return -1;
		}
		findSum(input3, 0, input2, input1, 0);
		return ballNum == 0 ? -1 : ballNum;
	}

	static int ballNum = 0;

	public static void findSum(int count, int sum, int givenSum, int arr[], int index) {
		if (count == 0) {
			if (sum % givenSum == 0) {
				if (ballNum == 0 || ballNum > sum) {
					ballNum = sum;
				}
			}
			return;
		}
		if (index < arr.length)
			findSum(count - 1, sum + arr[index], givenSum, arr, index + 1);
		if (index < arr.length)
			findSum(count, sum, givenSum, arr, index + 1);
	}

	class Generic<T extends Number & Runnable> {

	}

	public static void m1(ArrayList<Integer> list) {
		System.out.println();
	}

	// public static void m1(List<String> list) {
	// System.out.println();
	// }

	// public static void m1(List<? super Number> list) {
	// System.out.println();
	// }

	public static void m1(List<?> list) {
		System.out.println();
		m2(new ArrayList<Object>());
	}

	public static void m2(List<? super Runnable> list) {
		list.add(new Thread());
		System.out.println();
	}

	// public static void m2(List<? extends Runnable> list) {
	// list.add(new Thread());
	// System.out.println();
	// }

	public static void test(List<Long> pogIds) {
		pogIds.clear();
	}

	private int i = 5;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	private Integer ab = 10;

	public Integer getAb() {
		return ab;
	}

	public void setAb(Integer ab) {
		this.ab = ab;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	private static void test() {
		Enumeration e = null;
		try {
			e = NetworkInterface.getNetworkInterfaces();
		} catch (SocketException e1) {
		}
		while (e.hasMoreElements()) {
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration ee = n.getInetAddresses();
			while (ee.hasMoreElements()) {
				InetAddress i = (InetAddress) ee.nextElement();
				System.out.println(i.getHostAddress());
			}
		}
	}

	public static void findNextSparseNumber(Integer number) {
		String binary = Integer.toBinaryString(number);
		binary = "0" + binary;
		Boolean isAlreadyParse = true;
		int i = 1;
		while (i < binary.length()) {
			if (binary.charAt(i) == '1' && binary.charAt(i - 1) == '1') {
				isAlreadyParse = false;
				break;
			}
			i++;
		}

		int lastChangedPos = 0;
		StringBuilder stringBuilder = new StringBuilder(binary);
		if (!isAlreadyParse) {
			stringBuilder = stringBuilder.reverse();
			for (i = 1; i < stringBuilder.length() - 1; i++) {
				if (stringBuilder.charAt(i) == '1' && stringBuilder.charAt(i - 1) == '1'
						&& stringBuilder.charAt(i + 1) == '0') {
					stringBuilder.setCharAt(i + 1, '1');
					int j = i;
					while (j >= lastChangedPos) {
						stringBuilder.setCharAt(j--, '0');
					}
					lastChangedPos = i + 1;
				}
			}
			stringBuilder = stringBuilder.reverse();
		}
		System.out.println(Integer.parseInt(stringBuilder.toString(), 2));
	}

	

	public static void main(String[] args) throws Exception {
		
		int k = 6;
		System.out.println(k & ~(k-1));
		
		System.out.println(2%1);
		
		findNextSparseNumber(3);
		findNextSparseNumber(38);
		findNextSparseNumber(44);
		findNextSparseNumber(6);

		test();
		List<String> list = new ArrayList<String>();

		m1(((ArrayList<String>) list));
		m1(new ArrayList<String>());
		Test t1 = new Test();
		System.out.println(t1.getI());

		Test t2 = (Test) t1.clone();

		System.out.println(t2.getI());
		t2.setI(99);
		t2.setAb(90);
		System.out.println(t1.getI() + " " + t1.getAb());
		String i2 = "+1.8 +bravo +3";
		i2 = i2.replaceAll("\\+", "");
		System.out.println();

		String json = "{'installDate': '2016-10-01','deviceOs': 'Android','numberOfInstalls': 2,'commissionRate': 52,'commissionFee': 104,'affSub1': 'hp_____mob','affSub2': null   }";
		System.out.println(new ObjectMapper().readValue(json, AppReportDTO.class));

		Integer lar = new Integer(10);
		int j = 10;
		System.out.println(lar == j);

		Map<Long, String> map2 = new LinkedHashMap<Long, String>();
		map2.put(1l, "abc");
		map2.put(1l, "2abc");
		map2.put(3l, "abc");

		Map<Long, String> map3 = new LinkedHashMap<Long, String>();
		map3.putAll(map2);

		map2.clear();
		System.out.println();

		System.out.println(map2);
		List<Long> pogIds = new ArrayList<Long>();
		pogIds.add(1212l);
		pogIds.add(12121212l);

		// test(pogIds);
		System.out.println(pogIds.size());

		ListIterator<Long> listIterator = pogIds.listIterator();
		listIterator.next();
		listIterator.set(1212l);
		listIterator.add(8788l);
		System.out.println(ball_count(new int[] { 1, 2, 3, 4, 5 }, 50, 3));
		if (true)
			return;
		System.out.println(traveltime(new int[] { 1, 2, 3, 4 }, 4));
		System.out.println(minimumCost(new String[] { "5#7#2#4", "1#8#1#3", "6#2#9#5", "1#6#2#8" }, 4));

		System.out.println(nochange_bits("101101011011", 0, 4));

		JSONObject jsonObject = new JSONObject();

		map2 = new HashMap<Long, String>();
		map2.put(1l, "abc");
		map2.put(2l, "abc");
		map2.put(3l, "abc");

		List<Node> pogId = new ArrayList<Node>();
		pogId.add(new Node(121212, "234234"));
		pogId.add(new Node(1212112122, "werwer"));

		jsonObject.put("ok", map2);
		jsonObject.put("ok1", pogIds);
		jsonObject.put("ok2", pogId);
		System.out.println(jsonObject);
		System.out.println(map2);

		Properties prop = new Properties();
		prop.put("222", "dsasd");
		System.out.println(prop);

		Map<Long, String> map1 = new HashMap<Long, String>();
		map1.put(1l, "abc");

		map2.keySet().removeAll(map1.keySet());

		System.out.println(map2);

		for (long i = 0; i < 5; i++) {
			pogIds.add(i);
		}
		int batchSize = 2;

		if (pogIds != null && pogIds.size() > 0) {
			for (int i = 0; i < pogIds.size();) {
				List<Long> batchPogIds = pogIds.subList(i,
						(pogIds.size() - i < batchSize ? pogIds.size() : i + batchSize));
				i += batchSize;
				System.out.println(batchPogIds);
			}
		}

		BufferedReader br = new BufferedReader(new FileReader("/home/raghunandangupta/Desktop/books/allLabel"));
		OuterNode sample = new Gson().fromJson(br, OuterNode.class);

		StringBuilder sb = new StringBuilder();
		int commaCount = 0;
		int count = 0;
		for (Node node : sample.getLabels()) {
			append(sb, commaCount);
			append(sb, node);
			sb.append("\n");
			commaCount++;
			for (Node level1 : node.getSubLabels()) {
				append(sb, commaCount);
				append(sb, level1);
				sb.append("\n");
				commaCount++;
				for (Node level2 : level1.getSubLabels()) {
					append(sb, commaCount);
					append(sb, level2);
					sb.append("\n");
					commaCount++;
					for (Node level3 : level2.getSubLabels()) {
						append(sb, commaCount);
						append(sb, level3);
						sb.append("\n");
						commaCount++;
						for (Node level4 : level3.getSubLabels()) {
							append(sb, commaCount);
							append(sb, level4);
							sb.append("\n");
							commaCount++;
							for (Node level5 : level4.getSubLabels()) {
								append(sb, commaCount);
								append(sb, level5);
								sb.append("\n");
								System.out.println(level5.getSubLabels().size());
							}
							commaCount--;
						}
						commaCount--;
					}
					commaCount--;
				}
				commaCount--;
			}
			commaCount--;
		}

		writeListInFile(sb.toString());
		if (true)
			return;

		System.out.println(landingPosition(new int[] { 6, 5 },
				new String[] { "x#o#o#o#x#o", "x#o#o#o#x#x", "x#o#o#o#x#x", "x#o#x#o#o#x", "x#o#x#o#o#x" }));
		System.out.println(landingPosition(new int[] { 6, 5 },
				new String[] { "x#o#o#o#x#o", "x#o#o#o#x#x", "x#o#o#o#x#x", "x#o#x#o#o#x" }));
		if (true)
			return;
		double d1 = Math.pow(10, 3580.0 / 400);
		double d2 = Math.pow(10, 3481.0 / 400);

		double e1 = d1 / (d1 + d2);
		double e2 = d2 / (d1 + d2);

		System.out.println(d1 + " " + d2 + " " + e1 + " " + e2);

		System.out.println((d1 + (32 * (1 - e1))));
		System.out.println((d1 + (32 * (0 - e1))));
		System.out.println((d2 + (32 * (1 - e2))));
		System.out.println((d2 + (32 * (0 - e2))));

		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();

		for (int i = 0; i < 10; i++) {
			map.put(i, new ArrayList<Integer>());
		}

		map.get(0).add(10);

		System.out.println(map);

	}

	public static class OuterNode {
		private List<Node> labels = new ArrayList<Test.Node>();

		public List<Node> getLabels() {
			return labels;
		}

		public void setLabels(List<Node> labels) {
			this.labels = labels;
		}

	}

	public static class Node {
		private Integer bucketId;
		private String displayName;
		private List<Node> subLabels = new ArrayList<Test.Node>();

		public Node(Integer bucketId, String displayName) {
			super();
			this.bucketId = bucketId;
			this.displayName = displayName;
		}

		public Integer getBucketId() {
			return bucketId;
		}

		public void setBucketId(Integer bucketId) {
			this.bucketId = bucketId;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}

		public List<Node> getSubLabels() {
			return subLabels;
		}

		public void setSubLabels(List<Node> subLabels) {
			this.subLabels = subLabels;
		}

	}

	public static void main2(String args[]) {
		List<Integer> productScoreContainers = new ArrayList<Integer>();
		for (int i = 1; i <= 1; i++) {
			productScoreContainers.add(i);
		}

		int pageNum = 4;
		List<Integer> subCreativeContainerList = null;
		for (int i = 1; i <= 5; i++) {
			pageNum = i;
			int slotClusterSize = 10;
			int maxSlotPossible = productScoreContainers.size() / slotClusterSize;
			if (pageNum <= maxSlotPossible) {
				subCreativeContainerList = productScoreContainers.subList(
						((pageNum - 1) % maxSlotPossible) * slotClusterSize,
						(((pageNum - 1) % maxSlotPossible) * slotClusterSize + slotClusterSize < productScoreContainers
								.size() ? ((pageNum - 1) % maxSlotPossible) * slotClusterSize + slotClusterSize
										: productScoreContainers.size()));
			} else if ((pageNum - 1) * slotClusterSize < productScoreContainers.size()) {
				subCreativeContainerList = productScoreContainers.subList((pageNum - 1) * slotClusterSize,
						((pageNum - 1) * slotClusterSize * slotClusterSize + slotClusterSize < productScoreContainers
								.size() ? ((pageNum - 1) * slotClusterSize + slotClusterSize)
										: productScoreContainers.size()));
			}
		}
	}

	public static void main1(String args[]) throws JsonGenerationException, JsonMappingException, Exception {

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
			System.out
					.println("This new number:" + " " + EnteredNumberPlusTen + " " + "Is the original number plus ten");

			Integer number = Keyboard.nextInt();
			int first = number / 10;
			int second = number % 10;
			EnteredNumberPlusTen = ((++first * 10) + second);
			System.out
					.println("This new number:" + " " + EnteredNumberPlusTen + " " + "Is the original number plus ten");
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

		System.out.println(Math.abs(Hashing.murmur3_32()
				.hashString("ahhhkhk3444444444444444444444444", StandardCharsets.UTF_8).hashCode()));

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
			return (int) (1l
					+ TimeUnit.DAYS.convert(Math.abs(date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS));
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

	static public class AppReportDTO {

		private Date installDate;
		private String affSub1;
		private String affSub2;
		private String deviceOs;
		private double commissionFee;
		private double numberOfInstalls;
		private double commissionRate;

		public Date getInstallDate() {
			return installDate;
		}

		public void setInstallDate(Date installDate) {
			this.installDate = installDate;
		}

		public String getAffSub1() {
			return affSub1;
		}

		public void setAffSub1(String affSub1) {
			this.affSub1 = affSub1;
		}

		public String getAffSub2() {
			return affSub2;
		}

		public void setAffSub2(String affSub2) {
			this.affSub2 = affSub2;
		}

		public String getDeviceOs() {
			return deviceOs;
		}

		public void setDeviceOs(String deviceOs) {
			this.deviceOs = deviceOs;
		}

		public double getCommissionFee() {
			return commissionFee;
		}

		public void setCommissionFee(double commissionFee) {
			this.commissionFee = commissionFee;
		}

		public double getNumberOfInstalls() {
			return numberOfInstalls;
		}

		public void setNumberOfInstalls(double numberOfInstalls) {
			this.numberOfInstalls = numberOfInstalls;
		}

		public double getCommissionRate() {
			return commissionRate;
		}

		public void setCommissionRate(double commissionRate) {
			this.commissionRate = commissionRate;
		}

		@Override
		public String toString() {
			return "AppReportDTO [installDate=" + installDate + ", affSub1=" + affSub1 + ", affSub2=" + affSub2
					+ ", deviceOs=" + deviceOs + ", commissionFee=" + commissionFee + ", numberOfInstalls="
					+ numberOfInstalls + ", commissionRate=" + commissionRate + "]";
		}

	}
}