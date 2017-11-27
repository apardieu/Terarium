package InsectePackage;
public class Carnivore extends Insecte{
	public Carnivore() {
		name = "Carnivore";
		foodLevel=30;
	}
	
	public Carnivore(String n, int a, int b) {
		name = n;
		setX(a);
		setY(b);
		foodLevel=30;
	}
	
	public void kill(Insecte m) {
		foodLevel+=m.foodLevel/10;
		m.foodLevel=0;
	}
}