package com.home.geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//http://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-atleast-d-distance-away/
public class ReaarangeStringAtDistance {

	public static void main(String[] args) {

		String str = "aaaabbbcc";
		List<Charc> list = new ArrayList<Charc>();
		for (int i = 0; i < str.length(); i++) {
			Charc charc = new Charc();
			charc.setCh(str.charAt(i));
			if (list.indexOf(charc) != -1) {
				charc.setCount(list.get(list.indexOf(charc)).getCount() + 1);
			} else {
				charc.setCount(1);
			}
			list.add(charc);
		}
		Collections.sort(list);
		System.out.println(list);

		int distance = 3;
		int modifiedD = 0;
		int otherD = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < list.size(); i++) {
			Charc charc = list.get(i);
			int count = charc.getCount();
			otherD = 0;
			while (count > 0) {
				sb.setCharAt(distance, charc.getCh().charValue());
				modifiedD = distance + distance;
				count--;
			}
			if(count == 0){
				otherD++;
			}
		}

	}

	static class Charc implements Comparable<Charc> {
		private Character ch;
		private Integer count;

		public Character getCh() {
			return ch;
		}

		public void setCh(Character ch) {
			this.ch = ch;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((ch == null) ? 0 : ch.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Charc other = (Charc) obj;
			if (ch == null) {
				if (other.ch != null)
					return false;
			} else if (!ch.equals(other.ch))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Charc [ch=" + ch + ", count=" + count + "]";
		}

		@Override
		public int compareTo(Charc o) {
			return -this.getCount().compareTo(o.getCount());
		}

	}

}
