package Terrariums;

import java.io.File;

import MainPackage.Variables;
import Nourriture.Viande;

public class Terrarium1 extends Terrarium{
	public Terrarium1() {
		super();
		setName("Terrarium1");
		setCapacity(5);
		nbInsecte = 0;
		setImage(new File(Variables.TERRARIUMSPATH + "fond.jpg"));
		setPrice(3000);
		mangeoire.setNourriture(new Viande());
	}
}
