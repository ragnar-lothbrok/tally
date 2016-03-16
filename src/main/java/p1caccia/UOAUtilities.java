package p1caccia;

public class UOAUtilities {
	private int next;
	private int size;
	private StudentListing[] data;

	public UOAUtilities() {
		next = 0;

		size = 100;

		data = new StudentListing[size];
	}

	public UOAUtilities(int s) {
		next = 0;
		data = new StudentListing[s];
		size = s;
	}

	public boolean insert(StudentListing newStudentListing) {
		if (next >= size) {
			return false;
		}

		data[next] = newStudentListing.deepCopy();
		if (data[next] == null)
			return false;
		next = next + 1;
		return true;
	}

	public StudentListing fetch(String targetKey) {
		StudentListing studentListing;
		StudentListing temp;
		int i = 0;
		while (i < next && !(data[i].compareTo(targetKey) == 0)) {
			i++;
		}

		if (i == next)
			return null;

		studentListing = data[i].deepCopy();
		if (i != 0) {
			temp = data[i - 1];
			data[i - 1] = data[i];
			data[i] = temp;
		}
		return studentListing;

	}

	public boolean delete(String targetKey) {
		if (next == 0)
			return false;
		data[--next] = null;
		return true;
	}

	public boolean update(String targetKey, StudentListing newStudentListing)

	{
		for (int i = 0; i < data.length; i++) {
			if (data[i] != null) {
				if (data[i].getIdNumber() != null && data[i].getIdNumber().equalsIgnoreCase(targetKey)) {
					data[i] = newStudentListing.deepCopy();
					return true;
				}
			}
		}
		return false;
	}

	public void showAll()

	{
		for (int i = 0; i < next; i++)
			System.out.println(data[i].toString());
	}

	public boolean expand()

	{
		int count = (int) (size * .2);
		StudentListing[] studentTemp = new StudentListing[count + size];
		for (int i = 0; i < size; i++) {
			if (data[i] == null) {
				break;
			}
			studentTemp[i] = data[i].deepCopy();
		}
		size = studentTemp.length;
		data = studentTemp;
		return true;

	}
}