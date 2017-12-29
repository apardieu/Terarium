package IHMPackage;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import MainPackage.Player;

public class PreviewTerrarium extends JPanel implements MouseListener{
	private static final long serialVersionUID = -7139645551109818022L;
	private CardLayout cl = null;
	private Player player;
	private int currentPreview = 0;
	private int nbTerrarium = 0;
	
	public PreviewTerrarium(Player player) {
		cl = new CardLayout();
		setLayout(cl);
		this.player=player;
		this.addMouseListener(this);
		
		//Add the two view with Terrarium first
		nbTerrarium = player.getListeTerrarium().size();
		for(int i=0; i<nbTerrarium; i++) {
			this.add(new TerrariumView(player.getListeTerrarium().get(i)), "Terrarium" + i);
		}
		cl.first(this);
	}

	public void update() {
		this.removeAll();
		nbTerrarium  = player.getListeTerrarium().size();
		for(int i=0; i<nbTerrarium; i++) {
			this.add(new TerrariumView(player.getListeTerrarium().get(i)), "Terrarium" + i);
		}
	}
	
	//Show the boutique
	
	public void next() {
		update();
		currentPreview = (currentPreview+1)%player.getListeTerrarium().size();
		cl.show(this, "Terrarium" + currentPreview);
	}
	
	//Show the terrarium
	
	public void prev() {
		update();
		if(currentPreview==0)
			currentPreview = player.getListeTerrarium().size()-1;
		else
			currentPreview--;
		cl.show(this, "Terrarium" + currentPreview);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		player.setCurrentTerrarium(player.getListeTerrarium().get(currentPreview));
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
