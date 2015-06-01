package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.ElosztoServices;
import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranzakcioLVegrehajt extends JPanel {
	
	private static Logger	logger = LoggerFactory.getLogger(TranzakcioLVegrehajt.class);
	private List<TranzakcioL> tranzakciok = new ArrayList<TranzakcioL>();
	private DefaultComboBoxModel<TranzakcioL> box;
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
	
	public void setTranzakcioLVegrehajt(){
		LekeroServices ls = new LekeroServices();
		tranzakciok=ls.getTranzakcioLek();
		box= new DefaultComboBoxModel<TranzakcioL>();
		for(TranzakcioL tranzakcio : tranzakciok){
			box.addElement(tranzakcio);
		}
		comboBox.setModel(box);
	}

	/**
	 * Create the panel.
	 */
	public TranzakcioLVegrehajt(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		JButton btnNewButton = new JButton("Végrehajt");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ElosztoServices es = new ElosztoServices();
				es.elosztL(((TranzakcioL)comboBox.getSelectedItem()).getTranzakcioLID());
			}
		});
		btnNewButton.setBounds(21, 183, 116, 66);
		add(btnNewButton);
		
		
		JLabel lblTranzakcioid = new JLabel("TranzakcioID");
		lblTranzakcioid.setBounds(164, 186, 108, 14);
		add(lblTranzakcioid);
		
		JButton btnMgse = new JButton("Vissza");
		btnMgse.setBounds(176, 289, 116, 45);
		btnMgse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Adatok módosítása/felvétele");
				ActivateLayer(1, layeredPane);
			}
		});
		add(btnMgse);
		
		comboBox = new JComboBox();
		comboBox.setBounds(293, 183, 159, 20);
		add(comboBox);

	}

}
