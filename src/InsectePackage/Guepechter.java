package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class Guepechter extends Herbivore {
	
	public Guepechter()
	{
	super();
	this.isFlying = true;
	image = new File(Variables.INSECTESPATH + "Guepechter/GuepechterDroite.png");
	imageDroite = new File(Variables.INSECTESPATH + "Guepechter/GuepechterDroite.png");
	imageGauche = new File(Variables.INSECTESPATH + "Guepechter/GuepechterGauche.png");
	price = 5000;
	this.setName("Franck");
	hTerra=121;
	lTerra=108;
	this.speedMove = 2;
	vendable = false;
	}

}
