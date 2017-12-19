package InsectePackage;
import Nourriture.Nourriture;
import Objets.Objet;

import java.io.File;

import MainPackage.Variables;

public abstract class Insecte extends Objet{
	protected int foodLevel;
	private int direction = 1;
	protected Sexe sexe;
	private int maxFoodLevel = 100000;
	private float speedTire;
	private boolean canibale;
	protected int percentageStolen=0;
	protected int speedMove;

	//Move the insect 1 step by 1 step, check if the insect have to move right or left and loose life each step
	
	public void deplacer() {
		if(foodLevel>0) {
			if(getX()+getlTerra()>= Variables.LARGEUR)
        		setDirection(-1);
        	else if(getX() <= 0)
        		setDirection(1);
			setX(getX() + speedMove * getDirection());
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
			if ((foodLevel+m.foodLevel*percentageStolen/100)<this.getMaxFoodLevel())
				foodLevel+=m.foodLevel*percentageStolen/100;
			else
				foodLevel=this.getMaxFoodLevel();
			m.foodLevel=0;
	}
	
	public void decrire() {
		System.out.println("Insecte : " + name);
		System.out.println("Satiety : " + foodLevel + "%");
		System.out.println("Coordonnes : " + getX() + ", " + getY());
	}

	public int getY() {
		return yTerra;
	}

	public void setY(int yTerra) {
		this.yTerra = yTerra;
	}

	public int getX() {
		return xTerra;
	}

	public void setX(int xTerra) {
		this.xTerra = xTerra;
	}
	public int getlTerra() {
		return lTerra;
	}

	public void setlTerra(int lTerra) {
		this.lTerra = lTerra;
	}

	public int gethTerra() {
		return hTerra;
	}

	public void sethTerra(int hTerra) {
		this.hTerra = hTerra;
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
}

