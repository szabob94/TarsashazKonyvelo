package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.DeleteServices;
import hu.unideb.inf.konyvelo.Control.InsertServices;
import hu.unideb.inf.konyvelo.DAO.DAOInsert;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModositTarsashaz extends JPanel {
	
	private static Logger	logger = LoggerFactory.getLogger(ModositTarsashaz.class);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
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
	public ModositTarsashaz(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		JButton btnNewButton_1 = new JButton("Mégse");
		btnNewButton_1.setBounds(337, 56, 126, 52);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Adatok módosítása/felvétele");
				ActivateLayer(1, layeredPane);
			}
		});
		add(btnNewButton_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(72, 140, 64, 26);
		add(lblId);
		
		textField = new JTextField();
		lblId.setLabelFor(textField);
		textField.setBounds(146, 143, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Társasház címe");
		lblNewLabel.setBounds(34, 180, 102, 35);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		lblNewLabel.setLabelFor(textField_1);
		textField_1.setBounds(146, 183, 305, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTartozs = new JLabel("Tartozás");
		lblTartozs.setBounds(34, 225, 76, 26);
		add(lblTartozs);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 228, 191, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblEmeletSzam = new JLabel("Emeletek száma");
		lblEmeletSzam.setBounds(34, 264, 100, 26);
		add(lblEmeletSzam);
		
		textField_3 = new JTextField();
		textField_3.setBounds(146, 267, 191, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblLakasSzam = new JLabel("Lakások száma");
		lblLakasSzam.setBounds(34, 290, 90, 26);
		add(lblLakasSzam);
		
		textField_4 = new JTextField();
		textField_4.setBounds(146, 293, 191, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Elküld");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tarsashaz tarsashaz = new Tarsashaz();
				tarsashaz.setId(Integer.parseInt(textField.getText()));
				tarsashaz.setCim(textField_1.getText());
				tarsashaz.setTartozas(Integer.parseInt(textField_2.getText()));
				tarsashaz.setEmeletszam(Integer.parseInt(textField_3.getText()));
				tarsashaz.setLakasszam(Integer.parseInt(textField_4.getText()));
				InsertServices inS = new InsertServices();
				inS.insertTarsashaz(tarsashaz);
			}
		});
		btnNewButton.setBounds(72, 56, 126, 52);
		add(btnNewButton);
		
		JButton btnTrlsAzAdatbzisbl = new JButton("Törlés az adatbázisból");
		btnTrlsAzAdatbzisbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tarsashaz tarsashaz = new Tarsashaz();
				tarsashaz.setId(Integer.parseInt(textField.getText()));
				DeleteServices ds = new DeleteServices();
				ds.deleteTarsashaz(tarsashaz);
			}
		});
		btnTrlsAzAdatbzisbl.setBounds(83, 342, 180, 40);
		add(btnTrlsAzAdatbzisbl);

	}

}
