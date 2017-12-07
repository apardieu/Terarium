package IHMPackage;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

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
	protected boolean teraView;
	
	public IHM(Terarium t) {
		startTime = (int)(System.currentTimeMillis()/1000);
		setTitle("Tera Land : The Origins");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
		
		tera = new TerariumView(t);
		Boutique boutique = new Boutique();
		shop = new BoutiqueView(boutique);
		view = new View(tera, shop);
		donnes = new Data();
		border = new Border();
		teraView = true;
		
		tera.setBackground(Color.blue);
		donnes.setBackground(Color.green);
		border.setBackground(Color.black);
		
		border.getNewHButton().addActionListener(new ButtonAddHerbivore(t));
		border.getNewCButton().addActionListener(new ButtonAddCarnivore(t));
		
		border.getPrintBoutique().addActionListener(new ButtonPrintBoutique(view));
		
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
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void refreshData(Terarium t) {
		donnes.getContenantLabel().setText("Nombre d'individus/Capacité : " + t.getNbInsecte() + "/" + t.getCapacity());
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
		protected View view;
		
		public ButtonPrintBoutique(View view) {
			this.view = view;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(teraView==false) {
				teraView=true;
				view.TeraView();
			}
			else {
				teraView=false;
				view.boutiqueView();
			}
	}
}
}
