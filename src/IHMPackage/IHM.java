package IHMPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import MainPackage.GameController;
import MainPackage.Player;
import MainPackage.Variables;
import Objets.Inventaire;

public class IHM extends JFrame{
	private static final long serialVersionUID = -3796859435142574261L;
	private View view;
	private TerrariumView tera;
	private CardView shop;
	private Data donnes;
	private Border border;
	private PreviewTerrarium previewTera;
	private boolean shopView;
	private boolean venteView;
	private boolean invView;
	private boolean fullScreen;
	private CardView inventaireView;
	private VenteListObjet venteInventaireView;
	private Player player;
	private GameController GC;
	private Inventaire boutique;
	
	public IHM(Player p, Inventaire boutique, boolean fullScreen, GameController GC) {

		//Initialize time when app is launched
		
		setTitle("Tera Land : The Origins");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(Variables.LARGEURFRAMEMIN, Variables.HAUTEURFRAMEMIN));
		
		this.fullScreen = fullScreen;
		this.GC = GC;
		this.player = p;
		this.boutique = boutique;
		this.setLayout(null);
		tera = new TerrariumView(p.getCurrentTerrarium());
		inventaireView = new CardView(p.getInventaire(), TypeInventaire.INVENTAIRE);
		shop = new CardView(boutique, TypeInventaire.BOUTIQUE);
		venteInventaireView = new VenteListObjet(player);
		view = new View(tera, shop, inventaireView, venteInventaireView);
		donnes = new Data();
		previewTera = new PreviewTerrarium(p);
		border = new Border(previewTera);
		
		donnes.setBackground(Color.black);
		border.setBackground(Color.black);
		
		border.getNextTerraButton().addActionListener(new NextTerra());
		border.getPrevTerraButton().addActionListener(new PrevTerra());
		border.getPrintInventaire().addActionListener(new ButtonPrintInventaire(view));
		border.getPrintBoutique().addActionListener(new ButtonPrintBoutique(view));
		border.getPrintVentes().addActionListener(new ButtonPrintVentes(view));
		border.getExitButton().addActionListener(new ExitButton());
		border.getOptionButton().addActionListener(new OptionButton());
		
		//Add view with 95% of Height and 85% of Width
		view.setSize(1460, 980);
		view.setLocation(0, 0);
		this.add(view);
		
		//Add donnes with 85% of Width and 5% of Height
		donnes.setSize(1460, 100);
		donnes.setLocation(0, 980);
		this.add(donnes);
		
		//Add border with 15% of Width and 100% of Height
		border.setSize(460, 1080);
		border.setLocation(1460, 0);
		this.add(border);
		
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setLocationRelativeTo(null);
		setUndecorated(fullScreen);
		setVisible(true);
	}
	
	//Refresh time, money and NbInsect/Capacity
	
	public void refreshData(Player p) {
		float echelle = (float) (((double) Variables.HAUTEURFRAME)/Variables.LARGEURFRAME); //Echelle largeur
		
		donnes.getContenantLabel().setForeground(Color.black);
		donnes.getTempsLabel().setForeground(Color.black);
		donnes.getArgentLabel().setForeground(Color.black);
		donnes.getContenantLabel().setText("Nombre d'individus/Capacité : " + p.getCurrentTerrarium().getNbInsecte() + "/" + p.getCurrentTerrarium().getCapacity());
		donnes.getTempsLabel().setText("Temps: " + ((int)(System.currentTimeMillis()/1000) - p.getCurrentTerrarium().getStartTime()));
		donnes.getArgentLabel().setText("Argent : " + p.getArgent());
		tera.update(p.getCurrentTerrarium());
		if(!fullScreen)
			setSize(this.getWidth(), (int) (this.getWidth()*echelle));
	}
	
	class ButtonPrintInventaire implements ActionListener{
		private View view;
		
		public ButtonPrintInventaire(View view) {
			this.view = view;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(invView==false) {
				shopView = venteView = !(invView = true);
				view.invView();
			}
			else {
				invView = false;
				view.TeraView();
			}
		}
	}
	
	//Change the Card in the cardLayout of view to switch between Boutique and Terrarium
	
	class ButtonPrintBoutique implements ActionListener{
		private View view;
		
		public ButtonPrintBoutique(View view) {
			this.view = view;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(shopView==false) {
				invView = venteView = !(shopView = true);
				view.boutiqueView();
			}
			else {
				shopView = false;
				view.TeraView();
			}
		}
	}
	
	//Change the Card in the cardLayout of view to switch between Sales and Terrarium
	
	class ButtonPrintVentes implements ActionListener{
		private View view;
		
		public ButtonPrintVentes(View view) {
			this.view = view;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(venteView==false) {
				shopView = invView = !(venteView = true);
				view.venteView();
			}
			else {
				venteView = false;
				view.TeraView();
			}
		}
	}
	
	class NextTerra implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(player.getListeTerrarium().size()>1)
			previewTera.next();
		}
	}

	class PrevTerra implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(player.getListeTerrarium().size()>1)
			previewTera.prev();
		}
	}
	
	class ExitButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	class OptionButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			IHM i = new IHM(player, boutique, !fullScreen, GC);
			GC.setIhm(i);
		}
	}
}
