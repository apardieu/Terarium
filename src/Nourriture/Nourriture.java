package Nourriture;

import Objets.Objet;

public abstract class Nourriture extends Objet{
	private int foodPower;
	
	public int getFoodPower() {
		return foodPower;
	}
	public void setFoodPower(int foodPower) {
		this.foodPower = foodPower;
	}
}