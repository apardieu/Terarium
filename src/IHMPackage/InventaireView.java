package IHMPackage;
import java.awt.CardLayout;

import javax.swing.JPanel;

import Objets.Inventaire;
import Objets.Objet;

public class InventaireView extends JPanel{
	private static final long serialVersionUID = 4754928741383750759L;
	protected Inventaire inventaire;
	protected MainShop main;
	protected ObjetListeVitrine insecteInventaire;
	protected ObjetListeVitrine TerrariumInventaire;
	protected ObjetListeVitrine nourritureInventaire;
	protected Objet objet;

	protected CardLayout cl;

	public InventaireView(Inventaire inventaire) {
		cl = new CardLayout();
		this.setLayout(cl);
		this.inventaire = inventaire;
		main = new MainShop(MainShop.INVENTAIRE);
		insecteInventaire = new ObjetListeVitrine(inventaire.getListeInsecte());
		TerrariumInventaire = new ObjetListeVitrine(inventaire.getListeTerrarium());
		nourritureInventaire = new ObjetListeVitrine(inventaire.getListeNourriture());
		this.add("insecteInventaire", insecteInventaire);
		this.add("TerrariumInventaire", TerrariumInventaire);
		this.add("nourritureInventaire", nourritureInventaire);
		this.add("main", main);
		
		cl.show(this, "main");
	}
	
	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}
	
	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
	}
}
