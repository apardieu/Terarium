package MainPackage;
import IHMPackage.IHM;

public class GameController extends Thread{
	private Terarium terarium;
	private Player player;
	private IHM ihm;
	
	public GameController(Terarium terarium, Player player, IHM ihm) {
		this.terarium = terarium;
		this.player = player;
		this.ihm = ihm;
	}
	
	//Thread move the insects, refresh data (time, money etc) and repaint the gui
	
	public void run() {
		while(true) {
			terarium.deplacerInsectes();
			ihm.refreshData(terarium, player);
			ihm.repaint();
		}
	}
}
