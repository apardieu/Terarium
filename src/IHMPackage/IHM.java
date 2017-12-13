package IHMPackage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JFrame;
import InsectePackage.Herbivore;
import MainPackage.Player;
import MainPackage.Terarium;
import Objets.Boutique;

public class IHM extends JFrame{
	private static final long serialVersionUID = -3796859435142574261L;
	private int startTime;
	protected View view;
	protected TerariumView tera;
	protected BoutiqueView shop;
	protected Data donnes;
	protected Border border;
	protected PreviewTerrarium previewTera;
	protected boolean teraView;
	protected boolean shopView;
	protected boolean invView;
	protected InventaireView inventaireView;
	
	public IHM(Terarium t, Player p) {

		//Initialize time when app is launched
		
		startTime = (int)(System.currentTimeMillis()/1000);
		setTitle("Tera Land : The Origins");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
		
		tera = new TerariumView(p.getListeTerarium().get(0));
		Boutique boutique = new Boutique(p);
		inventaireView = new InventaireView(p.getInventaire());
		shop = new BoutiqueView(boutique);
		view = new View(tera, shop, inventaireView);
		donnes = new Data();
		previewTera = new PreviewTerrarium(p);
		border = new Border(previewTera);
		teraView = true;
		
		donnes.setBackground(Color.black);
		border.setBackground(Color.black);
		
		border.getPrintInventaire().addActionListener(new ButtonPrintInventaire(view));
		border.getPrintBoutique().addActionListener(new ButtonPrintBoutique(view));
		border.getExitButton().addActionListener(new ExitButton());
		
		//Add view with 95% of Height and 85% of Width
		
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
		
		//Add donnes with 85% of Width and 5% of Height
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.85;
		gbc.weighty = 0.05;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		container.add(donnes, gbc);
		
		//Add border with 15% of Width and 100% of Height
		
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
		setUndecorated(true);
		setVisible(true);
	}
	
	//Refresh time, money and NbInsect/Capacity
	
	public void refreshData(Terarium t, Player p) {
		donnes.getContenantLabel().setForeground(Color.white);
		donnes.getTempsLabel().setForeground(Color.white);
		donnes.getArgentLabel().setForeground(Color.white);
		donnes.getContenantLabel().setText("Nombre d'individus/Capacité : " + t.getNbInsecte() + "/" + t.getCapacity());
		donnes.getTempsLabel().setText("Temps: " + ((int)(System.currentTimeMillis()/1000) - startTime));
		donnes.getArgentLabel().setText("Argent : " + p.getArgent());
	}
	
	class ButtonPrintInventaire implements ActionListener{
		protected View view;
		
		public ButtonPrintInventaire(View view) {
			this.view = view;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(invView==false) {
				shopView = teraView = !(invView = true);
				view.invView();
			}
			else {
				teraView = !(invView = false);
				view.TeraView();
			}
		}
	}
	
	//Change the Card in the cardLayout of view to switch between Boutique and Terrarium
	
	class ButtonPrintBoutique implements ActionListener{
		protected View view;
		
		public ButtonPrintBoutique(View view) {
			this.view = view;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(shopView==false) {
				invView = teraView = !(shopView = true);
				view.boutiqueView();
			}
			else {
				teraView = !(shopView = false);
				view.TeraView();
			}
		}
	}
	
	class ExitButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
}
