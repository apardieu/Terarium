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
		Thread checkPosition = new Thread(new CheckPosition());
		checkPosition.start();
	}
	
	//Add an insect to the Terarium
	
	public void addInsecte(Insecte m) {
		if (getNbInsecte()<getCapacity())
			getListeInsecte().add(m);
		else
			System.out.println("Plus de places dans ce terarium");
		nbInsecte = getListeInsecte().size();
	}
	
	//Check position of each insects and if only one is Carnivore, it will kill the other
	class CheckPosition implements Runnable{

		@Override
		public void run() {
			while(true){
				if(getNbInsecte() > 1) {
					List<Insecte> l = new LinkedList<Insecte>();
					synchronized(getListeInsecte()) {
						for(Insecte a : getListeInsecte()) {
							for(Insecte b : getListeInsecte()) {
								if(a!=b) {
									if(a.getX()==b.getX() & a.getY()==b.getY()) {
										if((a instanceof Carnivore) & (b instanceof Herbivore)) {
											((Carnivore)a).kill(b);
											l.add(b);
										}
										else if((a instanceof Herbivore) & (b instanceof Carnivore)) {
											((Carnivore)b).kill(a);
											l.add(a);
										}
									}
								}
							}
					}
					}
					for(Insecte a : l)
						getListeInsecte().remove(a);
				}
				nbInsecte = getListeInsecte().size();
			}
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
