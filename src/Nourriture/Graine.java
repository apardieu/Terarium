package Nourriture;

import java.io.File;

import MainPackage.Variables;

public class Graine extends Nourriture{
	public Graine() {
		setName("graine");
		setPrice(10);
		setImage(new File(Variables.NOURRITUREPATH + "graine.png"));
		setFoodPower(100);
	}
}