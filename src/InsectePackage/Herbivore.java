package InsectePackage;

import java.io.File;

public class Herbivore extends Insecte{
	public Herbivore() {
		name = "Herbivore";
		foodLevel=(int) (getMaxFoodLevel()*0.5);
		setImage(new File("resources/mouchetest.png"));
		setPrice(500);
		setCanibale(false);
		setSpeedTire(2);
		speedMove=2;
	}
	
	public void zombie() {
		this.setImage(new File("resources/mouchetestZombie.png"));
		this.setCanibale(true);
		this.setSpeedTire(0);
		this.speedMove=1;
	}
	
	public void normal() {
		this.setImage(new File("resources/mouchetest.png"));
		this.setCanibale(false);
		setSpeedTire(2);
		this.speedMove=1;
	}
}