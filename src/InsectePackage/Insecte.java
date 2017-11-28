package InsectePackage;
import Nourriture.Nourriture;

//Thread Deplacer : Insecte.X

public abstract class Insecte {
	protected String name;
	protected int foodLevel;
	private int direction = 1;
	protected int x=0;
	protected int y=45;
	protected int hauteur=80;
	protected int largeur=80;
	
	class Deplacer implements Runnable{

		@Override
		public void run() {
			while(foodLevel>0) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				setX(getX() + 1 * getDirection());
			}
		}
		
	}
	
	protected void vivre() {
		Thread deplacement = new Thread(new Deplacer());
		deplacement.start();
	}
	
	public void manger(Nourriture n) {
		if ((foodLevel+n.getFoodPower())>100)
			foodLevel=100;
		else
			foodLevel+=n.getFoodPower();
	}
	
	public void decrire() {
		System.out.println("Insecte : " + name);
		System.out.println("Satiety : " + foodLevel + "%");
		System.out.println("Coordonnes : " + getX() + ", " + getY());
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public synchronized int getX() {
		return x;
	}

	public synchronized void setX(int x) {
		this.x = x;
	}
	public int getLargeur() {
		return largeur;
	}

	public void setlargeur(int largeur) {
		this.largeur = largeur;
	}

	public int getHauteur() {
		return hauteur;
	}

	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}
	
	public int getFoodLevel()
	{
		return this.foodLevel;
	}

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}
}

