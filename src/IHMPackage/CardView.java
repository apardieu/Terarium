package IHMPackage;

import java.awt.CardLayout;

import javax.swing.JPanel;

import Objets.Inventaire;
import Objets.Objet;

public class CardView extends JPanel{
	private static final long serialVersionUID = 4754928741383750759L;
	protected Inventaire inventaire;
	private MenuView main;
	private ObjetVitrineList insecteInventaire;
	private ObjetVitrineList TerrariumInventaire;
	private ObjetVitrineList nourritureInventaire;
	private ObjetVitrineList soinsInventaire;
	private vitrineBoutique vitrine;
	private Objet objet;
	private CardLayout cl;
	private TypeInventaire type;

	public CardView(Inventaire inventaire, TypeInventaire type) {
		cl = new CardLayout();
		this.setLayout(cl);
		this.type = type;
		this.inventaire = inventaire;
		main = new MenuView(type);
		insecteInventaire = new ObjetVitrineList(inventaire.getListeInsecte(), "insecteInventaire");
		TerrariumInventaire = new ObjetVitrineList(inventaire.getListeTerrarium(), "terrariumInventaire");
		nourritureInventaire = new ObjetVitrineList(inventaire.getListeNourriture(), "nourritureInventaire");
		soinsInventaire = new ObjetVitrineList(inventaire.getListeSoins(), "soinsInventaire");
		this.add("insecteInventaire", insecteInventaire);
		this.add("terrariumInventaire", TerrariumInventaire);
		this.add("nourritureInventaire", nourritureInventaire);
		this.add("soinsInventaire", soinsInventaire);
		this.add("main", main);
		
		cl.show(this, "main");
	}
	
	public ObjetVitrineList getInsecteInventaire() {
		return insecteInventaire;
	}

	public ObjetVitrineList getTerrariumInventaire() {
		return TerrariumInventaire;
	}

	public ObjetVitrineList getNourritureInventaire() {
		return nourritureInventaire;
	}

	public ObjetVitrineList getSoinsInventaire() {
		return soinsInventaire;
	}

	public CardLayout getCl() {
		return cl;
	}
	
	public Objet getObjet() {
		return objet;
	}

	public void showVitrine(Objet objet, String name) {
		this.objet = objet;
		vitrine = new vitrineBoutique(inventaire, objet, name);
		this.add("vitrine", vitrine);
		cl.show(this, "vitrine");
	}
	
	public TypeInventaire getType() {
		return type;
	}
}
