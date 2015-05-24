package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
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
		
		ModositTranzakcioL insertTranzakcioL = new ModositTranzakcioL(layeredPane);
		layeredPane.add(insertTranzakcioL);
		layeredPane.setLayer(insertTranzakcioL, 3);
		ModositTranzakcioT insertTranzakcioT = new ModositTranzakcioT(layeredPane);
		layeredPane.add(insertTranzakcioT);
		layeredPane.setLayer(insertTranzakcioT, 4);
		ModositTarsashaz insertTarsashaz = new ModositTarsashaz(layeredPane);
		layeredPane.add(insertTarsashaz);
		layeredPane.setLayer(insertTarsashaz, 7);
		ModositLakas insertLakas = new ModositLakas(layeredPane);
		layeredPane.add(insertLakas);
		layeredPane.setLayer(insertLakas, 2);
		Kioszt kioszt = new Kioszt(layeredPane);
		layeredPane.add(kioszt);
		layeredPane.setLayer(kioszt, 5);
		TranzakcioLVegrehajt vegrehajt = new TranzakcioLVegrehajt(layeredPane);
		layeredPane.add(vegrehajt);
		layeredPane.setLayer(vegrehajt, 6);
		TarsashazLista tarsashazLista = new TarsashazLista(layeredPane);
		layeredPane.add(tarsashazLista);
		layeredPane.setLayer(tarsashazLista, 8);
		LakasLista lakasLista = new LakasLista(layeredPane);
		layeredPane.add(lakasLista);
		layeredPane.setLayer(lakasLista, 9);
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 0, 584, 411);
		layeredPane.add(menu);
		layeredPane.setLayer(menu, 0);
		menu.setLayout(null);
		
		JButton btnNewButton = new JButton("Adatok módosítása/felvétele");
		btnNewButton.setBounds(146, 42, 287, 54);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(1, layeredPane);
			}
		});
		menu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Statisztikák");
		btnNewButton_1.setBounds(146, 305, 287, 54);
		menu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Társasházak megtekintése");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LekeroServices ls = new LekeroServices();
				tarsashazLista.setTarsashazList(ls.getTarsashazak());
				ActivateLayer(8, layeredPane);
			}
		});
		btnNewButton_2.setBounds(146, 135, 287, 54);
		menu.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Lakások megtekintése");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LekeroServices ls = new LekeroServices();
				lakasLista.setLakasList(ls.getLakasok());
				ActivateLayer(9, layeredPane);
			}
		});
		btnNewButton_3.setBounds(146, 221, 287, 54);
		menu.add(btnNewButton_3);
		
		JPanel modosit = new JPanel();
		modosit.setBounds(0, 0, 584, 411);
		layeredPane.add(modosit);
		layeredPane.setLayer(modosit, 1);
		modosit.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Társasház hozzáadása/módosítása");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(7, layeredPane);
			}
		});
		btnNewButton_4.setBounds(142, 25, 319, 32);
		modosit.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Lakás hozzáadása/módosítása");
		btnNewButton_5.setBounds(142, 82, 319, 32);
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(2, layeredPane);
			}
		});
		modosit.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Társasház tranzakció hozzáadása");
		btnNewButton_6.setBounds(142, 137, 319, 32);
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(4, layeredPane);
			}
		});
		modosit.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Lakás tranzakció hozzáadása");
		btnNewButton_7.setBounds(142, 188, 319, 32);
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(3, layeredPane);
			}
		});
		modosit.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Lakás tranzakció végrehajtása");
		btnNewButton_8.setBounds(142, 242, 319, 32);
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(6, layeredPane);
			}
		});
		modosit.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Társasház tranzakció végrehajtása");
		btnNewButton_9.setBounds(142, 293, 319, 32);
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(5, layeredPane);
			}
		});
		modosit.add(btnNewButton_9);
		
		JButton btnVissza = new JButton("Vissza");
		btnVissza.setBounds(142, 343, 319, 32);
		btnVissza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(0, layeredPane);
			}
		});
		modosit.add(btnVissza);
		ActivateLayer(0, layeredPane);

	}
}
