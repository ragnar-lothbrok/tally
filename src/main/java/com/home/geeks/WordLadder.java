package com.home.geeks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	public static void main(String[] args) {

		String start = "hit";
		String end = "cog";
		List<String> dicList = new ArrayList<>();
		dicList.add("hot");
		dicList.add("dot");
		dicList.add("dog");
		dicList.add("lot");
		dicList.add("log");
		dicList.add(end);
		findPath(start, end, dicList);

	}

	private static void findPath(String start, String end, List<String> dicList) {
		Word word = new Word(start, 1);
		Queue<Word> queue = new LinkedList<Word>();
		queue.add(word);
		while (!queue.isEmpty()) {
			Word temp = queue.poll();
			if (temp.getText().equals(end)) {
				System.out.println("======" + temp.getNumOfSteps());
				return;
			}
			char ch[] = temp.getText().toCharArray();
			for (int i = 0; i < ch.length; i++) {
				for (char c = 'a'; c <= 'z'; c++) {
					char chTemp = ch[i];
					if (ch[i] != c) {
						ch[i] = c;
					}
					String newWord = new String(ch);
					if (dicList.contains(newWord)) {
						System.out.println(newWord);
						queue.add(new Word(newWord, temp.getNumOfSteps() + 1));
						dicList.remove(newWord);
					}
					ch[i] = chTemp;
				}
			}
		}
	}

	static class Word {
		private String text;
		private int numOfSteps;

		public Word(String text, int numOfSteps) {
			super();
			this.text = text;
			this.numOfSteps = numOfSteps;
		}

		public Word() {

		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public int getNumOfSteps() {
			return numOfSteps;
		}

		public void setNumOfSteps(int numOfSteps) {
			this.numOfSteps = numOfSteps;
		}

		@Override
		public String toString() {
			return "Word [text=" + text + ", numOfSteps=" + numOfSteps + "]";
		}

	}
}
