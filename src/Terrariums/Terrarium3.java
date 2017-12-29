package Terrariums;

import java.io.File;

import MainPackage.Variables;

public class Terrarium3 extends Terrarium{
	public Terrarium3() {
		super();
		name = "Terrarium3";
		capacity = 10;
		nbInsecte = 0;
		image = new File(Variables.TERRARIUMSPATH + "fond3.jpg");
		price = 3000;
	}
}
