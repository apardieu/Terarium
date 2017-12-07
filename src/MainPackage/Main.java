package MainPackage;
import IHMPackage.IHM;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Sexe;

public class Main {

	public static void main(String[] args) {
		Terarium t1 = new Terarium();
		IHM ihm = new IHM(t1);
		GameController GC = new GameController(t1, ihm);
		GC.start();
	}
}