package InsectePackage;
public class Carnivore extends Insecte{
	public Carnivore() {
		name = "Carnivore";
		foodLevel=30;
		vivre();
	}
	
	public Carnivore(String n, int a, int b) {
		name = n;
		setX(a);
		setY(b);
		foodLevel=30;
		vivre();
	}
	
	public void kill(Insecte m) {
		if ((foodLevel+m.foodLevel/10)<100)
			foodLevel+=m.foodLevel/10;
		else
			foodLevel=100;
		m.foodLevel=0;
	}
}