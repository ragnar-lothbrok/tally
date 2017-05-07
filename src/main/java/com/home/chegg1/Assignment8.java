package com.home.chegg1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Assignment8 {
	public static void main(String[] args) {
		char input1;
		String name, location, projNumStr, budgetStr;
		int projNumber;
		double budget;
		boolean operation = false;
		int operation2 = 0;
		String line;
		String filename;

		// create a ProjectManagement object. This is used throughout this
		// class.
		ProjectManagement manage1 = new ProjectManagement();

		try {
			// print out the menu
			printMenu();

			// create a BufferedReader object to read input from a keyboard
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader stdin = new BufferedReader(isr);

			do {
				System.out.print("What action would you like to perform?\n");
				line = stdin.readLine().trim(); // read a line
				input1 = line.charAt(0);
				input1 = Character.toUpperCase(input1);

				if (line.length() == 1) // check if a user entered only one
										// character
				{
					switch (input1) {
					case 'A': // Add Project
						try {
							System.out.print("Please enter a project name to add:\n");
							name = stdin.readLine().trim();
							System.out.print("Please enter its projNumber to add:\n");
							projNumStr = stdin.readLine().trim();
							projNumber = Integer.parseInt(projNumStr);
							System.out.print("Please enter its location to add:\n");
							location = stdin.readLine().trim();
							System.out.print("Please enter its initial budget to add:\n");
							budgetStr = stdin.readLine().trim();
							budget = Double.parseDouble(budgetStr);

							operation = manage1.addProject(name, location, projNumber, budget);
							if (operation == true)
								System.out.print("project added\n");
							else
								System.out.print("project exists\n");
						} catch (Exception exception) {
							System.out.println("Exception occured : " + exception);
						}
						break;
					case 'D': // Search by projNumber
						try {
							System.out.print("Please enter projNumber to search:\n");
							projNumStr = stdin.readLine().trim();
							projNumber = Integer.parseInt(projNumStr);
							operation2 = manage1.projNumberExists(projNumber);

							if (operation2 > -1)
								System.out.print("projNumber found\n");
							else
								System.out.print("projNumber not found\n");
						} catch (Exception exception) {
							System.out.println("Exception occured : " + exception);
						}
						break;
					case 'E': // Search by name and location
						System.out.print("Please enter a name to search:\n");
						name = stdin.readLine().trim();
						System.out.print("Please enter a location to search:\n");
						location = stdin.readLine().trim();
						operation2 = manage1.nameLocationExists(name, location);

						if (operation2 > -1)
							System.out.print("project name and location found\n");
						else
							System.out.print("project name and location not found\n");
						break;
					case 'L': // List projects
						System.out.print(manage1.listProjects());
						break;
					case 'O': // Sort by projNumber
						manage1.sortByProjNumber();
						System.out.print("sorted by projNumber\n");
						break;
					case 'P': // Sort by locations and project names
						manage1.sortByNameLocation();
						System.out.print("sorted by project names and locations\n");
						break;
					case 'Q': // Quit
						break;
					case 'R': // Remove by projNumber
						try {
							System.out.print("Please enter projNumber to remove:\n");
							projNumStr = stdin.readLine().trim();
							projNumber = Integer.parseInt(projNumStr);
							operation = manage1.removeProjNumber(projNumber);
							if (operation == true)
								System.out.print("projNumber removed\n");
							else
								System.out.print("projNumber not found\n");
						} catch (Exception exception) {
							System.out.println("Exception occured : " + exception);
						}
						break;
					case 'S': // Remove by location and name
						System.out.print("Please enter a name to remove:\n");
						name = stdin.readLine().trim();
						System.out.print("Please enter a location to remove:\n");
						location = stdin.readLine().trim();
						operation = manage1.removeNameLocation(name, location);
						if (operation == true)
							System.out.print("project name and location removed\n");
						else
							System.out.print("project name and location not found\n");
						break;
					case 'T': // Close ProjectManagement
						manage1.closeProjectManagement();
						System.out.print("project management system closed\n");
						break;
					case 'U': // Write Text to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						try {
							File file = new File(filename);
							if (!file.exists()) {
								file.createNewFile();
							}
							FileWriter fw = new FileWriter(file.getAbsoluteFile());
							BufferedWriter bw = new BufferedWriter(fw);
							bw.write(manage1.listProjects());
							bw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
						break;
					case 'V': // Read Text from a File
						System.out.print("Please enter a file name to read:\n");
						filename = stdin.readLine().trim();
						/************************************************************************************
						 *** ADD your code to read a text (string) from the
						 * specified file. Catch exceptions.
						 ************************************************************************************/
						break;
					case 'W': // Serialize ProjectManagement to a File
						System.out.print("Please enter a file name to write:\n");
						filename = stdin.readLine().trim();
						try {
							File yourFile = new File(filename);
							if (!yourFile.exists()) {
								yourFile.createNewFile();
							}
							FileOutputStream fileOutputStream = new FileOutputStream(yourFile);
							ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
							objectOutputStream.writeObject(manage1);
						} catch (FileNotFoundException e) {
							System.out.println("FileNotFoundException :>>" + e);
						} catch (IOException e) {
							System.out.println("IOException :>>" + e);
						}
						break;
					case 'X': // Deserialize ProjectManagement from a File
						System.out.print("Please enter a file name to read:\n");
						filename = stdin.readLine().trim();
						Object object = null;
						try {
							FileInputStream fileInputStream = new FileInputStream(new File(filename));
							ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
							object = objectInputStream.readObject();
							System.out.println(object);
						} catch (FileNotFoundException e) {
							System.out.println("FileNotFoundException :>>" + e.getStackTrace());
						} catch (IOException e) {
							System.out.println("IOException :>>" + e.getStackTrace());
						} catch (ClassNotFoundException e) {
							System.out.println("ClassNotFoundException :>>" + e.getStackTrace());
						}
						break;
					case '?': // Display Menu
						printMenu();
						break;
					default:
						System.out.print("Unknown action\n");
						break;
					}
				} else {
					System.out.print("Unknown action\n");
				}
			} while (input1 != 'Q' || line.length() != 1);
		} catch (IOException exception) {
			System.out.print("IO Exception\n");
		}
	}

	/** The method printMenu displays the menu to a user **/
	public static void printMenu() {
		System.out.print("Choice\t\tAction\n" + "------\t\t------\n" + "A\t\tAdd Project\n"
				+ "D\t\tSearch for ProjNumber\n" + "E\t\tSearch for Name and Location\n" + "L\t\tList Projects\n"
				+ "O\t\tSort by ProjNumber\n" + "P\t\tSort by Name and Location\n" + "Q\t\tQuit\n"
				+ "R\t\tRemove by ProjNumber\n" + "S\t\tRemove by Name and Location\n"
				+ "T\t\tClose ProjectManagement\n" + "U\t\tWrite Text to File\n" + "V\t\tRead Text from File\n"
				+ "W\t\tSerialize ProjectManagement to File\n" + "X\t\tDeserialize ProjectManagement from File\n"
				+ "?\t\tDisplay Help\n\n");
	}
}
