package Terrariums;
import java.io.File;
import java.util.*;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import MainPackage.Variables;
import Nourriture.Graine;
import Nourriture.Mangeoire;
import Objets.Objet;

public abstract class Terrarium extends Objet{
	
	//Propriétés
	
	private int startTime;
	protected int capacity;
	private List<Insecte> listeInsecte = new LinkedList<Insecte>();
	protected int nbInsecte;
	protected Mangeoire mangeoire;
	
	public Terrarium() {
		startTime = (int)(System.currentTimeMillis()/1000);
		nbInsecte = 0;
		mangeoire = new Mangeoire(new Graine());
		mangeoire.setlTerra(100);
		mangeoire.setxTerra((Variables.LARGEUR-mangeoire.getlTerra())/2);
		mangeoire.sethTerra(100);
		mangeoire.setyTerra(Variables.HAUTEUR-mangeoire.gethTerra());
		lShop = 300;
		hShop = 193;
	}
	
	//Add an insect to the Terarium
	
	public void addInsecte(Insecte m) {
		if (getNbInsecte()<getCapacity()) {
			getListeInsecte().add(m);
			m.setMangeoire(mangeoire);
		}
		else
			System.out.println("Plus de places dans ce terarium");
		nbInsecte = getListeInsecte().size();
	}
	
	//Move an insect and check the position of the other in order to kill then if possible
	
	public void deplacerInsectes() {
		try {
			Thread.sleep(4/Variables.NBTERRARIUM);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int i = 0;
		
		//Using a while loop because the number of insect change into the loop
		
		while(i<nbInsecte) {
			Insecte a = this.listeInsecte.get(i);
			a.deplacer();
			if(a.getFoodLevel()<1) {
				this.listeInsecte.remove(a);
				nbInsecte--;
			}
			if(a.isInContactWith(mangeoire) & mangeoire.getNbNourriture()>0 & a.getAcceptedFood().contains(mangeoire.getNourriture().getClass())) {
				a.manger(mangeoire.getNourriture());
				mangeoire.setNbNourriture(mangeoire.getNbNourriture()-mangeoire.getNourriture().getFoodPower());
			}
			List<Insecte> l = new LinkedList<Insecte>();
			if(a instanceof Herbivore & !a.isFlying()) {
				if(a.getFoodLevel()<a.getMaxFoodLevel()/10) {
					((Herbivore)a).zombie();
				}
				if(a.getFoodLevel()>a.getMaxFoodLevel()*0.5) {
					((Herbivore)a).normal();
				}
			}
			for(Insecte b : getListeInsecte()) {
				if(a!=b) {
					if(a.isInContactWith(b)) {
						if((a instanceof Carnivore) & (b instanceof Herbivore)) {
							if(a.getFoodLevel()+b.getFoodLevel()/10<=a.getMaxFoodLevel()) {
								a.kill(b);
								l.add(b);
							}
						}
						if((b instanceof Carnivore) & (a instanceof Herbivore)) {
							if(b.getFoodLevel()+a.getFoodLevel()/10<=b.getMaxFoodLevel()) {
								b.kill(a);
								l.add(a);
							}
						}
						if((a instanceof Herbivore) & (b instanceof Herbivore)) {
							if(a.isCanibale()==true & (b instanceof Herbivore) & b.isCanibale()==false) {
								if(a.getFoodLevel()+b.getFoodLevel()/10<=a.getMaxFoodLevel()) {
									a.kill(b);
									l.add(b);
								}
							}
							if(b.isCanibale()==true & (a instanceof Herbivore) & a.isCanibale()==false) {
								if(b.getFoodLevel()+a.getFoodLevel()/10<=b.getMaxFoodLevel()) {
									b.kill(a);
									l.add(a);
								}
							}
						}
					}
				}
			}
			nbInsecte-=l.size();
			for(Insecte ins : l) {
				this.listeInsecte.remove(ins);
			}
			i++;
		}
		
	}
	
	public void description() {
		System.out.println("Ce terrarium contient :");
		for(Insecte i : getListeInsecte()) {
			i.decrire();
		}
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public int getNbInsecte() {
		return nbInsecte;
	}

	public List<Insecte> getListeInsecte() {
		return listeInsecte;
	}

	public void setListeInsecte(List<Insecte> listeInsecte) {
		this.listeInsecte = listeInsecte;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getStartTime() {
		return startTime;
	}

	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}

	public Mangeoire getMangeoire() {
		return mangeoire;
	}

	public void setMangeoire(Mangeoire mangeoire) {
		this.mangeoire = mangeoire;
	}
	
	public void vendu() {
		
	}
}
