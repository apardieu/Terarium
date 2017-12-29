package Nourriture;

import java.io.File;

import MainPackage.Variables;

public class Viande extends Nourriture{
	public Viande() {
		super();
		name = "Viande";
		price = 50;
		image = new File(Variables.NOURRITUREPATH + "viande.png");
		foodPower = 300;
	}
}
