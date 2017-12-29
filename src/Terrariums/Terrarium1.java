package Terrariums;

import java.io.File;

import MainPackage.Variables;
import Nourriture.Viande;

public class Terrarium1 extends Terrarium{
	public Terrarium1() {
		super();
		name = "Terrarium1";
		capacity = 5;
		nbInsecte = 0;
		image = new File(Variables.TERRARIUMSPATH + "fond.jpg");
		price = 3000;
		mangeoire.setNourriture(new Viande());
	}
	
	public void vendu() {
		image = new File(Variables.TERRARIUMSPATH + "fondVendu.jpg");
	}
}
