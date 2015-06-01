package hu.unideb.inf.konyvelo;

import hu.unideb.inf.konyvelo.Model.TranzakcioL;
import hu.unideb.inf.konyvelo.Model.TranzakcioT;

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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TranzakcioTLista extends JPanel {
	
	private static Logger	logger = LoggerFactory.getLogger(TranzakcioTLista.class);
	JScrollPane scrollPane;
	JList<TranzakcioT> tranzakcioLista;
	DefaultListModel listModel;
	List<TranzakcioT> tranzakciok;
	
	public static void ActivateLayer(int i, JLayeredPane layeredPane) {

		for (Component component : layeredPane.getComponents()) {
			if (component.equals(layeredPane.getComponentsInLayer(i)[0]))
				component.setVisible(true);
			else {
				component.setVisible(false);
			}
		}
	}
	
	public void setTranzakcioTLista(List<TranzakcioT> lista){
		logger.info("Adatok feltöltése");
		tranzakciok=lista;
		listModel = new DefaultListModel();
		for(TranzakcioT tranzakcio : tranzakciok){
			listModel.addElement(tranzakcio.toString2());
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
	public TranzakcioTLista(JLayeredPane layeredPane) {
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
				logger.info("Váltás: Társasházak listája");
				ActivateLayer(8, layeredPane);
			}
		});
		btnNewButton.setBounds(73, 41, 121, 40);
		add(btnNewButton);

	}

}
