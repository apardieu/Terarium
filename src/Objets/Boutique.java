package Objets;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import MainPackage.Player;

public class Boutique{
	private Player p;
	private List<Objet> listeInsecte = new LinkedList<Objet>();
	
	public Boutique(Player p){
		this.setPlayer(p);
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
	}

	public List<Objet> getListeInsecte() {
		return listeInsecte;
	}

	public void setListeInsecte(List<Objet> listeInsecte) {
		this.listeInsecte = listeInsecte;
	}
	
	public boolean buy(Objet o) {
		
		if(getPlayer().getArgent()>=o.getPrice()) {
			getPlayer().setArgent(getPlayer().getArgent()-o.getPrice());
			if(o instanceof Insecte) {
				try {
					getPlayer().getInventaire().getListeInsecte().add((Insecte) Class.forName(o.getClass().getName()).newInstance());
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(o.getClass().getName());
			}
			return true;
		}
		else
			return false;
	}

	public Player getPlayer() {
		return p;
	}

	public void setPlayer(Player p) {
		this.p = p;
	}
}