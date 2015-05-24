package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Control.LekeroServices;
import hu.unideb.inf.konyvelo.Model.Tarsashaz;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TarsashazLista extends JPanel {
	
	JScrollPane scrollPane;
	JList<Tarsashaz> tarsashazLista;
	DefaultListModel listModel;
	List<Tarsashaz> tarsashazak;
	
	public static void ActivateLayer(int i, JLayeredPane layeredPane) {

		for (Component component : layeredPane.getComponents()) {
			if (component.equals(layeredPane.getComponentsInLayer(i)[0]))
				component.setVisible(true);
			else {
				component.setVisible(false);
			}
		}
	}
	
	public void setTarsashazList(List<Tarsashaz> lista){
		tarsashazak=lista;
		listModel = new DefaultListModel();
		for(Tarsashaz th : tarsashazak){
			listModel.addElement(th.toString());
		}
		JList list = new JList(listModel);
		list.setBounds(10, 101, 564, 299);
		scrollPane.add(list);
		scrollPane.setViewportView(list);
		scrollPane.setVisible(true);
		add(scrollPane);
	}

	/**
	 * Create the panel.
	 */
	public TarsashazLista(JLayeredPane layeredPane) {
		setLayout(null);
		setBounds(0, 0, 584, 411);
		
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setAutoscrolls(true);
		scrollPane.setBounds(10, 101, 564, 299);
		scrollPane.setWheelScrollingEnabled(true);
		
		JButton btnNewButton = new JButton("Vissza");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ActivateLayer(0, layeredPane);
			}
		});
		btnNewButton.setBounds(73, 41, 121, 40);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Tranzakciók");
		btnNewButton_1.setBounds(327, 41, 121, 40);
		add(btnNewButton_1);
		

	}
}
