package Objets;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import MainPackage.Player;
import Nourriture.Graine;
import Nourriture.Nourriture;
import Terrariums.Terrarium;
import Terrariums.Terrarium1;
import Terrariums.Terrarium2;
import Terrariums.Terrarium3;

public class Boutique{
	private Player player;
	private List<Insecte> listeInsecte = new LinkedList<Insecte>();
	private List<Terrarium> listeTerrarium = new LinkedList<Terrarium>();
	private List<Nourriture> listeNourriture = new LinkedList<Nourriture>();
	
	public Boutique(Player player){
		this.setPlayer(player);
		getListeInsecte().add(new Carnivore());
		getListeInsecte().add(new Herbivore());
		listeTerrarium.add(new Terrarium1());
		listeTerrarium.add(new Terrarium2());
		listeTerrarium.add(new Terrarium3());
		getListeNourriture().add(new Graine());
	}

	public List<Terrarium> getListeTerrarium() {
		return listeTerrarium;
	}

	public void setListeTerrarium(List<Terrarium> listeTerrarium) {
		this.listeTerrarium = listeTerrarium;
	}

	public List<Insecte> getListeInsecte() {
		return listeInsecte;
	}

	public void setListeInsecte(List<Insecte> listeInsecte) {
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
			if(o instanceof Terrarium) {
				try {
					Terrarium t = (Terrarium) Class.forName(o.getClass().getName()).newInstance();
					getPlayer().addTerrarium(t);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(o instanceof Nourriture) {
				try {
					Nourriture a = (Nourriture) Class.forName(o.getClass().getName()).newInstance();
					getPlayer().getInventaire().getListeNourriture().add(a);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return true;
		}
		else
			return false;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public List<Nourriture> getListeNourriture() {
		return listeNourriture;
	}

	public void setListeNourriture(List<Nourriture> listeNourriture) {
		this.listeNourriture = listeNourriture;
	}
}