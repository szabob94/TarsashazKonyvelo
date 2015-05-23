package hu.unideb.inf.konyvelo;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class Main2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main2 window = new Main2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void ActivateLayer(int i, JLayeredPane layeredPane) {

		for (Component component : layeredPane.getComponents()) {
			if (component.equals(layeredPane.getComponentsInLayer(i)[0]))
				component.setVisible(true);
			else {
				component.setVisible(false);
			}
		}
	}

	/**
	 * Create the application.
	 */
	public Main2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLayeredPane layeredPane = new JLayeredPane();
		frame.getContentPane().add(layeredPane, BorderLayout.CENTER);

		InsertTranzakcioL insertTranzakcioL = new InsertTranzakcioL();
		layeredPane.add(insertTranzakcioL);
		layeredPane.setLayer(insertTranzakcioL, 0);
		InsertTranzakcioT insertTranzakcioT = new InsertTranzakcioT();
		layeredPane.add(insertTranzakcioT);
		layeredPane.setLayer(insertTranzakcioT, 1);
		ActivateLayer(1, layeredPane);
	}
}
