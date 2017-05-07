package p1caccia;

/*
    Grade = 70%: Please see me if you would lik to fix this with my help
        expand is not correct, and the client should not be invoking it
                 insert should invoke it -15%
        Line 29 should not end in a ;, it should not contain !, and it suould not 
                make a deep copy -5%
        you have to let the user know if an operation was successful or what went wrong
        e.g., on a delete: "Jones not in the structure" or "Jones deleted" -10%
*/
import javax.swing.JOptionPane;

public class P1Caccia {
	public static void main(String[] args) {
		String max;
		max = JOptionPane.showInputDialog("How many nodes will be in the structure?");

		StudentListing s = new StudentListing();
		UOAUtilities ds = new UOAUtilities(Integer.parseInt(max));
		int n = Integer.parseInt(JOptionPane.showInputDialog("How many students will be input?"));

		for (int i = 0; i < n; i++) {
			s.input();
			if (!ds.insert(s.deepCopy()))
			{
				System.out.println("The structure is full, please enter more nodes to continue.");
			}
		}

		int choice = 0;
		while (choice != 7) {
			choice = Integer
					.parseInt(JOptionPane.showInputDialog("Please select your choice from these available options:"
							+ "\nEnter 1 to Insert New Student Information" + "\nEnter 2 to Fetch a Student"
							+ "\nEnter 3 to Delete a Student" + "\nEnter 4 to Update a Student"
							+ "\nEnter 5 to Display all Students" + "\nEnter 6 to Expand the Size"
							+ "\nEnter 7 to Exit"));

			switch (choice) {
			case 1:
				try {
					s.input();

					ds.insert(s);
					JOptionPane.showMessageDialog(null, "Operation successfull.", null,
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Operation failed.", null, JOptionPane.ERROR_MESSAGE);
				}

				break;

			case 2:

				s = ds.fetch(JOptionPane.showInputDialog("Please Enter the Student's Name to be Fetched: "));

				System.out.println(s);

				break;

			case 3:

				try {

					ds.delete(max);
					JOptionPane.showMessageDialog(null, "Operation successfull.", null,
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Operation failed.", null, JOptionPane.ERROR_MESSAGE);
				}

				break;

			case 4:
				try {
					String targetKey = JOptionPane.showInputDialog("Student to be Updated");

					s.input();

					ds.update(targetKey, s.deepCopy());
					JOptionPane.showMessageDialog(null, "Operation successfull.", null,
							JOptionPane.INFORMATION_MESSAGE);
				} catch (Exception exception) {
					JOptionPane.showMessageDialog(null, "Operation failed.", null, JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 5:

				ds.showAll();

				break;

			case 6:

				ds.expand();

				break;

			case 7:

				System.exit(0);

			default:

				break;

			}

		}

	}
}