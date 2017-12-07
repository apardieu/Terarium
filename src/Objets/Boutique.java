package Objets;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import MainPackage.Player;

public class Boutique{
	private List<Objet> listeInsecte = new LinkedList<Objet>();
	
	public Boutique(){
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
	}

	public List<Objet> getListeInsecte() {
		return listeInsecte;
	}

	public void setListeInsecte(List<Objet> listeInsecte) {
		this.listeInsecte = listeInsecte;
	}
	
	public boolean buy(Player p, Objet o) {
		
		if(p.getArgent()>=o.getPrice()) {
			return true;
		}
		else
			return false;
	}
}