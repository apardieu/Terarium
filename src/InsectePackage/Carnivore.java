package InsectePackage;

import java.io.File;

import MainPackage.Variables;
import Nourriture.Viande;

public class Carnivore extends Insecte{
	public Carnivore() {
		name = "Carnivore";
		foodLevel=(int) (getMaxFoodLevel()*0.3);
		setImage(new File(Variables.INSECTESPATH + "carnivore.png"));
		imageDroite = getImage();
		imageGauche = getImage();
		setPrice(1000);
		setCanibale(true);
		setSpeedTire(3);
		percentageStolen = 10;
		speedMove=1;
		hTerra=121;
		lTerra=108;
		acceptedFood.add(Viande.class);
	}
	
	public Carnivore(String name) {
		this();
		this.name = name;
	}
}