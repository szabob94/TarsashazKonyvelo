package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Model.Lakas;
import hu.unideb.inf.konyvelo.Model.TranzakcioL;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class TranzakcioLLista extends JPanel {
	
	JScrollPane scrollPane;
	JList<TranzakcioL> tranzakcioLista;
	DefaultListModel listModel;
	List<TranzakcioL> tranzakciok;
	
	public static void ActivateLayer(int i, JLayeredPane layeredPane) {

		for (Component component : layeredPane.getComponents()) {
			if (component.equals(layeredPane.getComponentsInLayer(i)[0]))
				component.setVisible(true);
			else {
				component.setVisible(false);
			}
		}
	}
	
	public void setTranzakcioLLista(List<TranzakcioL> lista){
		tranzakciok=lista;
		listModel = new DefaultListModel();
		for(TranzakcioL tranzakcio : tranzakciok){
			listModel.addElement(tranzakcio.toString());
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
	public TranzakcioLLista(JLayeredPane layeredPane) {
		
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
				ActivateLayer(9, layeredPane);
			}
		});
		btnNewButton.setBounds(73, 41, 121, 40);
		add(btnNewButton);
		
	}

}
