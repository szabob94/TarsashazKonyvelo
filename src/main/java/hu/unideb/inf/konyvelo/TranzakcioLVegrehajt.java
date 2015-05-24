package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.ElosztoServices;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TranzakcioLVegrehajt extends JPanel {
	
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
	public TranzakcioLVegrehajt(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		textField = new JTextField();
		textField.setBounds(293, 183, 159, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Végrehajt");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ElosztoServices es = new ElosztoServices();
				es.elosztL(Integer.parseInt(textField.getText()));
			}
		});
		btnNewButton.setBounds(21, 183, 116, 66);
		add(btnNewButton);
		
		
		JLabel lblTranzakcioid = new JLabel("TranzakcioID");
		lblTranzakcioid.setBounds(164, 186, 108, 14);
		add(lblTranzakcioid);
		
		JButton btnMgse = new JButton("Mégse");
		btnMgse.setBounds(176, 289, 116, 45);
		btnMgse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(1, layeredPane);
			}
		});
		add(btnMgse);

	}

}
