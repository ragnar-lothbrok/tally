package com.home.dhruva;


import java.util.Stack;

public class SortStack {

    Stack<Integer> sortStack(Stack<Integer> inputStack) {
        Stack<Integer> tempStack = new Stack<Integer>();
        while (!inputStack.isEmpty()) {
            int element = inputStack.pop();
            while (!tempStack.isEmpty() && tempStack.peek() < element) {
                inputStack.push(tempStack.pop());
            }
            tempStack.push(element);
        }
        while (!tempStack.isEmpty()) {
            inputStack.push(tempStack.pop());
        }
        return inputStack;
    }

    public static void main(String[] args) {
        Stack<Integer> tempStack = new Stack<Integer>();
        tempStack.push(4);
        tempStack.push(5);
        tempStack.push(3);
        tempStack.push(2);

        new SortStack().sortStack(tempStack);
    }

}
