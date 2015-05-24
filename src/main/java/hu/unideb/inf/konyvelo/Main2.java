package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.ElosztoServices;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;

import java.awt.BorderLayout;
import java.util.List;

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
		

		ModositTranzakcioL insertTranzakcioL = new ModositTranzakcioL();
		layeredPane.add(insertTranzakcioL);
		layeredPane.setLayer(insertTranzakcioL, 0);
		ModositTranzakcioT insertTranzakcioT = new ModositTranzakcioT();
		layeredPane.add(insertTranzakcioT);
		layeredPane.setLayer(insertTranzakcioT, 1);
		ModositTarsashaz insertTarsashaz = new ModositTarsashaz();
		layeredPane.add(insertTarsashaz);
		layeredPane.setLayer(insertTarsashaz, 2);
		ModositLakas insertLakas = new ModositLakas();
		layeredPane.add(insertLakas);
		layeredPane.setLayer(insertLakas, 3);
		Kioszt kioszt = new Kioszt();
		layeredPane.add(kioszt);
		layeredPane.setLayer(kioszt, 4);
		ActivateLayer(4, layeredPane);
	}
}
