package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class FourmisNoire extends Herbivore {
	
	
	public FourmisNoire()
	{
		super();
		image = new File(Variables.INSECTESPATH + "Fourmis/FourmisNoireDroite.png");
		imageDroite = new File(Variables.INSECTESPATH + "Fourmis/FourmisNoireDroite.png");
		imageGauche = new File(Variables.INSECTESPATH + "Fourmis/FourmisNoireGauche.png");
		this.setName("Fourmis Noire");
		price = 500;
		hTerra=100;
		lTerra=140;
	}

}
