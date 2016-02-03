package com.he.capillary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {

	public static void main(String[] args) throws FileNotFoundException {
		double totalValue = 0.0d;
		Scanner scanner = new Scanner(System.in);
		String fileName = scanner.nextLine();
		try{
			scanner = new Scanner(new File(fileName));
			while(scanner.hasNextLine()){
				if(scanner.hasNextDouble()){
					totalValue += scanner.nextDouble();
				}else{
					scanner.nextLine();
				}
			}
			System.out.println(totalValue);
		}catch(Exception exception){
			System.out.println("File Not found.");
		}
	}
}
