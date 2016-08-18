import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
//http://nerdanswer.com/answer.php?q=1247097
public class MetroMap {

	public static class Station {
		public String Name;
		public String No;
		public int Color;
		public int IsCircular;
		public int IsVisited;
		public int IsNew;
		public ArrayList<Child> childs;

		public Station(String name, String no, int color) {
			Name = name;
			No = no;
			Color = color;
			IsCircular = 0;
			IsVisited = 0;
			IsNew = 1;
			childs = new ArrayList<Child>();
		}
	}

	public static class Child {
		public Station Point;
		public int IsShift;
		public int Cost;

		public Child(Station s, int sh, int c) {
			Point = s;
			IsShift = sh;
			Cost = c;
		}
	}

	public static class Path {
		public int cost;
		public Station Start;
		public Station End;
		public int IsShift;

		public Path(int c, Station s, Station e, int shift) {
			cost = c;
			Start = s;
			End = e;
			IsShift = shift;
		}
	}

	public static class TravelPath {
		public int Cost;
		public int Shifts;
		public int Waits;
		public int Halts;
		public ArrayList<Path> Paths;

		public TravelPath() {
			Cost = Shifts = Waits = Halts = 0;
			Paths = new ArrayList<Path>();
		}

		public int CompareTo(TravelPath obj) {
			if (this.Cost > obj.Cost)
				return 1;
			else if (this.Cost == obj.Cost) {
				if (this.Shifts > obj.Shifts)
					return 1;
				else if (this.Shifts == obj.Shifts) {
					if (this.Waits > obj.Waits)
						return 1;
				}
			}
			return 0;
		}
	}

	private static TravelPath MinPath;
	private static TravelPath CurrentPath;
	private static int[] Visited = new int[] { 0, 0, 0, 0 };

	private static Map<String, Station> TrainStations;

	public static Station ReadOrAddStation(int color, String no) {
		String key = Integer.toString(color) + no;
		if (TrainStations.containsKey(key)) {
			Station itm = (Station) TrainStations.get(key);
			itm.IsNew = 0;
			return itm;
		} else {
			Station itm = new Station(key, no, color);
			TrainStations.put(key, itm);
			return itm;
		}
	}

	public static Station ReadStation(int color, String no) {
		String key = Integer.toString(color) + no;
		if (TrainStations.containsKey(key))
			return (Station) TrainStations.get(key);
		else
			return null;
	}

	public static void Rec(Station s, Child c, String dest) {
		CurrentPath.Cost += c.Cost;
		CurrentPath.Shifts += ((c.IsShift == 1) ? 1 : 0);
		CurrentPath.Halts += ((c.IsShift == 1) ? 0 : 1);
		CurrentPath.Waits += ((c.Point.IsCircular == 1) ? 1 : 0);
		CurrentPath.Paths.add(new Path(c.Cost, s, c.Point, c.IsShift));
		c.Point.IsVisited = 1;
		Visited[c.Point.Color] += 1;
		// System.out.println("Name:" + c.Point.Name);
		if (c.Point.No.equals(dest)) {
			// System.out.println("Destination:" + c.Point.No);
			int d = MinPath.CompareTo(CurrentPath);
			// System.out.println(d);
			if (d != 0) {
				MinPath.Cost = CurrentPath.Cost;
				MinPath.Halts = CurrentPath.Halts;
				MinPath.Waits = CurrentPath.Waits;
				MinPath.Shifts = CurrentPath.Shifts;
				MinPath.Paths = new ArrayList<Path>();
				for (Path itm : CurrentPath.Paths) {
					MinPath.Paths.add(itm);
				}
			}
		} else {
			for (Child cd : c.Point.childs) {
				if ((cd.Point.IsVisited == 0)
						&& ((Visited[cd.Point.Color] < 1) || ((Visited[cd.Point.Color] > 0) && (cd.Point.Color == c.Point.Color))))
					Rec(c.Point, cd, dest);
			}
		}
		CurrentPath.Cost -= c.Cost;
		CurrentPath.Shifts -= ((c.IsShift == 1) ? 1 : 0);
		CurrentPath.Halts -= ((c.IsShift == 1) ? 0 : 1);
		CurrentPath.Waits -= ((c.Point.IsCircular == 1) ? 1 : 0);
		CurrentPath.Paths.remove(CurrentPath.Paths.size() - 1);
		Visited[c.Point.Color] -= 1;
		c.Point.IsVisited = 0;

	}

	public static String[] quickestroute(String[] input1, String input2) {
		// Write code here
		String[] output = { "NC", "NC", "NC", "NC" };
		String[] Rt = input2.split("#");
		TrainStations = new HashMap<String, Station>();
		for (int i = 0; i < 4; i++) {
			String[] da = input1[i].split("#");
			for (int j = 0; j < da.length; j++) {
				String[] data = da[j].split("-");
				int c = Integer.parseInt(data[2]);
				// System.out.println(c);
				Station s = ReadOrAddStation(i, data[0]), e = ReadOrAddStation(i, data[1]);
				s.childs.add(new Child(e, 0, c));
				e.childs.add(new Child(s, 0, c));
				for (int k = 0; k < i; k++) {
					if (s.IsNew == 1) {
						Station d = ReadStation(k, data[0]);
						if (d != null) {
							d.childs.add(new Child(s, 1, 30));
							s.childs.add(new Child(d, 1, 30));
						}
					}
					if (e.IsNew == 1) {
						Station d1 = ReadStation(k, data[1]);
						if (d1 != null) {
							d1.childs.add(new Child(e, 1, 30));
							e.childs.add(new Child(d1, 1, 30));
						}
					}
				}
			}
		}
		MinPath = new TravelPath();
		MinPath.Cost = 999999;
		for (int i = 0; i < 4; i++) {
			Station start = ReadStation(i, Rt[0]);
			if (start != null) {
				// System.out.println("Name:" + start.Name);
				Visited[0] = Visited[1] = Visited[2] = Visited[3] = 0;
				start.IsVisited = 1;
				Visited[i] = 1;
				for (Child c : start.childs) {
					CurrentPath = new TravelPath();
					Rec(start, c, Rt[1]);
				}
				start.IsVisited = 0;
			}
		}
		for (int i = 0; i < 4; i++) {
			String str = "";
			for (Path p : MinPath.Paths) {
				if (p.IsShift == 0) {
					if (p.Start.Color == i && p.End.Color == i) {
						str += "#" + p.Start.No + "-" + p.End.No + "-" + Integer.toString(p.cost);
					}
				}
			}
			if (str != "")
				str = str.substring(1);
			else
				str = "NC";
			output[i] = str;
		}
		return output;
	}

	public static void main(String[] args) throws java.lang.Exception {
		// your code goes here
		String[] str = { "1-2-30#2-3-25#3-4-30#4-5-45#5-6-30#6-7-15#7-8-60#8-9-40", "10-11-45#11-4-60#4-12-60#12-13-45#13-14-30#14-15-35",
				"1-3-40#3-4-25#4-16-30#16-17-15#17-18-20#18-19-30#19-20-25", "21-12-30#12-17-180#17-22-45" };
		String[] op = quickestroute(str, "12#18");
		for (String s : op)
			System.out.println(s);
	}
}
