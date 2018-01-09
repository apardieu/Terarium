package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class FourmisRouge extends Carnivore {
	
	public FourmisRouge()
	{
		super();
		image = new File(Variables.INSECTESPATH + "Fourmis/FourmisRougeDroite.png");
		imageDroite = new File(Variables.INSECTESPATH + "Fourmis/FourmisRougeDroite.png");
		imageGauche = new File(Variables.INSECTESPATH + "Fourmis/FourmisRougeGauche.png");
		this.setName("Fourmis Rouge");
		price = 600;
		hTerra=100;
		lTerra=140;
	}
	

}
