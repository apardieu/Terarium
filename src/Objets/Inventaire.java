package Objets;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import InsectePackage.Papillon;
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
		listeInsecte.add(new Papillon());
		listeInsecte.add(new Herbivore());
		listeInsecte.add(new Carnivore());
		}

	public void addInsecte(Insecte o) {
		p.getCurrentTerrarium().addInsecte((Insecte) o);
		listeInsecte.remove(o);
	}
	
	public void addNourriture(Nourriture aliment) {
		if(p.getCurrentTerrarium().getMangeoire().getNourriture().getClass()==aliment.getClass()) {
			for(int i=0; i<100; i++)
				p.getCurrentTerrarium().getMangeoire().remplir((Nourriture) aliment);
			listeNourriture.remove(aliment);
		}
		else
			System.out.println("C'est pas la bonne nourriture");
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