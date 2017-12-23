package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class Papillon extends Herbivore{
	public Papillon() {
		super();
		this.isFlying = true;
		setImage(new File(Variables.INSECTESPATH + "papillonDroite.png"));
		setImageDroite(new File(Variables.INSECTESPATH  + "papillonDroite.png"));
		setImageGauche(new File(Variables.INSECTESPATH  + "papillonGauche.png"));
		setPrice(2000);
		hTerra=121;
		lTerra=108;
	}
}
