package InsectePackage;

import java.io.File;

import MainPackage.Variables;
import Nourriture.Graine;

public class Herbivore extends Insecte{
	public Herbivore() {
		name = "Herbivore";
		foodLevel=(int) (getMaxFoodLevel()*0.5);
		setImage(new File(Variables.INSECTESPATH + "mouchetest.png"));
		imageDroite = getImage();
		imageGauche = getImage();
		setPrice(500);
		setCanibale(false);
		setSpeedTire(2);
		speedMove=2;
		hTerra=121;
		lTerra=108;
		acceptedFood.add(Graine.class);
	}
	
	public void zombie() {
		this.setImage(new File(Variables.INSECTESPATH  + "mouchetestZombie.png"));
		this.setCanibale(true);
		this.setSpeedTire(0);
		this.speedMove=1;
	}
	
	public void normal() {
		this.setImage(new File(Variables.INSECTESPATH + "mouchetest.png"));
		this.setCanibale(false);
		setSpeedTire(2);
		this.speedMove=2;
	}
}