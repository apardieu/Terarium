package MainPackage;
import IHMPackage.IHM;
import Terrariums.Terrarium;
import Terrariums.Terrarium1;

public class Main {

	public static void main(String[] args) {
		Terrarium t1 = new Terrarium1();
		Player p1 = new Player();
		p1.addTerrarium(t1);
		IHM ihm = new IHM(p1);
		GameController GC = new GameController(p1, ihm);
		GC.start();
	}
}