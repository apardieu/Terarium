package MainPackage;
import java.io.File;
import java.util.*;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;

//Thread CheckPosition : ListInsecte et ses insectes;

public class Terarium {
	
	//Propriétés
	
	private int capacity;
	private List<Insecte> listeInsecte = Collections.synchronizedList(new LinkedList<Insecte>());
	private int nbInsecte;
	private File image;
	
	public Terarium() {
		setCapacity(30);
		nbInsecte = 0;
		setImage(new File("fond.jpg"));
	}
	
	//Add an insect to the Terarium
	
	public void addInsecte(Insecte m) {
		if (getNbInsecte()<getCapacity())
			getListeInsecte().add(m);
		else
			System.out.println("Plus de places dans ce terarium");
		nbInsecte = getListeInsecte().size();
	}
	
	public void deplacerInsectes() {
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int i = 0;
		while(i<nbInsecte) {
			Insecte a = this.listeInsecte.get(i);
			a.deplacer();
			if(a.getFoodLevel()<1) {
				this.listeInsecte.remove(a);
				nbInsecte--;
			}
			List<Insecte> l = new LinkedList<Insecte>();
			for(Insecte b : getListeInsecte()) {
				if(a!=b) {
					if(a.getX()==b.getX() & a.getY()==b.getY()) {
						if((a instanceof Carnivore) & (b instanceof Herbivore)) {
							if(a.getFoodLevel()+b.getFoodLevel()/10<=a.getMaxFoodLevel()) {
								((Carnivore)a).kill(b);
								l.add(b);
							}
						}
						if((b instanceof Carnivore) & (a instanceof Herbivore)) {
							if(b.getFoodLevel()+a.getFoodLevel()/10<=b.getMaxFoodLevel()) {
								((Carnivore)b).kill(a);
								l.add(a);
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
}
