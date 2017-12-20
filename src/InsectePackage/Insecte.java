package InsectePackage;
import Nourriture.Mangeoire;
import Nourriture.Nourriture;
import Objets.Objet;

import java.io.File;

import MainPackage.Variables;

public abstract class Insecte extends Objet{
	protected int foodLevel;
	private int directionX = 1;
	private int directionY = 1;
	protected Sexe sexe;
	private int maxFoodLevel = 100000;
	private float speedTire;
	private boolean canibale;
	protected int percentageStolen=0;
	protected int speedMove;
	protected boolean isFlying = false;
	protected int actionTime=0;
	protected int choiceAction = 1;
	protected int yStationnaire;
	protected File imageDroite;
	protected File imageGauche;
	protected Mangeoire mangeoire;

	//Move the insect 1 step by 1 step, check if the insect have to move right or left and loose life each step
	
	public void deplacer() {
		if(foodLevel>0) {
			if(isFlying) {
				if(choiceAction < 51 & choiceAction >= 0) {
					planer();
				}
				else if(choiceAction > 50 & choiceAction < 76)
					stay(yTerra);
				else if(choiceAction > 75 & choiceAction < 90) {
					searchFood();
				}
				else {
					atterir();
					if(actionTime==0)
						marcher();
				}
			}
			else {
				if(choiceAction < 51 & choiceAction >=0) {
					setyTerra(Variables.HAUTEUR - gethTerra());
					marcher();
				}
				else if (choiceAction > 50 & choiceAction < 71){
					stay(yTerra);
				}
				else if (choiceAction > 70 & choiceAction < 91){
					searchFood();
				}
				else {
					setyTerra(Variables.HAUTEUR - gethTerra());
					marcher();
				}
			}
				
			if(actionTime==0)
				choiceAction = (int) (Math.random() * 100);
			
			foodLevel-=getSpeedTire();
		}
	}
	
	public void planer() {
		if(getxTerra()+getlTerra()>= Variables.LARGEUR) {
    		setDirectionX(-1);
    		setImage(getImageGauche());
		}
    	else if(getxTerra() <= 0) {
    		setDirectionX(1);
    		setImage(getImageDroite());
    	}
		setxTerra(getxTerra() + speedMove * getDirectionX());
		if(getyTerra()+gethTerra()>= Variables.HAUTEUR*0.6)
    		setDirectionY(-1);
    	else if(getyTerra() <= Variables.HAUTEUR*0.2)
    		setDirectionY(1);
		setyTerra(getyTerra() + speedMove * getDirectionY());
		
		if(actionTime==0)
			actionTime = (int) (Math.random() * 1000);
		else
			actionTime--;
	}
	
	public void atterir() {
		if(actionTime==0)
			actionTime = 1;
		
		if(getyTerra() < Variables.HAUTEUR - gethTerra())
			setyTerra(getyTerra() + speedMove);
		
		else {
			actionTime=0;
		}
	}
	
	public void marcher() {
		if(getxTerra()+getlTerra()>= Variables.LARGEUR) {
    		setDirectionX(-1);
    		setImage(getImageGauche());
		}
    	else if(getxTerra() <= 0) {
    		setDirectionX(1);
    		setImage(getImageDroite());
    	}
		setxTerra(getxTerra() + speedMove * getDirectionX());
		if(actionTime==0)
			actionTime = (int) (Math.random() * 1000);
		else
			actionTime--;
	}

	public void stay(int y) {
		if(getyTerra() >= yStationnaire + 5)
    		setDirectionY(-1);
    	else if(getyTerra() <= yStationnaire - 5)
    		setDirectionY(1);
		setyTerra(getyTerra() + getDirectionY());
		
		if(actionTime==0) {
			yStationnaire = y;
			actionTime = (int) (Math.random() * 1000);
		}
		else
			actionTime--;
	}
	
	public void searchFood() {
		if(actionTime==0)
			actionTime = 1;
		
		if(!isInContactWith(mangeoire)) {
			if((xTerra + lTerra) < mangeoire.getxTerra() & !isInContactWith(mangeoire)) {
				setDirectionX(1);
				setxTerra(getxTerra() + speedMove*directionX);
			}
			else if((yTerra + hTerra) < mangeoire.getyTerra() & !isInContactWith(mangeoire))
				setyTerra(getyTerra() + speedMove);
			if(xTerra > (mangeoire.getxTerra()+mangeoire.getlTerra()) & !isInContactWith(mangeoire)) {
				setDirectionX(-1);
				setxTerra(getxTerra() + speedMove*directionX);
			}
		}
		else {
			actionTime=0;
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
		System.out.println("Coordonnes : " + getxTerra() + ", " + getyTerra());
	}
	
	public int getFoodLevel()
	{
		return this.foodLevel;
	}

	public int getDirectionX() {
		return directionX;
	}

	public void setDirectionX(int directionX) {
		this.directionX = directionX;
		setImage(directionX>0?imageDroite:imageGauche);
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

	public int getDirectionY() {
		return directionY;
	}

	public void setDirectionY(int directionY) {
		this.directionY = directionY;
	}

	public File getImageDroite() {
		return imageDroite;
	}

	public void setImageDroite(File imageDroite) {
		this.imageDroite = imageDroite;
	}

	public File getImageGauche() {
		return imageGauche;
	}

	public void setImageGauche(File imageGauche) {
		this.imageGauche = imageGauche;
	}
	
	public boolean isFlying() {
		return isFlying;
	}

	public void setFlying(boolean isFlying) {
		this.isFlying = isFlying;
	}

	public void setMangeoire(Mangeoire mangeoire) {
		this.mangeoire = mangeoire;
	}
}

