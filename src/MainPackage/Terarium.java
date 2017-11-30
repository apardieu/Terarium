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
		checkPosition.setName("checkPosition");
		checkPosition.setPriority(Thread.MAX_PRIORITY);
		checkPosition.start();
	}
	
	//Add an insect to the Terarium
	
	public void addInsecte(Insecte m) {
		synchronized(getListeInsecte()) {
		if (getNbInsecte()<getCapacity())
			getListeInsecte().add(m);
		else
			System.out.println("Plus de places dans ce terarium");
		nbInsecte = getListeInsecte().size();
		}
	}
	
	//Check position of each insects and if only one is Carnivore, it will kill the other
	class CheckPosition implements Runnable{

		@Override
		public void run() {
			while(true){
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
					List<Insecte> l = new LinkedList<Insecte>();
					List<Insecte> l2 =  getListeInsecte();
					synchronized(getListeInsecte()) {
						for(Insecte a : l2) {
							for(Insecte b : l2) {
								if((a instanceof Carnivore) & (b instanceof Herbivore)) {
									 if(a.getX()==b.getX() & a.getY()==b.getY()) {
										((Carnivore)a).kill(b);
										l.add(b);
									}
								}
							}
						}
					for(Insecte a : l)
						getListeInsecte().remove(a);
					}
				nbInsecte = getListeInsecte().size();
				List<Insecte> l3 =  getListeInsecte();
				for(Insecte a : l3) {
					a.deplacer();
				}
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
