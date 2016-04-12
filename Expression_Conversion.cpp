#include <iostream>
#include <stack>
#include <string>
#include "convertor.h"
using namespace std;

int main() {
	int choice;
	while (1) {
		cout << "===============================================\n";
		cout
				<< "1: Binary -> Decimal\n2: Decimal -> Binary \n3: Parenthesis Matching.Others Quit.";
		cout << "\n===============================================";
		cout << "\nEnter your choice : ";
		cin >> choice;

		if (choice == 1) {
			binaryToDecimal();
		} else if (choice == 2) {
			decimalToBinary();
		} else if (choice == 3) {
			matchParehnthsis();
		} else {
			return 0;
		}
	}
	return 0;
}

