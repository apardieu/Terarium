package InsectePackage;

import java.io.File;

public class Herbivore extends Insecte{
	public Herbivore() {
		name = "Herbivore";
		foodLevel=50;
		setImage(new File("resources/mouchetest.png"));
	}
	
	public Herbivore(String n, int a, int b) {
		name = n;
		setX(a);
		setY(b);
		foodLevel=50;
		setImage(new File("resources/mouchetest.png"));
	}
}