package Terrariums;

import java.io.File;

import MainPackage.Variables;
import Nourriture.Graine;

public class Terrarium2 extends Terrarium {
	public Terrarium2() {
		super();
		name = "Terrarium2";
		capacity = 8;
		nbInsecte = 0;
		image = new File(Variables.TERRARIUMSPATH + "fond2.jpg");
		price = 3000;
		mangeoire.setNourriture(new Graine());
	}
}
