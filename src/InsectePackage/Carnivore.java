package InsectePackage;

import java.io.File;

public class Carnivore extends Insecte{
	public Carnivore() {
		name = "Carnivore";
		foodLevel=(int) (getMaxFoodLevel()*0.3);
		setImage(new File("resources/carnivore.png"));
		setPrice(1000);
		setCanibale(true);
		setSpeedTire(3);
		percentageStolen = 10;
		speedMove=1;
		hTerra=121;
		lTerra=108;
	}
}