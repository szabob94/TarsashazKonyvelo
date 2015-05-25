package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Control.StatisztikaServices;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

import java.awt.Component;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TarsashazStatisztika extends JPanel {
	
	private static Logger	logger = LoggerFactory.getLogger(TarsashazStatisztika.class);
	List<Tarsashaz> tarsashazak;
	List<Lakas> lakasok;
	JLabel lblTrsashzszm;
	JLabel lblLaksszm;
	JLabel lbltlagtartozs;
	JLabel lblMaxtartozas;
	JLabel lblssztartozs;
	
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
	 * Create the panel.
	 */
	public TarsashazStatisztika(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		JLabel lblTrsashzakSzma = new JLabel("Társasházak száma");
		lblTrsashzakSzma.setBounds(107, 94, 126, 23);
		add(lblTrsashzakSzma);
		
		lblTrsashzszm = new JLabel("TársasházSzám");
		lblTrsashzszm.setBounds(267, 94, 105, 23);
		add(lblTrsashzszm);
		
		JLabel lblLaksokSzma = new JLabel("Lakások száma");
		lblLaksokSzma.setBounds(107, 140, 126, 23);
		add(lblLaksokSzma);
		
		lblLaksszm = new JLabel("LakásSzám");
		lblLaksszm.setBounds(267, 140, 87, 23);
		add(lblLaksszm);
		
		JLabel lbltlagTartozs = new JLabel("Átlag tartozás");
		lbltlagTartozs.setBounds(107, 188, 126, 23);
		add(lbltlagTartozs);
		
		lbltlagtartozs = new JLabel("ÁtlagTartozás");
		lbltlagtartozs.setBounds(267, 188, 87, 23);
		add(lbltlagtartozs);
		
		JLabel lblLegmagasabbTartozs = new JLabel("Legmagasabb Tartozás");
		lblLegmagasabbTartozs.setBounds(107, 238, 126, 29);
		add(lblLegmagasabbTartozs);
		
		lblMaxtartozas = new JLabel("MaxTartozas");
		lblMaxtartozas.setBounds(267, 241, 92, 23);
		add(lblMaxtartozas);
		
		JLabel lblsszesTartozs = new JLabel("Összes tartozás");
		lblsszesTartozs.setBounds(107, 290, 126, 23);
		add(lblsszesTartozs);
		
		lblssztartozs = new JLabel("Össztartozás");
		lblssztartozs.setBounds(267, 292, 87, 19);
		add(lblssztartozs);
		
		JButton btnNewButton = new JButton("Vissza");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Statisztika");
				ActivateLayer(12, layeredPane);
			}
		});
		btnNewButton.setBounds(388, 11, 126, 44);
		add(btnNewButton);
	}
	
	public void setStatisztika(){
		logger.info("Adatok feltöltése");
		LekeroServices ls = new LekeroServices();
		tarsashazak=ls.getTarsashazak();
		lakasok=ls.getLakasok();
		StatisztikaServices ss = new StatisztikaServices();
		lblTrsashzszm.setText(ss.tarsashazakSzama(tarsashazak)+"");
		lblLaksszm.setText(ss.lakasokSzama(lakasok)+"");
		lbltlagtartozs.setText(ss.atlagTartozas(tarsashazak)+" Ft");
		lblMaxtartozas.setText(ss.maxTartozas(tarsashazak)+" Ft");
		lblssztartozs.setText(ss.osszTartozas(tarsashazak)+" Ft");
	}

}
