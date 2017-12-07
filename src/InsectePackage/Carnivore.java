package InsectePackage;

import java.io.File;

public class Carnivore extends Insecte{
	public Carnivore() {
		name = "Carnivore";
		foodLevel=(int) (getMaxFoodLevel()*0.3);
		setImage(new File("resources/carnivore.png"));
		setPrice(1000);
	}
	
	//Kill an insect and win 10% of the life of the victim
	
	public void kill(Insecte m) {
		if ((foodLevel+m.foodLevel/10)<this.getMaxFoodLevel())
			foodLevel+=m.foodLevel/10;
		else
			foodLevel=this.getMaxFoodLevel();
		m.foodLevel=0;
	}
}