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
	private List<Soins> listeSoins = new LinkedList<Soins>();
	protected Player p;
	
	public Inventaire(Player p) {
		this.p = p;
	}
	
	//CHANGEMENT
	
	public boolean add(Objet o) {
		if(o instanceof Insecte) {
			listeInsecte.add((Insecte) o);
			return true;
		}
		else if(o instanceof Nourriture) {
			listeNourriture.add((Nourriture) o);
			return true;
		}
		else if(o instanceof Terrarium) {
			listeTerrarium.add((Terrarium) o);
			return true;
		}
		else 
			return false;
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
	
	public List<Insecte> getListeInsecte() {
		return listeInsecte;
	}

	public List<Terrarium> getListeTerrarium() {
		return listeTerrarium;
	}

	public List<Soins> getListeSoins() {
		return listeSoins;
	}
}