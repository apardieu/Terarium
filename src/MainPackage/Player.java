package MainPackage;

import java.util.LinkedList;
import java.util.List;

import InsectePackage.Insecte;
import Nourriture.Nourriture;
import Objets.Inventaire;
import Objets.Objet;
import Terrariums.Terrarium;

public class Player {
	protected String name;
	private int argent;
	private Inventaire inventaire;
	protected List<Terrarium> listeTerrarium = new LinkedList<Terrarium>();
	private Terrarium currentTerrarium;

	public Player() {
		setArgent(10000);
		name="Jean-Jacques";
		inventaire = new Inventaire(this);
	}
	
	public void addTerrarium(Terrarium t) {
		listeTerrarium.add(t);
		inventaire.getListeTerrarium().add(t);
		setCurrentTerrarium(t);
		Variables.NBTERRARIUM++;
	}
	
	public boolean buy(Objet o) {
		
		if(getArgent()>=o.getPrice()) {
			setArgent(getArgent()-o.getPrice());
			if(o instanceof Insecte) {
				try {
					getInventaire().add((Insecte) Class.forName(o.getClass().getName()).newInstance());
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(o.getClass().getName());
			}
			if(o instanceof Terrarium) {
				try {
					Terrarium t = (Terrarium) Class.forName(o.getClass().getName()).newInstance();
					addTerrarium(t);
				} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(o instanceof Nourriture) {
				try {
					Nourriture a = (Nourriture) Class.forName(o.getClass().getName()).newInstance();
					getInventaire().add(a);
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

	public int getArgent() {
		return argent;
	}

	public void setArgent(int argent) {
		this.argent = argent;
	}

	public Inventaire getInventaire() {
		return inventaire;
	}

	public void setInventaire(Inventaire inventaire) {
		this.inventaire = inventaire;
	}

	public List<Terrarium> getListeTerrarium() {
		return listeTerrarium;
	}

	public void setListeTerrarium(List<Terrarium> listeTerrarium) {
		this.listeTerrarium = listeTerrarium;
	}

	public Terrarium getCurrentTerrarium() {
		return currentTerrarium;
	}

	public void setCurrentTerrarium(Terrarium currentTerrarium) {
		this.currentTerrarium = currentTerrarium;
	}
}
