package MainPackage;
import IHMPackage.IHM;

public class GameController extends Thread{
	private Terarium terarium;
	private IHM ihm;
	
	public GameController(Terarium terarium, IHM ihm) {
		this.terarium = terarium;
		this.ihm = ihm;
	}
	
	//Thread move the insects, refresh data (time, money etc) and repaint the gui
	
	public void run() {
		while(true) {
			terarium.deplacerInsectes();
			ihm.refreshData(terarium);
			ihm.repaint();
		}
	}
}
