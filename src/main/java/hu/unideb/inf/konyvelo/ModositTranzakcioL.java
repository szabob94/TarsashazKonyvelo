package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.DeleteServices;
import hu.unideb.inf.konyvelo.Control.InsertServices;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

import org.joda.time.DateTime;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModositTranzakcioL extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
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
	public ModositTranzakcioL(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		textField = new JTextField();
		textField.setBounds(145, 161, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(386, 133, 86, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(145, 225, 86, 20);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(386, 187, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(386, 253, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(183, 297, 289, 20);
		add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("Elküld");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TranzakcioL tranzakcio = new TranzakcioL();
				tranzakcio.setTranzakcioLID(Integer.parseInt(textField.getText()));
				tranzakcio.setLakasID(Integer.parseInt(textField_1.getText()));
				tranzakcio.setOsszeg(Integer.parseInt(textField_2.getText()));
				String tmp[] = textField_3.getText().split("/");
				tranzakcio.setDatum(new DateTime(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]), Integer.parseInt(tmp[2]), Integer.parseInt(tmp[3]), Integer.parseInt(tmp[4])));
				tranzakcio.setBefizeto(textField_4.getText());
				tranzakcio.setLeiras(textField_5.getText());;
				InsertServices inS = new InsertServices();
				inS.insertTranzakcioL(tranzakcio);
			}
		});
		btnNewButton.setBounds(111, 51, 120, 46);
		add(btnNewButton);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(55, 163, 30, 17);
		add(lblId);
		
		JLabel lblLaksId = new JLabel("Lakás ID");
		lblLaksId.setBounds(298, 136, 46, 14);
		add(lblLaksId);
		
		JLabel lblsszeg = new JLabel("Összeg");
		lblsszeg.setBounds(55, 228, 46, 14);
		add(lblsszeg);
		
		JLabel lblDtum = new JLabel("Dátum");
		lblDtum.setBounds(298, 190, 46, 14);
		add(lblDtum);
		
		JLabel lblBefizet = new JLabel("Befizető");
		lblBefizet.setBounds(298, 256, 46, 14);
		add(lblBefizet);
		
		JLabel lblLers = new JLabel("Leírás");
		lblLers.setBounds(98, 300, 46, 14);
		add(lblLers);
		
		JButton btnNewButton_1 = new JButton("Mégse");
		btnNewButton_1.setBounds(305, 51, 129, 46);
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(1, layeredPane);
			}
		});
		add(btnNewButton_1);
		
		JButton btnTrlsAzAdatbzisbl = new JButton("Törlés az adatbázisból");
		btnTrlsAzAdatbzisbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TranzakcioL tranzakcio = new TranzakcioL();
				tranzakcio.setTranzakcioLID(Integer.parseInt(textField.getText()));
				DeleteServices ds = new DeleteServices();
				ds.deleteTranzakcioL(tranzakcio);
			}
		});
		btnTrlsAzAdatbzisbl.setBounds(111, 342, 139, 46);
		add(btnTrlsAzAdatbzisbl);

	}
}
