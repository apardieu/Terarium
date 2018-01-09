package IHMPackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import InsectePackage.Oeuf;
import MainPackage.Player;
import MainPackage.Variables;
import Objets.Objet;

public class VenteListObjet extends JPanel{
	private static final long serialVersionUID = -2328453369007393762L;
	private List<? extends Objet> listeObjet = new LinkedList<Objet>();
	private int nbPage;
	private ImageButton mainButton = null;
	private ImageButton nextButton = null;
	private ImageButton prevButton = null;
	private File fond = new File(Variables.FONDSPATH + "vitrine.jpg");
	private int nbElementPage = 0;
	private int h = 1;
	private int l = 1;
	private final int marge = 20;
	private final int largeur = 1340;
	private final int hauteur = 640;
	private final int xCadre = 55;
	private final int yCadre = 140;
	private Player player;
	private int nbElement;
	private int nbOeuf;
	private String nameTerra;
	
	public VenteListObjet(Player player) {
		this.setLayout(null);
		this.player	= player;
		this.listeObjet = player.getCurrentTerrarium().getListeInsecte();
		nameTerra = player.getCurrentTerrarium().getName();
		nbPage=0;
	    update();
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		//Drawing the background of the shop
		
	    try {
	    	g.drawImage(ImageIO.read(fond), 0, 0, this.getWidth(), this.getHeight(), null);
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    
	    if(player.getCurrentTerrarium().getListeInsecte().size()!=nbElement)
	    	update();
	    
	    if(nbOeuf!= calNbOeuf()) 
	    	update();
	    
	    if(!(nameTerra.equals(player.getCurrentTerrarium().getName())))
	    	update();
	}
	
	public void update() {
		nbElement = listeObjet.size();
		nbOeuf = calNbOeuf();
		nameTerra = player.getCurrentTerrarium().getName();
		this.removeAll();
		mainButton = new ImageButton("mainBoutton.png", 1200, 8, 100, 100, false);
		nextButton = new ImageButton("nextArrow.png", 1210, 850, 100, 100, true);
		prevButton = new ImageButton("prevArrow.png", 55, 850, 100, 100, true);
		nextButton.addActionListener(new NextPage());
		prevButton.addActionListener(new PrevPage());
		this.listeObjet = player.getCurrentTerrarium().getListeInsecte();
	    this.add(mainButton);
	    this.add(nextButton);
	    this.add(prevButton);
	    if(listeObjet.size()>0) {
	    	h=listeObjet.get(0).gethShop();
	    	l=listeObjet.get(0).getlShop();
	    }
	    	
		int x=xCadre, y=yCadre;
	    x+=marge;
	    y+=marge;
	    nbElementPage = (largeur/(l+marge)) * (hauteur/(h+marge));
	    
	    for(int i=nbPage*nbElementPage; (i<(nbPage+1)*nbElementPage & i<listeObjet.size()); i++) {
	    	Objet o = listeObjet.get(i);
	    	if(!(o instanceof Oeuf)){

	        	ObjetVitrine objetVitrine = new ObjetVitrine(o, x, y, l, h);
	        	this.add(objetVitrine); 
	        	
	        	//Change line
	        	if((x+l+marge+l)>=xCadre+largeur) {
	        		x=xCadre+marge;
	        		y+=h+marge;
	        	}
	        	//Change Column
	        	else
	        		x+=l+marge;
	    	}
    	}
	    
	    if(nbPage==listeObjet.size()/nbElementPage)
	    	nextButton.lock();
    	else
    		nextButton.unlock();
    		
    	if(nbPage==0) 
    		prevButton.lock();
    	else
    		prevButton.unlock();
	}
	
	public int calNbOeuf() {
		nbElementPage = (largeur/(l+marge)) * (hauteur/(h+marge));
		int nbOeufCal = 0;
	    for(int i=nbPage*nbElementPage; (i<(nbPage+1)*nbElementPage & i<listeObjet.size()); i++) {
	    	Objet o = listeObjet.get(i);
	    	if(o instanceof Oeuf)
	    		nbOeufCal++;
	    }
	    return nbOeufCal;
	}
	
	class NextPage implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nbPage++;
			update();
		}
	}
	
	class PrevPage implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			nbPage--;
			update();
		}
	}

	public Player getPlayer() {
		return player;
	}
}