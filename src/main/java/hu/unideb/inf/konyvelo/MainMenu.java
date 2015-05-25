package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MainMenu {

	private JFrame frame;
	private static Logger	logger = LoggerFactory.getLogger(MainMenu.class);

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
		
		logger.info("Ablak elkészült");
		
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
		TranzakcioTLista tranzakcioTLista = new TranzakcioTLista(layeredPane);
		layeredPane.add(tranzakcioTLista);
		layeredPane.setLayer(tranzakcioTLista, 11);
		TarsashazLista tarsashazLista = new TarsashazLista(layeredPane, tranzakcioTLista);
		layeredPane.add(tarsashazLista);
		layeredPane.setLayer(tarsashazLista, 8);
		TranzakcioLLista tranzakcioLLista = new TranzakcioLLista(layeredPane);
		layeredPane.add(tranzakcioLLista);
		layeredPane.setLayer(tranzakcioLLista, 10);
		LakasLista lakasLista = new LakasLista(layeredPane,tranzakcioLLista);
		layeredPane.add(lakasLista);
		layeredPane.setLayer(lakasLista, 9);
		TarsashazStatisztika tarsashazStatisztika = new TarsashazStatisztika(layeredPane);
		layeredPane.add(tarsashazStatisztika);
		layeredPane.setLayer(tarsashazStatisztika, 13);
		LakasStatisztika lakasStatisztika = new LakasStatisztika(layeredPane);
		layeredPane.add(lakasStatisztika);
		layeredPane.setLayer(lakasStatisztika, 14);
		RezsiTarsashaz rezsiTarsashaz = new RezsiTarsashaz(layeredPane);
		layeredPane.add(rezsiTarsashaz);
		layeredPane.setLayer(rezsiTarsashaz, 15);
		RezsiLakas rezsiLakas = new RezsiLakas(layeredPane);
		layeredPane.add(rezsiLakas);
		layeredPane.setLayer(rezsiLakas, 16);
		
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
				logger.info("Váltás: Adatok módosítása/ felvétele");
				ActivateLayer(1, layeredPane);
			}
		});
		menu.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Statisztikák");
		btnNewButton_1.setBounds(146, 305, 287, 54);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ActivateLayer(12, layeredPane);
				logger.info("Váltás: Statisztikák");
			}
		});
		menu.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Társasházak megtekintése");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LekeroServices ls = new LekeroServices();
				tarsashazLista.setTarsashazList(ls.getTarsashazak());
				logger.info("Váltás: Társasházak megtekintése");
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
				logger.info("Váltás: Lakások megtekintése");
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
				logger.info("Váltás: Társasház hozzáadása/módosítása");
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
				logger.info("Váltás: Lakás hozzáadása/módosítása");
				ActivateLayer(2, layeredPane);
			}
		});
		modosit.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Társasház tranzakció hozzáadása");
		btnNewButton_6.setBounds(142, 137, 319, 32);
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Társasház tranzakció hozzáadása/módosítása");
				ActivateLayer(4, layeredPane);
			}
		});
		modosit.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Lakás tranzakció hozzáadása");
		btnNewButton_7.setBounds(142, 188, 319, 32);
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Lakás tranzakció hozzáadása/módosítása");
				ActivateLayer(3, layeredPane);
			}
		});
		modosit.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Lakás tranzakció végrehajtása");
		btnNewButton_8.setBounds(142, 242, 319, 32);
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Lakás tranzakció végrehajtása");
				ActivateLayer(6, layeredPane);
			}
		});
		modosit.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Társasház tranzakció végrehajtása");
		btnNewButton_9.setBounds(142, 293, 319, 32);
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Társasház tranzakció végrehajtása");
				ActivateLayer(5, layeredPane);
			}
		});
		modosit.add(btnNewButton_9);
		
		JButton btnVissza = new JButton("Vissza");
		btnVissza.setBounds(142, 343, 319, 32);
		btnVissza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Főmenü");
				ActivateLayer(0, layeredPane);
			}
		});
		
		JPanel statisztika = new JPanel();
		statisztika.setBounds(0, 0, 584, 411);
		layeredPane.add(statisztika);
		layeredPane.setLayer(statisztika, 12);
		statisztika.setLayout(null);
		
		JButton btnTarsashazStatisztika = new JButton("Társasház statisztika");
		btnTarsashazStatisztika.setBounds(142, 50, 319, 32);
		btnTarsashazStatisztika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Társasház statisztika");
				ActivateLayer(13, layeredPane);
				tarsashazStatisztika.setStatisztika();
			}
		});
		statisztika.add(btnTarsashazStatisztika);
		
		JButton btnLakasStatisztika = new JButton("Lakás statisztika");
		btnLakasStatisztika.setBounds(142, 120, 319, 32);
		btnLakasStatisztika.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Lakás statisztika");
				ActivateLayer(14, layeredPane);
				lakasStatisztika.setStatisztika();
			}
		});
		statisztika.add(btnLakasStatisztika);
		
		JButton btnRezsiTarsashaz = new JButton("Rezsicsökkentés társasházra nézve");
		btnRezsiTarsashaz.setBounds(142, 190, 319, 32);
		btnRezsiTarsashaz.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Rezsicsökkentés társasházra nézve");
				ActivateLayer(15, layeredPane);
			}
		});
		statisztika.add(btnRezsiTarsashaz);
		
		JButton btnRezsiLakas = new JButton("Rezsicsökkentés lakásra nézve");
		btnRezsiLakas.setBounds(142, 260, 319, 32);
		btnRezsiLakas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Rezsicsökkentés lakásra nézve");
				ActivateLayer(16, layeredPane);
			}
		});
		statisztika.add(btnRezsiLakas);
		
		JButton btnStatVissza = new JButton("vissza");
		btnStatVissza.setBounds(142, 330, 319, 32);
		btnStatVissza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Főmenü");
				ActivateLayer(0, layeredPane);
			}
		});
		statisztika.add(btnStatVissza);
		
		modosit.add(btnVissza);
		ActivateLayer(0, layeredPane);
		frame.setTitle("Társasházkönyvelő");

	}
}
