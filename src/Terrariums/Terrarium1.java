package Terrariums;

import java.io.File;

import Nourriture.Viande;

public class Terrarium1 extends Terrarium{
	public Terrarium1() {
		super();
		setName("Terrarium1");
		setCapacity(15);
		nbInsecte = 0;
		setImage(new File("fond.jpg"));
		setPrice(3000);
		mangeoire.setNourriture(new Viande());
	}
}
