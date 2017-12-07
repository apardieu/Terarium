package InsectePackage;

import java.io.File;

public class Carnivore extends Insecte{
	public Carnivore() {
		name = "Carnivore";
		foodLevel=(int) (getMaxFoodLevel()*0.3);
		setImage(new File("resources/carnivore.png"));
		setPrice(1000);
	}
	
	public Carnivore(String n, int a, int b) {
		name = n;
		setX(a);
		setY(b);
		foodLevel=30;
		setImage(new File("resources/carnivore.png"));
	}
	
	public void kill(Insecte m) {
		if ((foodLevel+m.foodLevel/10)<this.getMaxFoodLevel())
			foodLevel+=m.foodLevel/10;
		else
			foodLevel=this.getMaxFoodLevel();
		m.foodLevel=0;
	}
}