package Objets;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Insecte;
import MainPackage.Player;
import Nourriture.Nourriture;
import Terrariums.Terrarium;

public class Inventaire {
	protected List<Insecte> listeInsecte  = new LinkedList<Insecte>();
	protected List<Terrarium> listeTerrarium  = new LinkedList<Terrarium>();
	private List<Nourriture> listeNourriture = new LinkedList<Nourriture>();
	protected Player p;
	
	public Inventaire(Player p) {
		this.p = p;
	}

	public void addInsecte(Insecte o) {
		p.getCurrentTerrarium().addInsecte((Insecte) o);
		listeInsecte.remove(o);
	}
	
	public void addNourriture(Nourriture aliment) {
		p.getCurrentTerrarium().getMangeoire().remplir(((Nourriture) aliment).getFoodPower());
		listeNourriture.remove(aliment);
	}
	
	public List<Nourriture> getListeNourriture() {
		return listeNourriture;
	}

	public void setListeNourriture(List<Nourriture> listeNourriture) {
		this.listeNourriture = listeNourriture;
	}
	
	public List<Insecte> getListeInsecte() {
		return listeInsecte;
	}

	public void setListeInsecte(List<Insecte> listeInsecte) {
		this.listeInsecte = listeInsecte;
	}
	
	public List<Terrarium> getListeTerrarium() {
		return listeTerrarium;
	}

	public void setListeTerrarium(List<Terrarium> listeTerrarium) {
		this.listeTerrarium = listeTerrarium;
	}

	public void decrire() {
		for(Objet o : listeInsecte)
			System.out.println(o.name);
	}
}