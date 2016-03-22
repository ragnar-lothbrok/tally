#include<iostream>
#include<cstdlib>
using namespace std;
#define ROW 6
#define COL 4
#define MAX 25

int costMatrix[ROW][COL] = { { 300, 200, 200, 300 },

{ 300, 200, 200, 300 }, { 300, 200, 200, 300 }, { 300, 200, 200, 300 }, { 300,
		200, 200, 300 }, { 300, 200, 200, 300 } };
char adminPawprint[] = "dpstm3";
char adminPassword[] = "cmp_sc1050";

void flightMenu();

void printFlightMap(char flight[][COL]);

void initialSeats(char flight[][COL], int count);

void displayMenu();

int loginMatch(char string1[], char string2[]);

int getTotalRevenue(char f1[][COL], char f2[][COL], char f3[][COL]);

void seatReservation(char flight[][COL]);

void printMessage(char name[], char num[]);

int main() {
	char flight_1[ROW][COL], flight_2[ROW][COL], flight_3[ROW][COL];
	int reservedSeats = (rand() % 5) + 1;

	char MIA[] = { 'M', 'I', 'A', '1', '0', '5', '0' };

	char LAS[] = { 'L', 'A', 'S', '1', '0', '5', '0' };

	char BNA[] = { 'B', 'N', 'A', '1', '0', '5', '0' };

	initialSeats(flight_1, reservedSeats);
	initialSeats(flight_2, reservedSeats);
	initialSeats(flight_3, reservedSeats);

	int choice = -1;
	int result = -1;
	char pawprint[15];
	char password[15];
	while (choice != 3) {
		displayMenu();
		cout << "Choose an option: \n";
		cin >> choice;
		if (choice == 1) {
			result = -1;
			while (result != 1) {
				cout << "\nAdmin Pawprint:";
				cin >> pawprint;
				cout << "\nAdmin Passowrd:";
				cin >> password;
				result = loginMatch(pawprint, password);
				if (result != 1) {
					cout << "Invalid Pawprint and Password combination";
				} else {
					cout << "login\n";
					cout
							<< "\nPrinting the Flight Map of flight Columbia to Miami....";
					printFlightMap(flight_1);
					cout
							<< "\nPrinting the Flight Map of flight Columbia to Nashville....";
					printFlightMap(flight_2);

					cout
							<< "\nPrinting the Flight Map of flight Columbia to Las Vegas....";

					printFlightMap(flight_3);
					cout << "The total earning from all the flights: $"
							<< getTotalRevenue(flight_1, flight_2, flight_3);
					cout << "\nYou are logged out now!";
				}
			}
		} else if (choice == 2) {
			result = -1;
			char firstName[10];
			while (result < 1 || result > 3) {
				flightMenu();
				cout << "\nChoose a flight: ";
				cin >> result;
			}

			cout << "\nEnter your first name: ";
			cin >> firstName;
			if (result == 1) {
				seatReservation(flight_1);
				printMessage(firstName, MIA);
			} else if (result == 2) {
				seatReservation(flight_2);
				printMessage(firstName, BNA);
			} else if (result == 3) {
				seatReservation(flight_3);
				printMessage(firstName, LAS);
			}
		}
	}
	return 1;
}

void flightMenu() {
	cout << "\n 1.) COU ----> MIA  2.) COU ----> BNA 3.) COU ----> LAS\n";
}

void printFlightMap(char flight[][COL]) {
	cout << "flights \n";
	int i = 0, j = 0;
	for (i = 0; i < ROW; i++) {
		for (j = 0; j < COL; j++) {
			cout << flight[i][j] << " ";
		}
		cout << "\n";
	}
}

void initialSeats(char flight[][COL], int count) {
	int i = 0, j = 0;
	for (i = 0; i < ROW; i++) {
		for (j = 0; j < COL; j++) {
			flight[i][j] = 'O';
		}
	}

	while (count > 0) {
		int row = rand() % ROW;
		int col = rand() % COL;
		if (flight[row][col] == 'O') {
			flight[row][col] = 'X';
			count--;
		}
	}

}

void displayMenu() {
	cout << "\n1.) Admin Log-in\n2.) Reserve a seat\n3.) Exit\n";
}

int loginMatch(char string1[], char string2[]) {
	int length3 = sizeof(adminPawprint) / sizeof(adminPawprint[0]);
	int length4 = sizeof(adminPassword) / sizeof(adminPassword[0]);

	while (length3 > 0) {
		if (string1[length3 - 1] != adminPawprint[length3 - 1]) {
			return -1;
		}
		length3--;
	}

	while (length4 > 0) {
		if (string2[length4 - 1] != adminPassword[length4 - 1]) {
			return -1;
		}
		length4--;
	}

	return 1;
}

int getTotalRevenue(char f1[][COL], char f2[][COL], char f3[][COL]) {
	int cost = 0;
	int i = 0, j = 0;
	for (i = 0; i < ROW; i++) {
		for (j = 0; j < COL; j++) {
			if (f1[i][j] == 'X') {
				cost = cost + costMatrix[i][j];
			}
		}
	}

	for (i = 0; i < ROW; i++) {
		for (j = 0; j < COL; j++) {
			if (f2[i][j] == 'X') {
				cost = cost + costMatrix[i][j];
			}
		}
	}

	for (i = 0; i < ROW; i++) {
		for (j = 0; j < COL; j++) {
			if (f3[i][j] == 'X') {
				cost = cost + costMatrix[i][j];
			}
		}
	}
	return cost;
}

void seatReservation(char flight[][COL]) {
	printFlightMap(flight);
	int row = -1, col = -1;
	int count = 0;
	do {
		if (count != 0) {
			cout
					<< "\nSorry!! someone has reserved that seat. Please Try Again.";
		}
		count++;
		cout << "\nWhich Seat row do you want? :";
		cin >> row;
		if (row < 0 || row >= ROW) {
			cout << "\nSeat Rows are between 0 and 5.";
		} else {
			cout << "\nWhich seat column do you want?";
			cin >> col;
			if (col < 0 || col >= COL) {
				cout << "\nSeat columns are between 0 and 3.";
			}else{
				flight[row][col] = 'X';
			}
		}
	} while (row >= 0 && row < ROW && col >= 0 && col < COL
			&& flight[row][col] != 'X');
	flight[row][col] = 'X';
	cout << "\nYour requested seat has been reserved";
	printFlightMap(flight);
}

void printMessage(char name[], char num[]) {
	cout << "Congratulations " << name;
	cout << " your flight " << num << " is booked. Your e-ticket number is: ";

	int length1 = 0;
	int length2 = 0;
	while (name[length1] != '\0') {
		length1++;
	}
	length1--;

	while (num[length2] != '\0') {
		length2++;
	}
	length2--;
	int i = 0, j = 0;
	while (i < length1 && j < length2) {
		cout << name[i++] << num[j++];
	}
	if (i < length1) {
		while (i < length1) {
			cout << name[i++];
		}
	} else if (j < length2) {
		while (j < length2) {
			cout << num[j++];
		}
	}
	cout << "\nEnjoy your Spring Break :)";
}
