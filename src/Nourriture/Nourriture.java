package Nourriture;

import Objets.Objet;

public abstract class Nourriture extends Objet{
	protected int foodPower;
	
	public Nourriture() {
		super();
	}
	
	public int getFoodPower() {
		return foodPower;
	}
	public void setFoodPower(int foodPower) {
		this.foodPower = foodPower;
	}
}