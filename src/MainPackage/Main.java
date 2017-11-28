package MainPackage;
import IHMPackage.IHM;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;

public class Main {

	public static void main(String[] args) {
		Terarium t1 = new Terarium();
		Herbivore h = new Herbivore();
		h.setX(300);
		t1.addInsecte(h);
		t1.addInsecte(new Carnivore());
		t1.description();
		IHM ihm = new IHM(t1);

		
		//Quand tu crée l'insecte tu execute le mode move.
	}
}
