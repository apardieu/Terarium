package Objets;

import InsectePackage.Insecte;
import Nourriture.Nourriture;

public class Objet{
	private int price;
	private Insecte insecte;
	protected Soins soin;
	protected Substrat substrat;
	protected Nourriture food;
	
	public Objet(int price, Insecte insecte) {
		this.setPrice(price);
		this.setInsecte(insecte);
	}
	
	public Objet(int price, Soins soin) {
		this.setPrice(price);
		this.soin = soin;
	}
	
	public Objet(int price, Substrat substrat) {
		this.setPrice(price);
		this.substrat = substrat;
	}
	
	public Objet(int price, Nourriture food) {
		this.setPrice(price);
		this.food = food;
	}

	public Insecte getInsecte() {
		return insecte;
	}

	public void setInsecte(Insecte insecte) {
		this.insecte = insecte;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}