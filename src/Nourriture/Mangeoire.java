package Nourriture;

import java.io.File;

import Objets.Objet;

public class Mangeoire extends Objet{
	protected Nourriture nourriture;
	protected int nbNourriture;
	protected int maxNbNourriture = 300000;
	
	public Mangeoire(Nourriture nourriture) {
		this.setImage(new File("mangeoireVide.png"));
		this.nourriture = nourriture;
		nbNourriture = 0;
	}	
	
	public void remplir(int nb) {
		nbNourriture = (nbNourriture+nb)>maxNbNourriture? maxNbNourriture : nbNourriture+nb;
		updateImage();
	}
	
	public void updateImage() {
		if (nbNourriture>=maxNbNourriture*0.8) {
			this.setImage(new File("mangeoirePlein.png"));
		}
		else if (nbNourriture>=maxNbNourriture*0.2 & nbNourriture<maxNbNourriture*0.8) {
			this.setImage(new File("mangeoireMiPlein.png"));
		}
		else if (nbNourriture<maxNbNourriture*0.2 & nbNourriture!=0) {
			this.setImage(new File("mangeoirePresqueVide.png"));
		}
		else if (nbNourriture==0) {
			this.setImage(new File("mangeoireVide.png"));
		}
	}
	
	public Nourriture getNourriture() {
		return nourriture;
	}

	public void setNbNourriture(int nbNourriture) {
		updateImage();
		this.nbNourriture = nbNourriture;
	}

	public int getNbNourriture() {
		return nbNourriture;
	}
}
