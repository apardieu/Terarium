package MainPackage;
import IHMPackage.IHM;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;

public class Main {

	public static void main(String[] args) {
		Terarium t1 = new Terarium();
		t1.addInsecte(new Herbivore());
		t1.addInsecte(new Carnivore());
		t1.description();
		IHM ihm = new IHM(t1);
		Thread thread2 = new Thread() {
			public void run() {
				for(int i=0; i<300; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					t1.getListeInsecte().get(1).deplacer(1, 0);
				}
			}
		};
		Thread thread1 = new Thread() {
			public void run() {
				for(int i=0; i<600; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					t1.getListeInsecte().get(0).deplacer(1, 0);
					if(i==300)
						thread2.start();
				}
			}
		};
		thread1.start();
		
		//Quand tu crée l'insecte tu execute le mode move.
	}
}
