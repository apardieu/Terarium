package Nourriture;

import java.io.File;

public class Graine extends Nourriture{
	public Graine() {
		setName("graine");
		setPrice(10);
		setImage(new File("graine.png"));
		setFoodPower(50);
	}
}
