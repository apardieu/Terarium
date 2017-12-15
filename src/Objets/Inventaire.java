package Objets;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Insecte;
import MainPackage.Player;
import Terrariums.Terrarium;

public class Inventaire {
	protected List<Insecte> listeInsecte  = new LinkedList<Insecte>();
	protected List<Terrarium> listeTerrarium  = new LinkedList<Terrarium>();
	protected Player p;
	
	public Inventaire(Player p) {
		this.p = p;
	}

	public void addInsecte(Insecte o) {
		p.getCurrentTerrarium().addInsecte((Insecte) o);
		listeInsecte.remove(o);
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