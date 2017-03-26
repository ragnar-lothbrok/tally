package com.ques.chegg;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

import javax.swing.Action;

import org.apache.velocity.app.event.EventHandler;

import com.amazonaws.services.apigateway.model.Stage;
import com.amazonaws.services.elasticmapreduce.model.Application;

class Food {
	private String name;
	private Integer quantity;
	private Integer calory;
	private String mealType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getCalory() {
		return calory;
	}

	public void setCalory(Integer calory) {
		this.calory = calory;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	@Override
	public String toString() {
		return "Food [name=" + name + ", quantity=" + quantity + ", calory=" + calory + ", mealType=" + mealType + "]";
	}

}

class Client {
	private String firstName;
	private String lastName;
	private String password;
	private String clientId;

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

public class Main {

	public static void main(String[] args) {
		
		System.out.println(gcd(10, 5));
		
		int choice = 1;
		Scanner scanner = new Scanner(System.in);
		List<Client> clientList = new ArrayList<Client>();
		Stack<Food> foodList = new Stack<Food>();
		Client loggedInClient = null;
		do {
			System.out.println("Please enter your choice  : ");
			System.out.println(
					"1.Create Client \n2. Login Client \n3.Add Food Item \n4.Food history \n5.Different Foods \n6.Total Calory \n7.Food with maximum Calories \n8.max Food item ate \n9.Logout");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				Client client = new Client();
				System.out.println("Enter first name : ");
				client.setFirstName(scanner.next());
				System.out.println("Enter last name : ");
				client.setLastName(scanner.next());
				System.out.println("Enter client id : ");
				client.setClientId(scanner.next());
				Boolean isExists = isExists(clientList, client);
				if (isExists) {
					System.out.println("Enter client id : ");
					client.setClientId(scanner.next());
					isExists = isExists(clientList, client);
					if (isExists) {
						String clientId = client.getLastName() + Calendar.getInstance().getTimeInMillis();
						clientId = clientId.substring(0, 8);
						client.setClientId(clientId);
					}
				}
				System.out.println("Enter password : ");
				client.setPassword(scanner.next());
				clientList.add(client);
				break;
			case 2:
				System.out.println("Enter client id : ");
				String clientId = scanner.next();
				System.out.println("Enter password : ");
				String password = scanner.next();
				client = isLoggedInClient(clientList, clientId, password);
				if (client != null) {
					loggedInClient = client;
					System.out.println("Logged in successfully.");
				}
				break;
			case 3:
				Food food = new Food();
				System.out.println("Enter name : ");
				food.setName(scanner.next());
				System.out.println("Enter calories : ");
				food.setCalory(scanner.nextInt());
				System.out.println("Enter quantity : ");
				food.setQuantity(scanner.nextInt());
				System.out.println("Enter mean Type : ");
				food.setMealType(scanner.next());
				foodList.add(food);
				break;
			case 4:
				printFoodHisotry(foodList, 0);
				break;
			case 5:
				printDifferentItems(foodList);
				break;
			case 6:
				printTotalCalories(foodList);
				break;
			case 7:
				printMaxCalorieFood(foodList);
				break;
			case 8:
				printMaxTimesFood(foodList);
				break;
			case 9:
				loggedInClient = null;
				foodList.clear();
				break;
			}
		} while (choice != 9);
	}

	private static void printMaxCalorieFood(List<Food> foodList) {
		Map<String, Integer> foodCalorie = new HashMap<String, Integer>();
		for (Food food : foodList) {
			if (foodCalorie.get(food.getName()) == null) {
				foodCalorie.put(food.getName(), food.getCalory());
			} else {
				foodCalorie.put(food.getName(), food.getCalory() + foodCalorie.get(food.getName()));
			}
		}
		Optional<Entry<String, Integer>> entry = foodCalorie.entrySet().stream()
				.sorted(new Comparator<Entry<String, Integer>>() {

					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
						return -o1.getValue().compareTo(o2.getValue());
					}
				}).findFirst();

		System.out.println(entry.get().getKey());
	}

	private static void printMaxTimesFood(List<Food> foodList) {
		Map<String, Integer> foodCalorie = new HashMap<String, Integer>();
		for (Food food : foodList) {
			if (foodCalorie.get(food.getName()) == null) {
				foodCalorie.put(food.getName(), 1);
			} else {
				foodCalorie.put(food.getName(), 1 + foodCalorie.get(food.getName()));
			}
		}

		Optional<Entry<String, Integer>> entry = foodCalorie.entrySet().stream()
				.sorted(new Comparator<Entry<String, Integer>>() {

					@Override
					public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
						return -o1.getValue().compareTo(o2.getValue());
					}
				}).findFirst();

		System.out.println(entry.get().getKey());
	}

	private static void printTotalCalories(List<Food> foodList) {
		Integer calories = 0;
		for (Food food : foodList) {
			calories += food.getCalory();
		}
		System.out.println(calories);
	}

	private static void printDifferentItems(List<Food> foodList) {
		Set<String> foodNames = new HashSet<String>();
		for (Food food : foodList) {
			foodNames.add(food.getName());
		}
		System.out.println(foodNames);
	}

	private static void printFoodHisotry(List<Food> foodList, int count) {
		if (count == foodList.size()) {
			return;
		}
		printFoodHisotry(foodList, count + 1);
		System.out.println(foodList.get(count));
	}

	private static Client isLoggedInClient(List<Client> clientList, String clientId, String password) {
		if (clientList != null && clientList.size() > 0) {
			for (Client temp : clientList) {
				if (temp.getClientId().equals(clientId) && temp.getPassword().equals(password)) {
					return temp;
				}
			}
		}
		return null;
	}

	private static Boolean isExists(List<Client> clientList, Client client) {
		if (clientList != null && clientList.size() > 0) {
			for (Client temp : clientList) {
				if (temp.getClientId().equals(client.getClientId())) {
					return true;
				}
			}
		}
		return false;
	}

	private static int gcd(int num1, int num2) {
		while (num1 != num2) {
			if (num1 > num2) {
				return gcd(num1 - num2, num2);
			} else {
				return gcd(num1, num2 - num1);
			}
		}
		return num1;
	}

}
