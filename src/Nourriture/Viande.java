package Nourriture;

import java.io.File;

public class Viande extends Nourriture{
	public Viande() {
		setName("viande");
		setPrice(50);
		setImage(new File("viande.png"));
		setFoodPower(300);
	}
}
