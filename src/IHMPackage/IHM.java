package IHMPackage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import MainPackage.Terarium;
import Objets.Boutique;

//Thread AutoRefresh : repaint();

public class IHM extends JFrame{
	private static final long serialVersionUID = -3796859435142574261L;
	private int startTime;
	protected View view;
	protected TerariumView tera;
	protected BoutiqueView shop;
	protected Data donnes;
	protected Border border;
	
	public IHM(Terarium t) {
		startTime = (int)(System.currentTimeMillis()/1000);
		setTitle("Tera Land : The Origins");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1080, 720));
		
		view = new View();
		tera = new TerariumView(t);
		shop = new BoutiqueView(new Boutique());
		donnes = new Data();
		border = new Border();
		view.setPanel(tera);
		
		tera.setBackground(Color.blue);
		donnes.setBackground(Color.green);
		border.setBackground(Color.black);
		
		border.getNewHButton().addActionListener(new ButtonAddHerbivore(t));
		border.getNewCButton().addActionListener(new ButtonAddCarnivore(t));
		
		border.getPrintBoutique().addActionListener(new ButtonPrintBoutique(view, shop, tera));
		
		GridBagLayout gbl = new GridBagLayout();
		Container container = getContentPane();
		container.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0;
		gbc.weightx = 0.85;
		gbc.weighty = 0.95;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		container.add(view, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.85;
		gbc.weighty = 0.05;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		container.add(donnes, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.weightx = 0.15;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		container.add(border, gbc);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void refreshData(Terarium t) {
		donnes.getContenantLabel().setText("Nombre d'individus/Capacit� : " + t.getNbInsecte() + "/" + t.getCapacity());
		donnes.getTempsLabel().setText("Temps: " + ((int)(System.currentTimeMillis()/1000) - startTime));
		donnes.getArgentLabel().setText("Argent : " + "0");
	}
	
	class ButtonAddHerbivore implements ActionListener{
		protected Terarium t;
		
		public ButtonAddHerbivore(Terarium t) {
			this.t= t;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Herbivore h = new Herbivore();
			t.addInsecte(h);
		}
	}
	
	class ButtonAddCarnivore implements ActionListener{
		protected Terarium t;
		
		public ButtonAddCarnivore(Terarium t) {
			this.t= t;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Carnivore c = new Carnivore();
			t.addInsecte(c);
		}
	}
	
	class ButtonPrintBoutique implements ActionListener{
		protected JPanel view;
		protected BoutiqueView shop;
		protected TerariumView tera;
		
		public ButtonPrintBoutique(JPanel view, BoutiqueView shop, TerariumView tera) {
			this.view = view;
			this.shop = shop;
			this.tera = tera;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(((View) view).getPanel() instanceof BoutiqueView)
				((View) view).setPanel(tera);
			else
				((View) view).setPanel(shop);
		}
	}
}
