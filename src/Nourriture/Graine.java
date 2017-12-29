package Nourriture;

import java.io.File;

import MainPackage.Variables;

public class Graine extends Nourriture{
	public Graine() {
		super();
		name = "graine";
		price = 10;
		image = new File(Variables.NOURRITUREPATH + "graine.png");
		foodPower = 100;
	}
}