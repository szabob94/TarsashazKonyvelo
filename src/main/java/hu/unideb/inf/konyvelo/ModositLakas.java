package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.DeleteServices;
import hu.unideb.inf.konyvelo.Control.InsertServices;
import hu.unideb.inf.konyvelo.Model.Lakas;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModositLakas extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Create the panel.
	 */
	public ModositLakas() {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		JButton btnMgse = new JButton("Mégse");
		btnMgse.setBounds(301, 74, 141, 50);
		add(btnMgse);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(33, 156, 23, 14);
		add(lblId);
		
		JLabel lblTulajdonos = new JLabel("Tulajdonos");
		lblTulajdonos.setBounds(247, 156, 70, 14);
		add(lblTulajdonos);
		
		JLabel lblNewLabel = new JLabel("Társasház ID");
		lblNewLabel.setBounds(10, 212, 70, 14);
		add(lblNewLabel);
		
		JLabel lblEmelet = new JLabel("Emelet");
		lblEmelet.setBounds(247, 212, 46, 14);
		add(lblEmelet);
		
		JLabel lblAjt = new JLabel("Ajtó");
		lblAjt.setBounds(247, 252, 46, 14);
		add(lblAjt);
		
		JLabel lblTartozs = new JLabel("Tartozás");
		lblTartozs.setBounds(10, 296, 46, 14);
		add(lblTartozs);
		
		textField = new JTextField();
		textField.setBounds(90, 153, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(327, 153, 197, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(90, 209, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(327, 209, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(327, 249, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(90, 293, 134, 20);
		add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("Elküld");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Lakas lakas = new Lakas();
				lakas.setId(Integer.parseInt(textField.getText()));
				lakas.setTulajdonos(textField_1.getText());
				lakas.setTarsashazID(Integer.parseInt(textField_2.getText()));
				lakas.setEmelet(Integer.parseInt(textField_3.getText()));
				lakas.setAjto(Integer.parseInt(textField_4.getText()));
				lakas.setTartozas(Integer.parseInt(textField_5.getText()));
				InsertServices inS = new InsertServices();
				inS.insertLakas(lakas);
			}
		});
		btnNewButton.setBounds(83, 74, 141, 50);
		add(btnNewButton);
		
		JButton btnTrlsAzAdatbzisbl = new JButton("Törlés az adatbázisból");
		btnTrlsAzAdatbzisbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Lakas lakas = new Lakas();
				lakas.setId(Integer.parseInt(textField.getText()));
				DeleteServices ds = new DeleteServices();
				ds.deleteLakas(lakas);
			}
		});
		btnTrlsAzAdatbzisbl.setBounds(83, 342, 141, 50);
		add(btnTrlsAzAdatbzisbl);
		
	}

}
