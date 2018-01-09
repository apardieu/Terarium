package Terrariums;

import java.io.File;

import InsectePackage.Herbivore;
import InsectePackage.Sexe;
import MainPackage.Variables;

public class Terrarium3 extends Terrarium{
	public Terrarium3() {
		super();
		name = "Terrarium3";
		capacity = 10;
		nbInsecte = 0;
		image = new File(Variables.TERRARIUMSPATH + "fond3.jpg");
		price = 3000;
		Herbivore male = new Herbivore();
		Herbivore female = new Herbivore();
		System.out.println("TEST");
		male.setSexe(Sexe.MALE);
		male.setName("MALE");
		male.setFoodlevel(100000);
		male.setGestationTime(0);
		female.setSexe(Sexe.FEMALE);
		female.setFoodlevel(100000);
		female.setGestationTime(0);
		female.setName("FEMALE");
		this.addInsecte(male);
		this.addInsecte(female);
		description();
	}
}
