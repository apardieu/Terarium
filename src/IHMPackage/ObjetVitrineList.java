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

import MainPackage.Variables;
import Objets.Objet;

public class ObjetVitrineList extends JPanel{
	private static final long serialVersionUID = -2328453369007393762L;
	private List<? extends Objet> listeObjet = new LinkedList<Objet>();
	private int nbPage;
	private ImageButton mainButton = null;
	private ImageButton nextButton = null;
	private ImageButton prevButton = null;
	private File fond = new File(Variables.FONDSPATH + "vitrine.jpg");
	private String nom;
	private int nbElementPage = 0;
	private final int marge = 20;
	private final int largeur = 1340;
	private final int hauteur = 640;
	private final int xCadre = 55;
	private final int yCadre = 140;
	
	public ObjetVitrineList(List<? extends Objet> list, String nom) {
		this.setLayout(null);
		this.listeObjet = list;
		this.nom = nom;
		nbPage=0;
	    update();
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		//Drawing the background of the shop and add the main button
		
	    try {
	    	g.drawImage(ImageIO.read(fond), 0, 0, this.getWidth(), this.getHeight(), null);
	    } catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		this.removeAll();
		mainButton = new ImageButton("mainBoutton.png", 1200, 8, 100, 100, false);
		nextButton = new ImageButton("nextArrow.png", 1210, 850, 100, 100, true);
		prevButton = new ImageButton("prevArrow.png", 55, 850, 100, 100, true);
		nextButton.addActionListener(new NextPage());
		prevButton.addActionListener(new PrevPage());
	    this.add(mainButton);
	    this.add(nextButton);
	    this.add(prevButton);
	    
		int x=xCadre, y=yCadre;
	    int h=193, l=120;
	    x+=marge;
	    y+=marge;
	    nbElementPage = (largeur/(l+marge)) * (hauteur/(h+marge));
	    
	    for(int i=nbPage*nbElementPage; (i<(nbPage+1)*nbElementPage & i<listeObjet.size()); i++) {
        	Objet o = listeObjet.get(i);

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
	    
	    if(nbPage==listeObjet.size()/nbElementPage)
	    	nextButton.lock();
    	else
    		nextButton.unlock();
    		
    	if(nbPage==0) 
    		prevButton.lock();
    	else
    		prevButton.unlock();
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

	public String getNom() {
		return nom;
	}
}