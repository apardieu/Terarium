package InsectePackage;

import java.io.File;

public class Herbivore extends Insecte{
	public Herbivore() {
		name = "Herbivore";
		foodLevel=(int) (getMaxFoodLevel()*0.5);
		setImage(new File("resources/mouchetest.png"));
		setPrice(500);
	}
	
	public Herbivore(String n, int a, int b) {
		name = n;
		setX(a);
		setY(b);
		foodLevel=50000;
		setImage(new File("resources/mouchetest.png"));
	}
}