package Terrariums;

import java.io.File;

import MainPackage.Variables;

public class Terrarium3 extends Terrarium{
	public Terrarium3() {
		super();
		setName("Terrarium3");
		setCapacity(10);
		nbInsecte = 0;
		setImage(new File(Variables.TERRARIUMSPATH + "fond3.jpg"));
		setPrice(3000);
	}
}
