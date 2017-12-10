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
	protected boolean teraView;
	
	public IHM(Terarium t, Player p) {

		//Initialize time when app is launched
		
		startTime = (int)(System.currentTimeMillis()/1000);
		setTitle("Tera Land : The Origins");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(JFrame.MAXIMIZED_HORIZ, JFrame.MAXIMIZED_VERT));
		
		tera = new TerariumView(t);
		Boutique boutique = new Boutique(p);
		shop = new BoutiqueView(boutique);
		view = new View(tera, shop);
		donnes = new Data();
		border = new Border();
		teraView = true;
		
		donnes.setBackground(Color.black);
		border.setBackground(Color.black);
		
		border.getNewHButton().addActionListener(new ButtonAddHerbivore(t));
		border.getNewCButton().addActionListener(new ButtonAddCarnivore(t));
		border.getPrintBoutique().addActionListener(new ButtonPrintBoutique(view));
		border.getFullScreenButton().addActionListener(new FullScreenButton());
		
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
	
	//Change the Card in the cardLayout of view to switch between Boutique and Terrarium
	
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
	
	class FullScreenButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
		
	}
}
