package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.ElosztoServices;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TranzakcioLVegrehajt extends JPanel {
	
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public TranzakcioLVegrehajt() {
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

	}

}
