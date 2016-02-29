package com.he.capillary;

import java.util.Scanner;

public class TurtleGame {

	private static int cWidth = 20;
	private static char appBoard[][] = new char[cWidth][cWidth];

	public static void main(String[] args) {

		int choice = 0;
		boolean isQuit = false;
		appBoard[appBoard.length / 2][appBoard.length / 2] = '*';
		int nColTurtle = appBoard.length / 2;
		int nRowTurtle = appBoard.length / 2;
		char chFacing = 0;
		boolean bPendDwon = false;
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < appBoard.length; i++) {
			for (int j = 0; j < appBoard.length; j++) {
				appBoard[i][j] = ' ';
			}
		}
		while (true) {
			System.out.println(
					"\n1.Pen Up\n2.Pen Down\n3.Turn 90 degrees to the right.\n4.Turn 90 degrees to the left.\n5.Move forward specific number of squares.\n6.Print the board status.\n7.quit");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				chFacing = 'n';
				if (nRowTurtle > 0) {
					nRowTurtle--;
					bPendDwon = false;
					appBoard[nRowTurtle][nColTurtle] = '*';
				}
				break;
			case 2:
				chFacing = 's';
				if (nRowTurtle < appBoard.length - 1) {
					nRowTurtle++;
					bPendDwon = true;
					appBoard[nRowTurtle][nColTurtle] = '*';
				}
				break;
			case 3:
				chFacing = 'w';
				break;
			case 4:
				chFacing = 'e';
				break;
			case 5:
				System.out.println("\nPlease enter how far move to forward.");
				choice = sc.nextInt();
				if (chFacing == 'e') {
					if (nRowTurtle - choice >= 0){
						int temp  = nRowTurtle;
						nRowTurtle = nRowTurtle - choice;
						while(temp > nRowTurtle){
							appBoard[temp][nColTurtle] = '*';
							temp--;
						}
					}
				} else if (chFacing == 'w') {
					if (nRowTurtle - choice < appBoard.length){
						int temp  = nRowTurtle;
						nRowTurtle = nRowTurtle + choice;
						while(temp < nRowTurtle){
							appBoard[temp][nColTurtle] = '*';
							temp++;
						}
					}
				}
				if (chFacing == 'n') {
					if (nColTurtle - choice >= 0){
						int temp  = nColTurtle;
						nColTurtle = nColTurtle - choice;
						while(temp > nColTurtle){
							appBoard[nRowTurtle][temp] = '*';
							temp--;
						}
					}
				} else if (chFacing == 's') {
					if (nColTurtle + choice < appBoard.length){
						int temp  = nColTurtle;
						nColTurtle = nColTurtle + choice;
						while(temp < nColTurtle){
							appBoard[nRowTurtle][temp] = '*';
							temp++;
						}
					}
				}
				break;
			case 6:
				for (int i = 0; i < appBoard.length; i++) {
					for (int j = 0; j < appBoard.length; j++) {
						System.out.print(appBoard[i][j]);
					}
					System.out.println();
				}
				break;
			case 7:
				isQuit = true;
				break;
			}
			if (isQuit)
				break;
		}

	}
}
