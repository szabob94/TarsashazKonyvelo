package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.ElosztoServices;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class Kioszt extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Kioszt() {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		textField = new JTextField();
		textField.setBounds(293, 183, 159, 20);
		add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Elosztás");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ElosztoServices es = new ElosztoServices();
				es.elosztT(Integer.parseInt(textField.getText()));
			}
		});
		btnNewButton.setBounds(21, 183, 116, 66);
		add(btnNewButton);
		
		
		JLabel lblTranzakcioid = new JLabel("TranzakcioID");
		lblTranzakcioid.setBounds(164, 186, 108, 14);
		add(lblTranzakcioid);

	}
}