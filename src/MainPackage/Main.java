package MainPackage;
import IHMPackage.IHM;

public class Main {

	public static void main(String[] args) {
		Terarium t1 = new Terarium();
		Player p1 = new Player();
		p1.addTerarium(t1);
		IHM ihm = new IHM(t1, p1);
		GameController GC = new GameController(t1, p1, ihm);
		GC.start();
	}
}