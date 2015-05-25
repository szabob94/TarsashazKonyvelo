package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Control.StatisztikaServices;
import hu.unideb.inf.konyvelo.Model.Lakas;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
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
	public RezsiLakas(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);

		textField = new JTextField();
		textField.setBounds(220, 38, 86, 20);
		add(textField);
		textField.setColumns(10);

		JButton btnMehet = new JButton("Mehet");
		btnMehet.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Adatok feltöltése");
				LekeroServices ls = new LekeroServices();
				lakas=ls.getLakasByID(Integer.parseInt(textField.getText()));
				StatisztikaServices ss = new StatisztikaServices();
				label.setText(ss.rezsiElott(lakas.getTartozas())+"");
				label_1.setText(lakas.getTartozas()+"");
				label_2.setText(ss.rezsiMegtakarit(Double.parseDouble(label.getText()), lakas.getTartozas())+"");
			}
		});
		btnMehet.setBounds(74, 37, 89, 23);
		add(btnMehet);

		JLabel lblRezsicskkentsEltt = new JLabel(
				"Rezsicsökkentés előtti tartozás");
		lblRezsicskkentsEltt.setBounds(74, 110, 197, 30);
		add(lblRezsicskkentsEltt);

		label = new JLabel("");
		label.setBounds(310, 110, 89, 22);
		add(label);

		JLabel lblRezsicskkentsUtniTartozs = new JLabel(
				"Rezsicsökkentés utáni tartozás");
		lblRezsicskkentsUtniTartozs.setBounds(73, 151, 198, 30);
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
