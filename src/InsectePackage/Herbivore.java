package InsectePackage;
public class Herbivore extends Insecte{
	public Herbivore() {
		name = "Herbivore";
		foodLevel=50;
		vivre();
	}
	
	public Herbivore(String n, int a, int b) {
		name = n;
		setX(a);
		setY(b);
		foodLevel=50;
		vivre();
	}
}
