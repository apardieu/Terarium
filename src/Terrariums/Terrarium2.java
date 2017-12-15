package Terrariums;

import java.io.File;

public class Terrarium2 extends Terrarium {
	public Terrarium2() {
		setName("Terrarium2");
		setCapacity(20);
		nbInsecte = 0;
		setImage(new File("fond2.jpg"));
		setPrice(3000);
	}
}
