package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.ElosztoServices;
import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.JComboBox;

public class Kioszt extends JPanel {
	private JTextField textField;
	private static Logger	logger = LoggerFactory.getLogger(Kioszt.class);
	private List<TranzakcioT> tranzakciok = new ArrayList<TranzakcioT>();
	private DefaultComboBoxModel<TranzakcioT> box;
	private JComboBox comboBox;
	
	public static void ActivateLayer(int i, JLayeredPane layeredPane) {

		for (Component component : layeredPane.getComponents()) {
			if (component.equals(layeredPane.getComponentsInLayer(i)[0]))
				component.setVisible(true);
			else {
				component.setVisible(false);
			}
		}
	}
	
	public void setKioszt(){
		LekeroServices ls = new LekeroServices();
		tranzakciok=ls.getTranzakcioTk();
		box= new DefaultComboBoxModel<TranzakcioT>();
		for(TranzakcioT tranzakcio : tranzakciok){
			box.addElement(tranzakcio);
		}
		comboBox.setModel(box);
	}

	/**
	 * Create the panel.
	 */
	public Kioszt(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		JButton btnNewButton = new JButton("Elosztás");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ElosztoServices es = new ElosztoServices();
				es.elosztT(((TranzakcioT)comboBox.getSelectedItem()).getTranzakcioTID());
			}
		});
		btnNewButton.setBounds(21, 183, 116, 66);
		add(btnNewButton);
		
		
		JLabel lblTranzakcioid = new JLabel("TranzakcioID");
		lblTranzakcioid.setBounds(164, 186, 108, 14);
		add(lblTranzakcioid);
		
		JButton btnVissza = new JButton("Vissza");
		btnVissza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Adatok módosítása/felvétele");
				ActivateLayer(1, layeredPane);
			}
		});
		btnVissza.setBounds(164, 307, 116, 42);
		add(btnVissza);
		
		comboBox = new JComboBox();
		comboBox.setBounds(293, 183, 159, 20);
		add(comboBox);

	}
}
