package MainPackage;
import java.util.List;

import IHMPackage.IHM;
import Terrariums.Terrarium;

public class GameController extends Thread{
	private Player player;
	private IHM ihm;
	
	public GameController(Player player, IHM ihm) {
		this.player = player;
		this.ihm = ihm;
	}
	
	//Thread move the insects, refresh data (time, money etc) and repaint the gui
	
	public void run() {
		while(true) {
			List<Terrarium> listeTerrarium = player.getListeTerrarium();
			for(int i = 0; i<listeTerrarium.size(); i++)
				listeTerrarium.get(i).deplacerInsectes();
			ihm.refreshData(player);
			ihm.repaint();

		}
	}

	public void setIhm(IHM ihm) {
		this.ihm = ihm;
	}
}
