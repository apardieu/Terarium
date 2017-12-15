package MainPackage;

import java.util.LinkedList;
import java.util.List;

import Objets.Inventaire;
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
