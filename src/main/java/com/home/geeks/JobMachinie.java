package com.home.geeks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JobMachinie {

	public static void main(String[] args) {

		String[] jobs = { "6AM#8AM", "11AM#1PM", "7AM#3PM", "7AM#10AM", "10AM#12PM", "2PM#4PM", "1PM#4PM", "8AM#9AM" };

		List<Time> list = new ArrayList<Time>();
		String[] split = null;
		for (String job : jobs) {
			split = job.split("#");
			Time time = new Time();
			if (split[0].contains("PM")) {
				split[0] = split[0].replace("AM", "");
				split[0] = split[0].replace("PM", "");
				time.setStartTime(Integer.parseInt(split[0]) + 12);
				time.setStart(false);
			} else {
				time.setStartTime(Integer.parseInt(split[0]));
				time.setStart(true);
			}

			if (split[1].contains("PM")) {
				split[1] = split[1].replace("AM", "");
				split[1] = split[1].replace("PM", "");
				time.setEndTime(Integer.parseInt(split[1]) + 12);
				time.setEnd(false);
			} else {
				split[1] = split[1].replace("AM", "");
				split[1] = split[1].replace("PM", "");
				time.setEndTime(Integer.parseInt(split[1]));
				time.setEnd(true);
			}

			split[1] = split[1].replace("AM", "");
			split[1] = split[1].replace("PM", "");
			time.setEndTime(Integer.parseInt(split[1]) + 12);
			list.add(time);
		}

		Collections.sort(list, new Comparator<Time>() {

			@Override
			public int compare(Time o1, Time o2) {
				return (o1.diff().compareTo(o2.diff()));
			}
		});

		List<Time> newList = new ArrayList<Time>();
		for (int i = 0; i < list.size(); i++) {
			Time time = list.get(i);
			boolean isAdd = true;
			for (int j = 0; j < newList.size(); j++) {
				Time temp = newList.get(j);
				if ((time.getStartTime() > temp.getStartTime() && temp.getStartTime() < time.getEndTime())
						||(time.getStartTime() < temp.getEndTime() && temp.getEndTime() < time.getEndTime())) {
					
				}
			}
			if (isAdd) {
				newList.add(time);
			}
		}
		System.out.println(list);

	}

	static class Time {
		private Integer startTime;
		private Integer endTime;
		private Boolean start;
		private Boolean end;

		private Integer diff() {
			if (start && !end) {
				return (12 - startTime + (endTime));
			} else {
				return endTime - startTime;
			}
		}

		public Integer getStartTime() {
			return startTime;
		}

		public void setStartTime(Integer startTime) {
			this.startTime = startTime;
		}

		public Integer getEndTime() {
			return endTime;
		}

		public void setEndTime(Integer endTime) {
			this.endTime = endTime;
		}

		public Boolean getStart() {
			return start;
		}

		public void setStart(Boolean start) {
			this.start = start;
		}

		public Boolean getEnd() {
			return end;
		}

		public void setEnd(Boolean end) {
			this.end = end;
		}

		@Override
		public String toString() {
			return "Time [startTime=" + startTime + ", endTime=" + endTime + ", start=" + start + ", end=" + end + "]";
		}

	}
}
