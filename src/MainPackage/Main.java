package MainPackage;
import IHMPackage.IHM;

public class Main {

	public static void main(String[] args) {
		Terarium t1 = new Terarium();
		IHM ihm = new IHM(t1);
		GameController GC = new GameController(t1, ihm);
		GC.start();
	}
}