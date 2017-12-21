package Terrariums;

import java.io.File;

import Nourriture.Graine;

public class Terrarium2 extends Terrarium {
	public Terrarium2() {
		super();
		setName("Terrarium2");
		setCapacity(20);
		nbInsecte = 0;
		setImage(new File("fond2.jpg"));
		setPrice(3000);
		mangeoire.setNourriture(new Graine());
	}
}
