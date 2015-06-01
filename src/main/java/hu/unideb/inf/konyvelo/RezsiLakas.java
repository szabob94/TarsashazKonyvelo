package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Control.StatisztikaServices;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

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

public class RezsiLakas extends JPanel {
	
	private static Logger	logger = LoggerFactory.getLogger(RezsiLakas.class);
	private JTextField textField;
	Lakas lakas;
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	private List<Lakas> lakasok = new ArrayList<Lakas>();
	private DefaultComboBoxModel<Lakas> box;
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
	
	public void setRezsiLakas(){
		LekeroServices ls = new LekeroServices();
		lakasok=ls.getLakasok();
		box= new DefaultComboBoxModel<Lakas>();
		for(Lakas lakas : lakasok){
			box.addElement(lakas);
		}
		comboBox.setModel(box);
	}

	/**
	 * Create the panel.
	 */
	public RezsiLakas(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		comboBox = new JComboBox();
		comboBox.setBounds(220, 38, 86, 20);
		add(comboBox);

		JButton btnMehet = new JButton("Mehet");
		btnMehet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Adatok feltöltése");
				LekeroServices ls = new LekeroServices();
				lakas=ls.getLakasByID(((Lakas)comboBox.getSelectedItem()).getId());
				StatisztikaServices ss = new StatisztikaServices();
				label.setText(ss.rezsiElott(lakas.getTartozas())+" Ft");
				label_1.setText(lakas.getTartozas()+" Ft");
				label_2.setText(ss.rezsiMegtakarit(ss.rezsiElott(lakas.getTartozas()), lakas.getTartozas())+" Ft");
			}
		});
		btnMehet.setBounds(74, 37, 89, 23);
		add(btnMehet);

		JLabel lblRezsicskkentsEltt = new JLabel(
				"Rezsicsökkentés előtti tartozás");
		lblRezsicskkentsEltt.setBounds(74, 110, 240, 30);
		add(lblRezsicskkentsEltt);

		label = new JLabel("");
		label.setBounds(310, 110, 89, 22);
		add(label);

		JLabel lblRezsicskkentsUtniTartozs = new JLabel(
				"Rezsicsökkentés utáni tartozás");
		lblRezsicskkentsUtniTartozs.setBounds(73, 151, 240, 30);
		add(lblRezsicskkentsUtniTartozs);

		label_1 = new JLabel("");
		label_1.setBounds(309, 151, 114, 22);
		add(label_1);

		JLabel lblMegtakartottsszeg = new JLabel("Megtakarított összeg");
		lblMegtakartottsszeg.setBounds(74, 192, 204, 30);
		add(lblMegtakartottsszeg);

		label_2 = new JLabel("");
		label_2.setBounds(310, 192, 135, 20);
		add(label_2);

		JButton btnVissza = new JButton("Vissza");
		btnVissza.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Statisztika");
				ActivateLayer(12, layeredPane);
			}
		});
		btnVissza.setBounds(395, 37, 89, 23);
		add(btnVissza);
	}

}
