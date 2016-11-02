package com.home.geeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CreditCard {

	static class Person {
		private String personType;
		private String name;

		public String getPersonType() {
			return personType;
		}

		public void setPersonType(String personType) {
			this.personType = personType;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Person(String personType, String name) {
			super();
			this.personType = personType;
			this.name = name;
		}

	}

	public static void acds(ArrayList<Integer>[][] domains) {
		ArrayList<Integer>[][] domainsLeft = new ArrayList[9][9];
		ArrayList<Integer>[][] domainsRight = new ArrayList[9][9];
		for (int r = 0; r < 9; r++)
			for (int c = 0; c < 9; c++) {
				domainsLeft[r][c] = domains[r][c];
				domainsRight[r][c] = domains[r][c];
			}

		System.out.println(domainsLeft[0][0]);
		System.out.println(domainsRight[0][0]);

		List<Integer> list = new ArrayList<Integer>();
		list.addAll(domainsRight[0][0]);

		List<Integer> oldList = domainsRight[0][0];
		if (oldList.size() > 0) {
			oldList.remove(0);
		}

		System.out.println(domainsLeft[0][0]);
		System.out.println(domainsRight[0][0]);
		System.out.println(list);

	}

	public static void populate() {
		ArrayList<Integer>[][] domains = new ArrayList[9][9];
		for (int i = 0; i < domains.length; i++) {
			for (int j = 0; j < domains.length; j++) {
				domains[0][0] = new ArrayList<Integer>();
				for (int k = 0; k < 10; k++) {
					domains[0][0].add(k);
				}
			}
		}
		acds(domains);
	}

	private String event;
	private String name;

	public CreditCard() {
		// TODO Auto-generated constructor stub
	}

	public CreditCard(String event, String name) {
		super();
		this.event = event;
		this.name = name;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "CreditCard [event=" + event + ", name=" + name + "]";
	}

	private static List<Person> get() {
		Person person01 = new Person("10", "Tony");
		Person person02 = new Person("15", "Steve");
		Person person03 = new Person("12", "Banner");
		Person person04 = new Person("10", "Thor");
		Person person05 = new Person("11", "Natasha");
		Person person06 = new Person("12", "Loki");
		Person person07 = new Person("10", "Peter");
		Person person08 = new Person("11", "HawkEye");
		Person person09 = new Person("12", "Falcon");
		Person person10 = new Person("10", "Jarvis");
		List<Person> persons = new ArrayList<>();
		persons.add(person01);
		persons.add(person02);
		persons.add(person03);
		persons.add(person04);
		persons.add(person05);
		persons.add(person06);
		persons.add(person07);
		persons.add(person08);
		persons.add(person09);
		persons.add(person10);

		persons = persons.stream().map(new Function<Person, Person>() {

			@Override
			public Person apply(Person t) {
				if (Integer.parseInt(t.getPersonType()) >= 10) {
					t.setPersonType("5");
				} else {
					throw new RuntimeException("Element 10 wasn't found");
				}
				return t;
			}
		}).collect(Collectors.toList());

		return persons;
	}

	public static void main(String[] args) {

		List<Person> persons = get();

		Map<String, List<Person>> obj1 = persons.stream().collect(Collectors.groupingBy(Person::getPersonType));
		System.out.println(obj1);

		List<Map<String, String>> nqColumnMapList = new ArrayList<Map<String, String>>();

		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("A", "A1");
		map1.put("B", "B1");
		map1.put("C", "C1");

		Map<String, String> map2 = new HashMap<String, String>();
		map2.put("a", "A2");
		map2.put("b", "B2");
		map2.put("c", "C2");

		nqColumnMapList.add(map1);
		nqColumnMapList.add(map2);

		Map<String, List<String>> targetTableColumnListMap = nqColumnMapList.stream().flatMap(m -> m.entrySet().stream())
				.collect(Collectors.groupingBy(e -> e.getKey().toUpperCase(), Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
		System.out.println("####" + targetTableColumnListMap);
		// populate();
		//
		// if (true) {
		// return;
		// }

		// ArrayList<int[]> nodes = new ArrayList<int[]>();
		// int coXY[] = nodes.get(nodes.size() - 1);
		// if (coXY[0] == 5 && coXY[1] == 7) {
		//
		// }

		List<CreditCard> list = new ArrayList<CreditCard>();
		list.add(new CreditCard("a", "John1"));
		list.add(new CreditCard("B", "John2"));
		list.add(new CreditCard("C", "John3"));

		list.add(new CreditCard("A", "mark1"));
		list.add(new CreditCard("B", "mark2"));
		list.add(new CreditCard("C", "mark3"));

		Map<String, List<CreditCard>> obj = list.stream().collect(Collectors.groupingBy(new Function<CreditCard, String>() {

			@Override
			public String apply(CreditCard t) {
				return t.getEvent().toUpperCase();
			}

		}, Collectors.toList()));

		System.out.println(obj);
	}

	public static void main2() {

		List<Integer> numbers = new ArrayList<Integer>();

		Integer laregst = Integer.MIN_VALUE;
		Integer smallest = Integer.MAX_VALUE;
		Integer sum = 0;
		Integer count = 0;
		Scanner s = new Scanner(System.in);
		int temp = s.nextInt();
		while (temp != -1) {
			if (temp > laregst) {
				laregst = temp;
			}

			if (temp < smallest) {
				smallest = temp;
			}

			sum += temp;
			count += 1;

			System.out.println("Please enter a Positive integer or -1 to quit.");
			temp = s.nextInt();
		}
		System.out.println("Largest : " + (count == 0 ? "NA" : laregst) + " Smallest : " + (count == 0 ? "NA" : smallest) + " Mean : "
				+ (count == 0 ? "NA" : ((sum * 1.0 / count))));
	}

	public static void main1() {
		int inputNumber = 4554;
		if (inputNumber == reverse(inputNumber)) {
			System.out.println("The number is palindrome.");
		} else {
			System.out.println("The number is not a palindrome.");
		}
	}

	public static int reverse(int number) {
		int temp = 0;
		while (number > 0) {
			temp = temp * 10 + number % 10;
			number = number / 10;
		}
		return temp;
	}

	public static void main3(String args[]) {
		main2();
		Scanner scan = new Scanner(System.in);

		final String CREDIT_CARD = "[0-9]{8}";
		int length = 8;
		String num, response;
		char ch1, ch2;

		do {
			do {
				System.out.println("Please enter a 8 digit credit cardnumber");
				num = scan.next();
			} while (!num.matches(CREDIT_CARD));

			int sum = 0;
			Boolean isValidCard = true;
			for (int i = 0; i < num.length(); i++) {
				ch1 = num.charAt(i);
				if (Character.isDigit(ch1)) {
					if (i % 2 == 1) {
						sum += ((int) ch1 - 48);
					} else {
						int temp = (2 * ((int) ch1 - 48));
						while (temp > 0) {
							sum += temp % 10;
							temp = temp / 10;
						}
					}
				} else {
					isValidCard = false;
					break;
				}
			}
			if (!isValidCard) {
				System.out.println("CC Invalid");
			} else if (sum % 10 == 0) {
				System.out.println("CC is valid");
			}

			System.out.println("Would you like to enter a different card?");
			response = scan.next();
		} while (response.equals("yes"));

		System.out.println("Goodbye!");

	}
}
