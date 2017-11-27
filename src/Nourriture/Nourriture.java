package Nourriture;
public abstract class Nourriture {
	protected String name;
	private int foodPower;
	public int getFoodPower() {
		return foodPower;
	}
	public void setFoodPower(int foodPower) {
		this.foodPower = foodPower;
	}
}