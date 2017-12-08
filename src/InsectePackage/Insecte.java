package InsectePackage;
import Nourriture.Nourriture;
import Objets.Objet;

import java.io.File;

public abstract class Insecte extends Objet{
	protected int foodLevel;
	private int direction = 1;
	protected int x= 0;
	protected int y=45;
	protected int hauteur=80;
	protected int largeur=60;
	protected int xp=x+largeur;
	protected int yp=y+hauteur;
	protected Sexe sexe;
	private int maxFoodLevel = 100000;
	private float speedTire;
	private boolean canibale;

	//Move the insect 1 step by 1 step, check if the insect have to move right or left and loose life each step
	
	public void deplacer() {
		if(foodLevel>0) {
			if(getX()+getLargeur()>= 809)
        		setDirection(-1);
        	else if(getX() <= 0)
        		setDirection(1);
			setX(getX() + 1 * getDirection());
			foodLevel-=getSpeedTire();
		}
	}
	
	public void manger(Nourriture n) {
		if ((foodLevel+n.getFoodPower())>getMaxFoodLevel())
			foodLevel=getMaxFoodLevel();
		else
			foodLevel+=n.getFoodPower();
	}
	
	//Kill an insect and win 10% of the life of the victim
	
	public void kill(Insecte m) {
		if(isCanibale()==true) {
			if ((foodLevel+m.foodLevel/10)<this.getMaxFoodLevel())
				foodLevel+=m.foodLevel/10;
			else
				foodLevel=this.getMaxFoodLevel();
			m.foodLevel=0;
		}
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

	public int getMaxFoodLevel() {
		return maxFoodLevel;
	}

	public void setMaxFoodLevel(int maxFoodLevel) {
		this.maxFoodLevel = maxFoodLevel;
	}

	public boolean isCanibale() {
		return canibale;
	}

	public void setCanibale(boolean canibale) {
		this.canibale = canibale;
	}

	public float getSpeedTire() {
		return speedTire;
	}

	public void setSpeedTire(float speedTire) {
		this.speedTire = speedTire;
	}
	
	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public int getYp() {
		return yp;
	}

	public void setYp(int yp) {
		this.yp = yp;
	}

	public void setSize(float echelleLargeur, float echelleHauteur) {
		this.x = (int) (x*echelleLargeur);
		this.y = (int) (y*echelleHauteur);
		this.largeur = (int) (largeur*echelleLargeur);
		this.hauteur = (int) (hauteur*echelleHauteur);
	}
}

