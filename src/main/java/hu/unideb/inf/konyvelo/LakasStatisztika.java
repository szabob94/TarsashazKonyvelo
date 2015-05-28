package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Control.StatisztikaServices;
import hu.unideb.inf.konyvelo.DAO.DAOGet;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LakasStatisztika extends JPanel {

	private static Logger	logger = LoggerFactory.getLogger(LakasStatisztika.class);
	List<Tarsashaz> tarsashazak;
	List<Lakas> lakasok;
	JLabel lblTrsashzszm;
	JLabel lbltlagtartozs;
	JLabel lblMaxtartozas;
	JLabel lblssztartozs;
	private JTextField textField;

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
	public LakasStatisztika(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);

		JLabel lblTrsashzakSzma = new JLabel("Lakások száma");
		lblTrsashzakSzma.setBounds(107, 94, 126, 23);
		add(lblTrsashzakSzma);

		lblTrsashzszm = new JLabel("LakásSzám");
		lblTrsashzszm.setBounds(267, 94, 105, 23);
		add(lblTrsashzszm);

		JLabel lbltlagTartozs = new JLabel("Átlag tartozás");
		lbltlagTartozs.setBounds(107, 159, 126, 23);
		add(lbltlagTartozs);

		lbltlagtartozs = new JLabel("ÁtlagTartozás");
		lbltlagtartozs.setBounds(267, 159, 87, 23);
		add(lbltlagtartozs);

		JLabel lblLegmagasabbTartozs = new JLabel("Legmagasabb Tartozás");
		lblLegmagasabbTartozs.setBounds(107, 216, 126, 29);
		add(lblLegmagasabbTartozs);

		lblMaxtartozas = new JLabel("MaxTartozas");
		lblMaxtartozas.setBounds(267, 219, 92, 23);
		add(lblMaxtartozas);

		JLabel lblsszesTartozs = new JLabel("Összes tartozás");
		lblsszesTartozs.setBounds(107, 274, 126, 23);
		add(lblsszesTartozs);

		lblssztartozs = new JLabel("Össztartozás");
		lblssztartozs.setBounds(267, 276, 87, 19);
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

		textField = new JTextField();
		textField.setBounds(193, 23, 86, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnMehet = new JButton("Mehet");
		btnMehet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Adatokkal feltöltve");
				setStatisztika(Integer.parseInt(textField.getText()));
			}
		});
		btnMehet.setBounds(31, 11, 132, 44);
		add(btnMehet);

	}

	public void setStatisztika() {
		LekeroServices ls = new LekeroServices();
		tarsashazak=ls.getTarsashazak();
		lakasok=ls.getLakasok();
		StatisztikaServices ss = new StatisztikaServices();
		lblTrsashzszm.setText(ss.lakasokSzama(lakasok)+"");
		lbltlagtartozs.setText(ss.atlagTartozasLakasok(lakasok)+" Ft");
		lblMaxtartozas.setText(ss.maxTartozasLakas(lakasok)+" Ft");
		lblssztartozs.setText(ss.osszTartozasLakas(lakasok)+" Ft");
	}

	public void setStatisztika(int id) {
		DAOGet get = new DAOGet();
		tarsashazak=get.getTarsashazakEgyszeru();
		lakasok=get.getLakasokByTarsashazId(id);
		StatisztikaServices ss = new StatisztikaServices();
		lblTrsashzszm.setText(ss.lakasokSzama(lakasok)+"");
		lbltlagtartozs.setText(ss.atlagTartozasLakasok(lakasok)+" Ft");
		lblMaxtartozas.setText(ss.maxTartozasLakas(lakasok)+" Ft");
		lblssztartozs.setText(ss.osszTartozasLakas(lakasok)+" Ft");
	}

}
