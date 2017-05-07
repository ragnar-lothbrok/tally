import java.util.HashMap;

public class MyFirstClass {

	private HashMap<Integer, String> hmap = new HashMap<Integer, String>() {

		{
			hmap.put(4, "John");
			hmap.put(3, "Klay");
			hmap.put(1, "Deena");
		}
	};

	public HashMap<Integer, String> gethmap() {
		return this.hmap;
	}

	public void sethmap(HashMap<Integer, String> hmap) {
		this.hmap = hmap;
	}

}
