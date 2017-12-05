package InsectePackage;
import Nourriture.Nourriture;
import java.io.File;

//Thread Deplacer : Insecte.X

public abstract class Insecte {
	protected String name;
	protected int foodLevel;
	private int direction = 1;
	protected int x= 0;
	protected int y=45;
	protected int hauteur=80;
	protected int largeur=80;
	protected Sexe sexe;
	private File image;

	public void deplacer() {
		if(foodLevel>0) {
			if(getX()+getLargeur()>= 809)
        		setDirection(-1);
        	else if(getX() <= 0)
        		setDirection(1);
			setX(getX() + 1 * getDirection());
		}
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
	
	public void setSexe(Sexe s)
	{
		this.sexe=s;
	}
	
	public Sexe getSexe()
	{
		return this.sexe;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}
}

