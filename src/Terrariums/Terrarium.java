package Terrariums;
import java.io.File;
import java.util.*;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import InsectePackage.Oeuf;
import MainPackage.Variables;
import Nourriture.Graine;
import Nourriture.Mangeoire;
import Objets.Objet;

public abstract class Terrarium extends Objet{
	
	
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
			List<Insecte> toremove = new LinkedList<Insecte>(); //used to  know which insect have to be removed 
			List<Oeuf> eggs = new LinkedList<Oeuf>(); //used to add eggs to the insecteListe
			int nbEggToRemove = 0; //use to know how many eggs must be removed in order to not decrease the number of insects when eggs are added to the toremovelist
			if(a instanceof Oeuf)
			{
				if(((Oeuf) a).eclore())
				{
					System.out.println("ECLOSION");
					toremove.add(a);
					nbEggToRemove++;
					Insecte insnait=((Oeuf) a).getInsecteNait();
					insnait.decrire();
					System.out.println(insnait.getName()+" a éclot");
					this.getListeInsecte().add(insnait);
					this.description();
					
				}
				else
				{
					((Oeuf) a).increasetemps();					
				}
			}
			else
			{
				a.deplacer();
				a.decreaseGestation();
				if(a.getFoodLevel()<1) {
					this.listeInsecte.remove(a);
					nbInsecte--;
				}
				if(a.isInContactWith(mangeoire) & mangeoire.getNbNourriture()>0 & a.getAcceptedFood().contains(mangeoire.getNourriture().getClass())) {
					a.manger(mangeoire.getNourriture());
					mangeoire.setNbNourriture(mangeoire.getNbNourriture()-mangeoire.getNourriture().getFoodPower());
				}
				

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
									toremove.add(b);
								}
							}
							if((b instanceof Carnivore) & (a instanceof Herbivore)) {
								if(b.getFoodLevel()+a.getFoodLevel()/10<=b.getMaxFoodLevel()) {
									b.kill(a);
									toremove.add(a);
								}
							}
							if((a instanceof Herbivore) & (b instanceof Herbivore)) {
								if(a.isCanibale()==true & (b instanceof Herbivore) & b.isCanibale()==false) {
									if(a.getFoodLevel()+b.getFoodLevel()/10<=a.getMaxFoodLevel()) {
										a.kill(b);
										toremove.add(b);
									}
								}
								if(b.isCanibale()==true & (a instanceof Herbivore) & a.isCanibale()==false) {
									if(b.getFoodLevel()+a.getFoodLevel()/10<=b.getMaxFoodLevel()) {
										b.kill(a);
										toremove.add(a);
									}
								}
								
								if(checkParent(a,b))
								{
									System.out.println("Accouplement");
									eggs.add(new Oeuf(a));
									nbInsecte++;
								}
								
							}
						}
					}
	
				}
			}
			nbInsecte=nbInsecte-toremove.size()+nbEggToRemove;
			System.out.println("++++++++++++++++NBINSECTE : "+nbInsecte);
			for(Insecte ins : toremove) {
				this.listeInsecte.remove(ins);
			}
			
			for(Oeuf o : eggs)
			{
				o.setName("Oeuf");
				this.listeInsecte.add(o);
			}
			eggs.clear();
			i++;
		}
	}
	
	public void description() {
		System.out.println("Ce terrarium contient :");
		for(Insecte i : getListeInsecte()) {
			i.decrire();
		}
	}
	
	public boolean checkParent(Insecte a, Insecte b)
	{
		if(a.getClass() == b.getClass() & a.getSexe()!=b.getSexe())
		{

			if(a.getGestationTime()==0 & b.getGestationTime()==0 & a.getFoodLevel()>75000 & b.getFoodLevel()>75000 & this.nbInsecte<capacity)
			{
				a.setGestationTime(10000);
				b.setGestationTime(10000);
				return true;
				
			}
			
		}
		
		return false; 
		
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
