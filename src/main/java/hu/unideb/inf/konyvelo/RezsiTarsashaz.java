package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Control.StatisztikaServices;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

import java.awt.Component;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RezsiTarsashaz extends JPanel {
	private JTextField textField;
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	Tarsashaz tarsashaz;
	
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
	public RezsiTarsashaz(JLayeredPane layeredPane) {
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
				LekeroServices ls = new LekeroServices();
				tarsashaz = ls.getTarsashazByID(Integer.parseInt(textField.getText()));
				StatisztikaServices ss = new StatisztikaServices();
				label.setText(ss.rezsiElott(tarsashaz.getTartozas())+"");
				label_1.setText(tarsashaz.getTartozas()+"");
				label_2.setText(ss.rezsiMegtakarit(Double.parseDouble(label.getText()), Integer.parseInt(label_1.getText()))+"");
			}
		});
		btnMehet.setBounds(74, 37, 89, 23);
		add(btnMehet);
		
		JLabel lblRezsicskkentsEltt = new JLabel("Rezsicsökkentés előtti tartozás");
		lblRezsicskkentsEltt.setBounds(74, 110, 197, 30);
		add(lblRezsicskkentsEltt);
		
		label = new JLabel("");
		label.setBounds(310, 110, 89, 22);
		add(label);
		
		JLabel lblRezsicskkentsUtniTartozs = new JLabel("Rezsicsökkentés utáni tartozás");
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
				ActivateLayer(12, layeredPane);
			}
		});
		btnVissza.setBounds(395, 37, 89, 23);
		add(btnVissza);

	}

}
