package IHMPackage;

import java.awt.CardLayout;

import javax.swing.JPanel;

import MainPackage.Player;

public class PreviewTerrarium extends JPanel{
	private static final long serialVersionUID = -7139645551109818022L;
	protected CardLayout cl = null;
	
	public PreviewTerrarium(Player p) {
		cl = new CardLayout();
		setLayout(cl);
		
		//Add the two view with Terrarium first
		
		for(int i=0; i<p.getListeTerarium().size(); i++) {
			this.add(new TerariumView(p.getListeTerarium().get(i)), "terrarium" + i);
		}
	}
	
	//Show the boutique
	
	public void next() {
		cl.next(this);
	}
	
	//Show the terrarium
	
	public void prev() {
		cl.previous(this);
	}
}
