package MainPackage;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import InsectePackage.Papillon;
import Nourriture.Nourriture;
import Objets.Inventaire;
import Objets.Objet;
import Terrariums.Terrarium;

public class Player {
	private String name;
	private int argent;
	private Inventaire inventaire;
	private List<Terrarium> listeTerrarium = new LinkedList<Terrarium>();
	private Terrarium currentTerrarium;

	public Player() {
		setArgent(10000);
		name="Jean-Jacques";
		inventaire = new Inventaire(this);
		inventaire.add(new Papillon());
		inventaire.add(new Papillon());
		inventaire.add(new Herbivore());
		inventaire.add(new Carnivore());
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
			}
			if(o instanceof Terrarium) {
				try {
					Terrarium t = (Terrarium) Class.forName(o.getClass().getName()).newInstance();
					addTerrarium(t);
					((Terrarium) o).vendu();
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
	
	public boolean buy(Objet o, String name) {
		
		if(getArgent()>=o.getPrice()) {
			setArgent(getArgent()-o.getPrice());
			if(o instanceof Insecte) {
				try {
					getInventaire().add((Insecte) Class.forName(o.getClass().getName()).getDeclaredConstructor(String.class).newInstance(name));
				} catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return true;
		}
		else
			return false;
	}
	
	public void vendre(Objet o) {
		argent += o.getRevenu();
		currentTerrarium.getListeInsecte().get(currentTerrarium.getListeInsecte().indexOf(o)).setFoodlevel(0);
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

	public List<Terrarium> getListeTerrarium() {
		return listeTerrarium;
	}

	public Terrarium getCurrentTerrarium() {
		return currentTerrarium;
	}

	public void setCurrentTerrarium(Terrarium currentTerrarium) {
		this.currentTerrarium = currentTerrarium;
	}
}
