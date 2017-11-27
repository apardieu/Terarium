package InsectePackage;
import Nourriture.Nourriture;

public abstract class Insecte {
	protected String name;
	protected int foodLevel;
	protected int x=0;
	protected int y=45;
	protected int hauteur=50;
	protected int largeur=150;
	
	public void deplacer(int a, int b) {
		setX(getX() + a);
		setY(getY() + b);
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
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
}

