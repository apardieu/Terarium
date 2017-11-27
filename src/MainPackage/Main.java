package MainPackage;
import IHMPackage.IHM;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;

public class Main {

	public static void main(String[] args) {
		/*int h = 3;
		int c = 1;
		Terarium monTerarium = new Terarium();
		
		for(int i=0; i<h; i++) {
			Herbivore b = new Herbivore();
			monTerarium.addInsecte(b);
		}
		
		for(int i=0; i<c; i++) {
			Carnivore b = new Carnivore("Jacques", 4, 0);
			monTerarium.addInsecte(b);
		}
		
		int j=0;
		while(j<10) {
			for(int i=0; i<monTerarium.listeInsecte.size()-1; i++) {
				monTerarium.listeInsecte.get(i).deplacer(1, 0);
			}
			j++;
			monTerarium.checkPosition();
			monTerarium.description();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}*/
		Terarium t1 = new Terarium();
		t1.addInsecte(new Herbivore());
		t1.addInsecte(new Carnivore());
		t1.description();
		IHM ihm = new IHM(t1);
		for(int i=0; i<600; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t1.getListeInsecte().get(0).deplacer(1, 0);
			ihm.repaint();
		}
		for(int i=0; i<300; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			t1.getListeInsecte().get(1).deplacer(1, 0);
			ihm.repaint();
		}
	}
}
