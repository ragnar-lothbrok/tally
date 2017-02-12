package com.home.json;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//https://www.hackerearth.com/challenge/hiring/cleartrip-developer-challenge/problems/25b80b2fb0a949f9a801a4dbc43e860c/
public class CrossTheRiver {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();
		int testCases = Integer.parseInt(line);
		for (int i = 0; i < testCases; i++) {
			int numOfPoints = Integer.parseInt(br.readLine());
			List<Point> list = new ArrayList<Point>();
			for (int j = 0; j < numOfPoints; j++) {
				String split[] = br.readLine().split(" ");
				list.add(new Point(Long.parseLong(split[0]), Long.parseLong(split[1]), Long.parseLong(split[2])));
			}
			line = br.readLine();
			String split[] = line.split(" ");
			Long min = Long.parseLong(split[1]);
			Long max = Long.parseLong(split[0]);
			if (min > max) {
				System.out.println(-1);
				return;
			} else if (min == max) {
				System.out.println(0);
				return;
			} else {
				Boolean isLowerAvailable = false;
				Boolean isUpperAvailable = false;
				for (int k = 0; k < list.size(); k++) {
					Point point = list.get(k);
					if(point.getY() - point.getDiff() <= min){
						isLowerAvailable = true;
					}
					if(point.getY() + point.getDiff() >= max){
						isUpperAvailable = true;
					}
				}
				if(isLowerAvailable && isUpperAvailable){
					System.out.println(countStones(list, min, max, 0l));
				}else{
					System.out.println(-1);
				}
			}
		}
	}

	private static Long countStones(List<Point> list, Long min, Long max, Long count) {
		if (min >= max) {
			return count;
		} else if (list.size() == 0) {
			return -1l;
		} else {
			Iterator<Point> iterator = list.iterator();
			while (iterator.hasNext()) {
				Point point = iterator.next();
				if (point.getY() + point.getDiff() <= min) {
					iterator.remove();
				}
			}
			final Long minLimit = min;
			Point point = list.get(0);
			for (int i = 1; i < list.size(); i++) {
				Long firstLowerLimit = point.getY() - point.getDiff();
				Long secondLowerLimit = list.get(i).getY() - list.get(i).getDiff();
				Long firstUpperLimit = point.getY() + point.getDiff();
				Long secondUpperLimit = list.get(i).getY() + list.get(i).getDiff();
				if(firstLowerLimit > minLimit){
					point = list.get(i);
				}else{
					if(secondUpperLimit > firstUpperLimit && secondLowerLimit <= minLimit){
						point = list.get(i);
					}
				}
			}
			if(point.getY() - point.getDiff() > minLimit){
				return -1l;
			}
			return countStones(list, point.getY() + point.getDiff(), max, count + 1);
		}
	}

	static class Point {
		private Long x;
		private Long y;
		private Long diff;

		public Long getX() {
			return x;
		}

		public void setX(Long x) {
			this.x = x;
		}

		public Long getY() {
			return y;
		}

		public void setY(Long y) {
			this.y = y;
		}

		public Long getDiff() {
			return diff;
		}

		public void setDiff(Long diff) {
			this.diff = diff;
		}

		public Point(Long x, Long y, Long diff) {
			super();
			this.x = x;
			this.y = y;
			this.diff = diff;
		}

		@Override
		public String toString() {
			return "Point [x=" + x + ", y=" + y + ", diff=" + diff + "]";
		}

	}

}
