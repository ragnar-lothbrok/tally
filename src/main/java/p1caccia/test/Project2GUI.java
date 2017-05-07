package p1caccia.test;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Project2GUI {

	WordNode[] wordNodes = null;
	WordNode[] unSortedWordNodes = null;
	WordList wordList = new WordList();

	public static void main(String[] args) throws IOException {

		JFrame mainFrame = new JFrame("Java Swing Examples");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});

		JTextArea list = new JTextArea();
		JTextArea sorted = new JTextArea();
		JTextArea unsorted = new JTextArea();

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());

		mainFrame.add(list);
		mainFrame.add(controlPanel);
		mainFrame.add(sorted);
		mainFrame.add(unsorted);
		mainFrame.setVisible(true);

		Project2GUI project = new Project2GUI();
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(
				new FileReader("/home/raghunandangupta/mygit/tally/src/main/java/p1caccia/test/abc.txt"));
		String line = br.readLine();
		while (line != null) {
			project.addList(new String[] { line });
			project.addToArray(new String[] { line });
			project.addUnsortedToArray(new String[] { line });
			line = br.readLine();
		}

		list.setText("List : \n" + project.getList().toString());
		sorted.setText("Sorted : \n" + Arrays.asList(project.getArray()).toString());
		unsorted.setText("unsorted : \n" + Arrays.asList(project.getUnsortedArray()).toString());

		int choice = 0;
		while (choice != 7) {
			choice = Integer
					.parseInt(JOptionPane.showInputDialog("Please select your choice from these available options:"
							+ "\n1. ADD" + "\n2. DELETE" + "\nEnter 3 to STOP"));
			switch (choice) {
			case 1:
				String values = JOptionPane.showInputDialog("Enter values [ADD A,B,C]: ");
				project.addList(values.split(" ")[1].split(","));
				project.addToArray(values.split(" ")[1].split(","));
				project.addUnsortedToArray(values.split(" ")[1].split(","));
				list.setText("List : \n" + project.getList().toString());
				sorted.setText("Sorted : \n" + Arrays.asList(project.getArray()).toString());
				unsorted.setText("unsorted : \n" + Arrays.asList(project.getUnsortedArray()).toString());
				break;
			case 2:
				values = JOptionPane.showInputDialog("Enter values [DELETE A]: ");
				project.deleteFromList(values.split(" ")[1].split(",")[0]);
				project.deleteFromArray(values.split(" ")[1].split(",")[0]);
				project.deleteFromUnsortedArray(values.split(" ")[1].split(",")[0]);
				list.setText("List : \n" + project.getList().toString());
				sorted.setText("Sorted : \n" + Arrays.asList(project.getArray()).toString());
				unsorted.setText("unsorted : \n" + Arrays.asList(project.getUnsortedArray()).toString());
				break;

			case 3:
				System.exit(0);
			}
		}
	}

	/**
	 * List
	 * 
	 * @param value
	 */
	public void addList(String value[]) {
		if (value != null) {
			for (String item : value) {
				wordList.getList().add(new WordNode(item));
			}
		}
	}

	public List<WordNode> getList() {
		wordList.getList().sort(Comparator.comparing(WordNode::getWord));
		return wordList.getList();
	}

	public void deleteFromList(String value) {
		WordNode wordNode = new WordNode(value);
		wordList.getList().remove(wordNode);
	}

	/**
	 * Sorted Array
	 * 
	 * @param value
	 */
	public void addToArray(String value[]) {
		if (value != null) {
			if (wordNodes == null) {
				List<WordNode> tempList = new ArrayList<WordNode>();
				for (String item : value) {
					tempList.add(new WordNode(item));
				}
				wordNodes = new WordNode[tempList.size()];
				tempList.toArray(wordNodes);
			} else {
				WordNode[] arr = new WordNode[wordNodes.length + value.length];
				int i = 0;
				while (i < wordNodes.length) {
					arr[i] = wordNodes[i];
					i++;
				}
				int j = 0;
				while (j < value.length) {
					arr[i] = new WordNode(value[j]);
					i++;
					j++;
				}
				wordNodes = arr;
			}
		}
	}

	public WordNode[] getArray() {
		if (wordNodes != null) {
			Arrays.sort(wordNodes);
		}
		return wordNodes;
	}

	public void deleteFromArray(String value) {
		int count = 0;
		if (wordNodes != null && value != null) {
			for (int i=0;i<wordNodes.length;i++) {
				if (wordNodes[i].getWord().equals(value)) {
					count++;
					wordNodes[i] = null;
				}
			}
			WordNode[] arr = new WordNode[wordNodes.length - count];
			int i = 0;
			int j = 0;
			while (i < arr.length) {
				if(wordNodes[j] != null){
					arr[i] = wordNodes[j];
					i++;
				}
				j++;
			}
			wordNodes = arr;
		}
	}

	/**
	 * For unsorted
	 * 
	 * @param value
	 */
	public void addUnsortedToArray(String value[]) {
		if (value != null) {
			if (unSortedWordNodes == null) {
				List<WordNode> tempList = new ArrayList<WordNode>();
				for (String item : value) {
					tempList.add(new WordNode(item));
				}
				unSortedWordNodes = new WordNode[tempList.size()];
				tempList.toArray(unSortedWordNodes);
			} else {
				WordNode[] arr = new WordNode[unSortedWordNodes.length + value.length];
				int i = 0;
				while (i < unSortedWordNodes.length) {
					arr[i] = unSortedWordNodes[i];
					i++;
				}
				int j = 0;
				while (j < value.length) {
					arr[i] = new WordNode(value[j]);
					i++;
					j++;
				}
				unSortedWordNodes = arr;
			}
		}
	}

	public WordNode[] getUnsortedArray() {
		return unSortedWordNodes;
	}

	public void deleteFromUnsortedArray(String value) {
		int count = 0;
		if (unSortedWordNodes != null && value != null) {
			for (int i=0;i<unSortedWordNodes.length;i++) {
				if (unSortedWordNodes[i].getWord().equals(value)) {
					count++;
					unSortedWordNodes[i] = null;
				}
			}
			WordNode[] arr = new WordNode[unSortedWordNodes.length - count];
			int i = 0;
			int j = 0;
			while (i < arr.length) {
				if(unSortedWordNodes[j] != null){
					arr[i] = unSortedWordNodes[j];
					i++;
				}
				j++;
			}
			unSortedWordNodes = arr;
		}
	}
}
