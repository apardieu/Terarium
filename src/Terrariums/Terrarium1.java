package Terrariums;

import java.io.File;

public class Terrarium1 extends Terrarium{
	public Terrarium1() {
		setName("Terrarium1");
		setCapacity(15);
		nbInsecte = 0;
		setImage(new File("fond.jpg"));
		setPrice(3000);
	}
}
