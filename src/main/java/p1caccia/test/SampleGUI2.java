package p1caccia.test;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class SampleGUI2 {

	private final JPanel gui = new JPanel(new BorderLayout(3, 3));
	private static JButton[][] simpleSquare = new JButton[7][7];
	private JPanel chessBoard;
	final static int[] currPos = { 3, 3 };

	SampleGUI2() {
		initializeGui();
	}

	public final void initializeGui() {
		// set up the main GUI
		gui.setBorder(new EmptyBorder(5, 5, 5, 5));
		JToolBar tools = new JToolBar();
		tools.setFloatable(false);
		gui.add(tools, BorderLayout.PAGE_START);

		chessBoard = new JPanel(new GridLayout(0, 7)) {

			private static final long serialVersionUID = 1L;

			/**
			 * Override the preferred size to return the largest it can, in a
			 * square shape. Must (must, must) be added to a GridBagLayout as
			 * the only component (it uses the parent as a guide to size) with
			 * no GridBagConstaint (so it is centered).
			 */
			@Override
			public final Dimension getPreferredSize() {
				Dimension d = super.getPreferredSize();
				Dimension prefSize = null;
				Component c = getParent();
				if (c == null) {
					prefSize = new Dimension((int) d.getWidth(), (int) d.getHeight());
				} else if (c != null && c.getWidth() > d.getWidth() && c.getHeight() > d.getHeight()) {
					prefSize = c.getSize();
				} else {
					prefSize = d;
				}
				int w = (int) prefSize.getWidth();
				int h = (int) prefSize.getHeight();
				// the smaller of the two sizes
				int s = (w > h ? h : w);
				return new Dimension(s, s);
			}
		};
		chessBoard.setBorder(new CompoundBorder(new EmptyBorder(7, 7, 7, 7), new LineBorder(Color.BLACK)));
		// Set the BG to be ochre
		Color ochre = new Color(204, 119, 34);
		chessBoard.setBackground(ochre);
		JPanel boardConstrain = new JPanel(new GridBagLayout());
		boardConstrain.setBackground(ochre);
		boardConstrain.add(chessBoard);
		gui.add(boardConstrain);
		// create the chess board squares
		Insets buttonMargin = new Insets(0, 0, 0, 0);
		for (int ii = 0; ii < simpleSquare.length; ii++) {
			for (int jj = 0; jj < simpleSquare[ii].length; jj++) {
				JButton b = new JButton();
				b.setMargin(buttonMargin);
				// our chess pieces are 64x64 px in size, so we'll
				// 'fill this in' using a transparent icon..
				ImageIcon icon = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
				b.setIcon(icon);
				b.setBackground(Color.WHITE);
				if (ii == jj && ii == 3) {
					b.setBackground(Color.BLACK);
				}
				simpleSquare[jj][ii] = b;
			}
		}
		// fill the black non-pawn piece row
		for (int ii = 0; ii < 7; ii++) {
			for (int jj = 0; jj < 7; jj++) {
				chessBoard.add(simpleSquare[jj][ii]);
			}
		}
	}

	public final JComponent getGui() {
		return gui;
	}

	public static void main(String[] args) {

		testForLoop();
		if (true) {
			return;
		}
		Runnable r = new Runnable() {

			@Override
			public void run() {
				SampleGUI2 cg = new SampleGUI2();

				JFrame f = new JFrame("ChessChamp");
				f.add(cg.getGui());
				// Ensures JVM closes after frame(s) closed and
				// all non-daemon threads are finished
				f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				// See http://stackoverflow.com/a/7143398/418556 for demo.
				f.setLocationByPlatform(true);
				// ensures the frame is the minimum size it needs to be
				// in order display the components within it
				f.pack();
				// ensures the minimum size is enforced.
				f.setMinimumSize(f.getSize());
				f.setVisible(true);
			}
		};
		// Swing GUIs should be created and updated on the EDT
		// http://docs.oracle.com/javase/tutorial/uiswing/concurrency
		SwingUtilities.invokeLater(r);

		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			public void eventDispatched(AWTEvent event) {
				if (event.getID() == KeyEvent.KEY_PRESSED) {
					KeyEvent e = (KeyEvent) event;
					for (int ii = 0; ii < 7; ii++) {
						for (int jj = 0; jj < 7; jj++) {
							simpleSquare[jj][ii].setBackground(Color.white);
						}
					}
					int keyCode = e.getKeyCode();
					switch (keyCode) {
					case KeyEvent.VK_UP:
						if (currPos[1] != 0) {
							currPos[0] = currPos[0];
							currPos[1] = currPos[1] - 1;
						}
						break;
					case KeyEvent.VK_RIGHT:
						if (currPos[0] != 6) {
							currPos[0] = currPos[0] + 1;
							currPos[1] = currPos[1];
						}
						break;
					case KeyEvent.VK_LEFT:
						if (currPos[0] != 0) {
							currPos[0] = currPos[0] - 1;
							currPos[1] = currPos[1];
						}
						break;
					case KeyEvent.VK_DOWN:
						if (currPos[1] != 6) {
							currPos[0] = currPos[0];
							currPos[1] = currPos[1] + 1;
						}
						break;
					}
					simpleSquare[currPos[0]][currPos[1]].setBackground(Color.BLACK);
				}
			}
		}, AWTEvent.KEY_EVENT_MASK);
	}

	public static void testForLoop() {
		String syntax = "for (int jj=0; jj!=7; jj++)";
		String str[] = new String[4];
		int index[] = new int[4];
		for (int i = 0; i < syntax.length(); i++) {

			// For substring 1
			if (syntax.charAt(i) == '(') {
				str[0] = syntax.substring(0, i).trim();
				index[0] = i + 1;
			}

			// For substring 2
			if (syntax.charAt(i) == ';' && str[1] == null) {
				str[1] = syntax.substring(index[0], i).trim();
				index[1] = i;
			}
			// For substring 3
			else if (syntax.charAt(i) == ';' && str[1] != null) {
				str[2] = syntax.substring(index[1] + 1, i).trim();
				index[2] = i;
			}

			// For substring 4
			if (syntax.charAt(i) == ')' && str[3] == null) {
				str[3] = syntax.substring(index[2] + 1, i).trim();
				index[3] = i;
			}
		}

		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
		}
		validate(str);
	}

	public static void validate(String values[]) {
		
		//for
		if (!(values[0] != null && "for".equals(values[0]))) {
			System.out.println("Invalid substring1");
			return;
		}
		
		//int jj=0
		if (values[1] != null) {
			String str[] = values[1].split(" ");
			//Here we are checking for "int" after that some characters should be present
			if (str.length == 2 && str[0].trim().equals("int")) {
				String temp[] = str[1].split("=");
				if (temp.length == 2 && temp[0].toLowerCase().charAt(0) >= 'a' && temp[0].toLowerCase().charAt(0) <= 'z'
						&& temp[1].trim().length() > 0) {

				} else {
					System.out.println("Invalid substring2");
					return;
				}
			} else {
				System.out.println("Invalid substring2");
				return;
			}
		} else {
			System.out.println("Invalid substring2");
			return;
		}
		
		//Here we are for != and some characters jj!=7
		if (values[2] != null) {
			String temp[] = values[2].split("!=");
			if (temp.length == 2 && temp[0].toLowerCase().charAt(0) >= 'a' && temp[0].toLowerCase().charAt(0) <= 'z'
					&& temp[1].trim().length() > 0) {

			} else {
				System.out.println("Invalid substring3");
				return;
			}
		} else {
			System.out.println("Invalid substring3");
			return;
		}

		//jj++
		if (values[3] != null) {
			String temp[] = values[3].split("/++");
			if (temp.length != 2) {
				temp = values[3].split("/--");
				if (temp[0].trim().toLowerCase().charAt(0) >= 'a' && temp[0].trim().toLowerCase().charAt(0) <= 'z') {

				} else {
					System.out.println("Invalid substring4");
					return;
				}
			} else if (temp[0].trim().toLowerCase().charAt(0) >= 'a' && temp[0].trim().toLowerCase().charAt(0) <= 'z') {

			} else {
				System.out.println("Invalid substring4");
				return;
			}
		} else {
			System.out.println("Invalid substring4");
			return;
		}

		System.out.println("Valid for loop.");
	}
}