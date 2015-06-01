package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.DeleteServices;
import hu.unideb.inf.konyvelo.Control.InsertServices;
import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ModositLakas extends JPanel {
	
	private static Logger	logger = LoggerFactory.getLogger(ModositLakas.class);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private List<Tarsashaz> tarsashazak = new ArrayList<Tarsashaz>();
	private DefaultComboBoxModel<Tarsashaz> box;
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
	
	public void setModositLakas(){
		LekeroServices ls = new LekeroServices();
		tarsashazak=ls.getTarsashazak();
		box= new DefaultComboBoxModel<Tarsashaz>();
		for(Tarsashaz th : tarsashazak){
			box.addElement(th);
		}
		comboBox.setModel(box);
	}

	/**
	 * Create the panel.
	 */
	public ModositLakas(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		JButton btnMgse = new JButton("Vissza");
		btnMgse.setBounds(301, 74, 141, 50);
		btnMgse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logger.info("Váltás: Adatok módosítása/felvétele");
				ActivateLayer(1, layeredPane);
			}
		});
		add(btnMgse);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(33, 156, 23, 14);
		add(lblId);
		
		JLabel lblTulajdonos = new JLabel("Tulajdonos");
		lblTulajdonos.setBounds(247, 156, 100, 14);
		add(lblTulajdonos);
		
		JLabel lblNewLabel = new JLabel("Társasház ID");
		lblNewLabel.setBounds(10, 212, 120, 14);
		add(lblNewLabel);
		
		JLabel lblEmelet = new JLabel("Emelet");
		lblEmelet.setBounds(247, 212, 60, 14);
		add(lblEmelet);
		
		JLabel lblAjt = new JLabel("Ajtó");
		lblAjt.setBounds(247, 252, 46, 14);
		add(lblAjt);
		
		JLabel lblTartozs = new JLabel("Tartozás");
		lblTartozs.setBounds(10, 296, 70, 14);
		add(lblTartozs);
		
		textField = new JTextField();
		textField.setBounds(110, 153, 86, 20);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(337, 153, 197, 20);
		add(textField_1);
		textField_1.setColumns(10);

		comboBox = new JComboBox();
		comboBox.setBounds(110, 209, 86, 20);
		add(comboBox);
		
		textField_3 = new JTextField();
		textField_3.setBounds(337, 209, 86, 20);
		add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(337, 249, 86, 20);
		add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(110, 293, 134, 20);
		add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton = new JButton("Elküld");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Lakas lakas = new Lakas();
				lakas.setId(Integer.parseInt(textField.getText()));
				lakas.setTulajdonos(textField_1.getText());
				//lakas.setTarsashazID(Integer.parseInt(textField_2.getText()));
				lakas.setTarsashazID(((Tarsashaz)comboBox.getSelectedItem()).getId());
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
		btnTrlsAzAdatbzisbl.setBounds(83, 342, 210, 50);
		add(btnTrlsAzAdatbzisbl);
		
	}

}
