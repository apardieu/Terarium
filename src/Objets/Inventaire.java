package Objets;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Insecte;
import MainPackage.Player;

public class Inventaire {
	protected List<Insecte> listeInsecte  = new LinkedList<Insecte>();
	protected Player p;
	
	public Inventaire(Player p) {
		this.p = p;
		listeInsecte = new LinkedList<Insecte>();
	}

	public void addInsecte(Insecte o) {
		p.getListeTerarium().get(0).addInsecte((Insecte) o);
		listeInsecte.remove(o);
	}
	public List<Insecte> getListeInsecte() {
		return listeInsecte;
	}

	public void setListeInsecte(List<Insecte> listeInsecte) {
		this.listeInsecte = listeInsecte;
	}
	
	public void decrire() {
		for(Objet o : listeInsecte)
			System.out.println(o.name);
	}
}