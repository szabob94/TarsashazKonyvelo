package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.DeleteServices;
import hu.unideb.inf.konyvelo.Control.InsertServices;
import hu.unideb.inf.konyvelo.DAO.DAOInsert;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModositTarsashaz extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public ModositTarsashaz() {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		JButton btnNewButton_1 = new JButton("Mégse");
		btnNewButton_1.setBounds(337, 56, 126, 52);
		add(btnNewButton_1);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(72, 157, 64, 26);
		add(lblId);
		
		textField = new JTextField();
		lblId.setLabelFor(textField);
		textField.setBounds(146, 163, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Társasház címe");
		lblNewLabel.setBounds(34, 224, 102, 35);
		add(lblNewLabel);
		
		textField_1 = new JTextField();
		lblNewLabel.setLabelFor(textField_1);
		textField_1.setBounds(146, 231, 305, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblTartozs = new JLabel("Tartozás");
		lblTartozs.setBounds(34, 290, 76, 26);
		add(lblTartozs);
		
		textField_2 = new JTextField();
		textField_2.setBounds(146, 293, 191, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Elküld");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tarsashaz tarsashaz = new Tarsashaz();
				tarsashaz.setId(Integer.parseInt(textField.getText()));
				tarsashaz.setCim(textField_1.getText());
				tarsashaz.setTartozas(Integer.parseInt(textField_2.getText()));
				tarsashaz.setEmeletszam(4);
				tarsashaz.setLakasszam(8);
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
		btnTrlsAzAdatbzisbl.setBounds(83, 342, 141, 50);
		add(btnTrlsAzAdatbzisbl);

	}

}
