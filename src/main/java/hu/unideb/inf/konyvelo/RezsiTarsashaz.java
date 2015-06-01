package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Control.StatisztikaServices;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

import java.awt.Component;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class RezsiTarsashaz extends JPanel {
	
	private static Logger	logger = LoggerFactory.getLogger(RezsiTarsashaz.class);
	private JTextField textField;
	JLabel label;
	JLabel label_1;
	JLabel label_2;
	Tarsashaz tarsashaz;
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
	
	public void setRezsiTarsashaz(){
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
	public RezsiTarsashaz(JLayeredPane layeredPane) {
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
				tarsashaz = ls.getTarsashazByID(((Tarsashaz)comboBox.getSelectedItem()).getId());
				StatisztikaServices ss = new StatisztikaServices();
				label.setText(ss.rezsiElott(tarsashaz.getTartozas())+" Ft");
				label_1.setText(tarsashaz.getTartozas()+" Ft");
				label_2.setText(ss.rezsiMegtakarit(ss.rezsiElott(tarsashaz.getTartozas()), tarsashaz.getTartozas())+" Ft");
			}
		});
		btnMehet.setBounds(74, 37, 89, 23);
		add(btnMehet);
		
		JLabel lblRezsicskkentsEltt = new JLabel("Rezsicsökkentés előtti tartozás");
		lblRezsicskkentsEltt.setBounds(74, 110, 240, 30);
		add(lblRezsicskkentsEltt);
		
		label = new JLabel("");
		label.setBounds(330, 110, 89, 22);
		add(label);
		
		JLabel lblRezsicskkentsUtniTartozs = new JLabel("Rezsicsökkentés utáni tartozás");
		lblRezsicskkentsUtniTartozs.setBounds(73, 151, 240, 30);
		add(lblRezsicskkentsUtniTartozs);
		
		label_1 = new JLabel("");
		label_1.setBounds(330, 151, 114, 22);
		add(label_1);
		
		JLabel lblMegtakartottsszeg = new JLabel("Megtakarított összeg");
		lblMegtakartottsszeg.setBounds(74, 192, 204, 30);
		add(lblMegtakartottsszeg);
		
		label_2 = new JLabel("");
		label_2.setBounds(330, 192, 135, 20);
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
