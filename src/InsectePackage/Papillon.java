package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class Papillon extends Herbivore{
	public Papillon() {
		super();
		this.isFlying = true;
		int alea = (int) (Math.random() * 100);
		setImage(new File(Variables.INSECTESPATH + "papillon/papillonBleuDroite.png"));
		String couleur;
		if(alea>50)
			couleur = "Bleu";
		else if(alea > 10 & alea <51)
			couleur = "Rouge";
		else
			couleur = "Rare";
		setImageDroite(new File(Variables.INSECTESPATH  + "papillon/papillon" + couleur + "Droite.png"));
		setImageGauche(new File(Variables.INSECTESPATH  + "papillon/papillon" + couleur + "Gauche.png"));
		setPrice(2000);
		revenu = 1200;
		hTerra=121;
		lTerra=108;
	}
	
	public Papillon(String name) {
		this();
		this.name = name;
	}
}
