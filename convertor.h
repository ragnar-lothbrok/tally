#include <iostream>
#include <stack>
#include <string>
#include <stdio.h>

using namespace std;

void binaryToDecimal() {
	long bin, dec = 0, rem, num, base = 1;
	cout << "Enter the binary number(1s and 0s) : ";
	cin >> num;
	bin = num;
	while (num > 0) {
		rem = num % 10;
		dec = dec + rem * base;
		base = base * 2;
		num = num / 10;
	}
	cout << "The decimal equivalent of " << bin << " : " << dec << endl;
}

void decimalToBinary() {
	long dec, rem, i = 1, sum = 0;
	cout << "Enter the decimal to be converted:";
	cin >> dec;
	do {
		rem = dec % 2;
		sum = sum + (i * rem);
		dec = dec / 2;
		i = i * 10;
	} while (dec > 0);
	cout << "The binary of the given number is:" << sum << endl;
	cin.get();
	cin.get();
}

bool ArePair(char opening, char closing) {
	if (opening == '(' && closing == ')')
		return true;
	else if (opening == '{' && closing == '}')
		return true;
	else if (opening == '[' && closing == ']')
		return true;
	return false;
}
bool AreParanthesesBalanced(char exp[]) {
	stack<char> S;
	unsigned int i = 0;
	for (i = 0; i < 100; i++) {
		if (exp[i] == '\0')
			break;
		if (exp[i] == '(' || exp[i] == '{' || exp[i] == '[')
			S.push(exp[i]);
		else if (exp[i] == ')' || exp[i] == '}' || exp[i] == ']') {
			if (S.empty() || !ArePair(S.top(), exp[i]))
				return false;
			else
				S.pop();
		}
	}
	return S.empty() ? true : false;
}

void matchParehnthsis() {
	getchar();
	char ch;
	char expression[100];
	cout << "Enter an expression:  ";
	int i = 0;
	while ((ch = getchar()) != '\n') {
		expression[i++] = ch;
	}
	if (AreParanthesesBalanced(expression))
		cout << "Balanced\n";
	else
		cout << "Not Balanced\n";
}
