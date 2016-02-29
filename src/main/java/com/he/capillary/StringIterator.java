package com.he.capillary;

import java.util.Iterator;

public class StringIterator implements Iterator {

	private String str;
	private int index;

	public StringIterator(String str) {
		this.str = str;
		this.index = str.length();
	}

	public boolean hasNext() {
		if (index != 0)
			return true;
		return false;
	}

	public Character next() {
		char ch = str.charAt(str.length() - index);
		index--;
		return ch;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
