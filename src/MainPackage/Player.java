package MainPackage;

import java.util.LinkedList;
import java.util.List;

import Objets.Inventaire;

public class Player {
	protected String name;
	private int argent;
	private Inventaire inventaire;
	protected List<Terarium> listeTerarium = new LinkedList<Terarium>();

	public Player() {
		setArgent(10000);
		name="Lol";
		inventaire = new Inventaire(this);
	}
	
	public void addTerarium(Terarium t) {
		listeTerarium.add(t);
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

	public List<Terarium> getListeTerarium() {
		return listeTerarium;
	}

	public void setListeTerarium(List<Terarium> listeTerarium) {
		this.listeTerarium = listeTerarium;
	}
}
