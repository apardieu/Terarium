package Nourriture;

import java.io.File;

import MainPackage.Variables;
import Objets.Objet;

public class Mangeoire extends Objet{
	protected Nourriture nourriture;
	protected int nbNourriture;
	protected int maxNbNourriture = 300000;
	
	public Mangeoire(Nourriture nourriture) {
		this.setImage(new File(Variables.MANGEOIRESPATH + "mangeoireVide.png"));
		this.nourriture = nourriture;
		hTerra = 100;
		lTerra = 100;
		this.setxTerra((Variables.LARGEUR - lTerra)/2);
		this.setyTerra(Variables.HAUTEUR - hTerra);
		nbNourriture = 0;
	}	
	
	public void remplir(Nourriture aliment) {
		nbNourriture = (nbNourriture+aliment.getFoodPower())>maxNbNourriture? maxNbNourriture : nbNourriture+aliment.getFoodPower();
		updateImage();
	}
	
	public void updateImage() {
		String type = nourriture.getClass().getSimpleName();
		if (nbNourriture>=maxNbNourriture*0.8) {
			this.setImage(new File(Variables.MANGEOIRESPATH + "mangeoirePlein" + type + ".png"));
		}
		else if (nbNourriture>=maxNbNourriture*0.2 & nbNourriture<maxNbNourriture*0.8) {
			this.setImage(new File(Variables.MANGEOIRESPATH + "mangeoireMiPlein" + type + ".png"));
		}
		else if (nbNourriture<maxNbNourriture*0.2 & nbNourriture!=0) {
			this.setImage(new File(Variables.MANGEOIRESPATH + "mangeoirePresqueVide" + type + ".png"));
		}
		else if (nbNourriture==0) {
			this.setImage(new File(Variables.MANGEOIRESPATH + "mangeoireVide" + type + ".png"));
		}
	}
	
	public Nourriture getNourriture() {
		return nourriture;
	}

	public void setNourriture(Nourriture nourriture) {
		this.nourriture = nourriture;
	}

	public void setNbNourriture(int nbNourriture) {
		updateImage();
		this.nbNourriture = nbNourriture;
	}

	public int getNbNourriture() {
		return nbNourriture;
	}
}
