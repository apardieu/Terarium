package Nourriture;

import java.io.File;

import MainPackage.Variables;

public class Viande extends Nourriture{
	public Viande() {
		setName("viande");
		setPrice(50);
		setImage(new File(Variables.NOURRITUREPATH + "viande.png"));
		setFoodPower(300);
	}
}
