package MainPackage;
import IHMPackage.IHM;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Papillon;
import Nourriture.Graine;
import Nourriture.Viande;
import Objets.Inventaire;
import Terrariums.Terrarium;
import Terrariums.Terrarium1;
import Terrariums.Terrarium2;
import Terrariums.Terrarium3;

public class Main {
	public static void main(String[] args) {
		Terrarium t1 = new Terrarium1();
		Player p1 = new Player();
		p1.addTerrarium(t1);
		IHM ihm = null;
		Inventaire boutique = new Inventaire(p1);
		boutique.add(new Carnivore());
		boutique.add(new Herbivore());
		boutique.add(new Papillon());
		boutique.add(new Terrarium1());
		boutique.add(new Terrarium2());
		boutique.add(new Terrarium3());
		boutique.add(new Graine());
		boutique.add(new Viande());
		GameController GC = new GameController(p1, ihm);
		ihm = new IHM(p1, boutique, true, GC);
		GC.setIhm(ihm);
		GC.start();
	}
}