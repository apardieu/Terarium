package InsectePackage;

import java.io.File;

public class Papillon extends Herbivore{
	public Papillon() {
		super();
		this.isFlying = true;
		setImage(new File("papillonDroite.png"));
		setImageDroite(new File("papillonDroite.png"));
		setImageGauche(new File("papillonGauche.png"));
		setPrice(2000);
		hTerra=121;
		lTerra=108;
	}
}
