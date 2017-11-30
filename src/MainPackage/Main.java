package MainPackage;
import IHMPackage.IHM;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Sexe;

public class Main {

	public static void main(String[] args) {
		Terarium t1 = new Terarium();
		Herbivore h = new Herbivore();
		h.setSexe(Sexe.MALE);
		h.setX(300);
		t1.addInsecte(h);
		t1.addInsecte(new Carnivore());
		t1.description();
		IHM ihm = new IHM(t1);
	}
}
