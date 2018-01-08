package Terrariums;

import java.io.File;

import InsectePackage.Guepechter;
import InsectePackage.Herbivore;
import InsectePackage.Papillon;
import InsectePackage.Sexe;
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
		Herbivore male = new Herbivore();
		Herbivore female = new Herbivore();
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
	}
	
	public void vendu() {
		image = new File(Variables.TERRARIUMSPATH + "fondVendu.jpg");
	}
}
