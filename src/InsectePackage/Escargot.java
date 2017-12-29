package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class Escargot extends Herbivore{
	public Escargot() {
		super();
		image = new File(Variables.INSECTESPATH + "escargot/EscargotDroite.png");
		imageDroite = new File(Variables.INSECTESPATH  + "escargot/EscargotDroite.png");
		imageGauche = new File(Variables.INSECTESPATH  + "escargot/EscargotGauche.png");
		price = 1200;
		hTerra=121;
		lTerra=108;
		this.speedMove = 1;
	}
	
	public Escargot(String name) {
		this();
		this.name = name;
		if(name.equals(new String("Raphael"))) {
			image = new File(Variables.INSECTESPATH + "escargot/EscargotRaphDroite.png");
			imageDroite = new File(Variables.INSECTESPATH  + "escargot/EscargotRaphDroite.png");
			imageGauche = new File(Variables.INSECTESPATH  + "escargot/EscargotRaphGauche.png");
		}
		else if(name.equals(new String("Donatello"))) {
			image = new File(Variables.INSECTESPATH + "escargot/EscargotDonaDroite.png");
			imageDroite = new File(Variables.INSECTESPATH  + "escargot/EscargotDonaDroite.png");
			imageGauche = new File(Variables.INSECTESPATH  + "escargot/EscargotDonaGauche.png");
		}
		else if(name.equals(new String("Leonardo"))) {
			image = new File(Variables.INSECTESPATH + "escargot/EscargotLeoDroite.png");
			imageDroite = new File(Variables.INSECTESPATH  + "escargot/EscargotLeoDroite.png");
			imageGauche = new File(Variables.INSECTESPATH  + "escargot/EscargotLeoGauche.png");
		}
		else if(name.equals(new String("Michelangelo"))) {
			image = new File(Variables.INSECTESPATH + "escargot/EscargotMichelDroite.png");
			imageDroite = new File(Variables.INSECTESPATH  + "escargot/EscargotMichelDroite.png");
			imageGauche = new File(Variables.INSECTESPATH  + "escargot/EscargotMichelGauche.png");
		}
	}
}
