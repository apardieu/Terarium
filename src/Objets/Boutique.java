package Objets;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import InsectePackage.Papillon;
import MainPackage.Player;
import Nourriture.Graine;
import Nourriture.Nourriture;
import Nourriture.Viande;
import Terrariums.Terrarium;
import Terrariums.Terrarium1;
import Terrariums.Terrarium2;
import Terrariums.Terrarium3;

public class Boutique{
	private Player player;
	private Inventaire inventaire;
	
	public Boutique(Player player){
		this.setPlayer(player);
		inventaire = new Inventaire(player);
		inventaire.add(new Carnivore());
		inventaire.add(new Herbivore());
		inventaire.add(new Papillon());
		inventaire.add(new Terrarium1());
		inventaire.add(new Terrarium2());
		inventaire.add(new Terrarium3());
		inventaire.add(new Graine());
		inventaire.add(new Viande());
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

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}
}