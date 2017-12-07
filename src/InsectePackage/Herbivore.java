package InsectePackage;

import java.io.File;

public class Herbivore extends Insecte{
	public Herbivore() {
		name = "Herbivore";
		foodLevel=(int) (getMaxFoodLevel()*0.5);
		setImage(new File("resources/mouchetest.png"));
		setPrice(500);
		setCanibale(false);
	}
	
	public Herbivore(String n, int a, int b) {
		name = n;
		setX(a);
		setY(b);
		foodLevel=50000;
		setImage(new File("resources/mouchetest.png"));
	}
	
	public void zombie() {
		this.setImage(new File("resources/mouchetestZombie.png"));
		this.setCanibale(true);
	}
	
	public void normal() {
		this.setImage(new File("resources/mouchetest.png"));
		this.setCanibale(false);
	}
}