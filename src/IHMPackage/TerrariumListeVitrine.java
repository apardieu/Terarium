package IHMPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Objets.Objet;
import Terrariums.Terrarium;

public class TerrariumListeVitrine extends JPanel implements MouseListener{
	private static final long serialVersionUID = 5392673749438244817L;
	protected boolean insecteShop;
	protected boolean mainShop;
	protected boolean vitrine;
	private List<Terrarium> listeTerrarium = new LinkedList<Terrarium>();
	protected int nbPage;
	protected boolean next;
	protected boolean prev;
	protected File nextArrow = new File("nextArrowLocked.png");
	protected File prevArrow = new File("prevArrowLocked.png");
	protected Objet objet;
	public boolean visible;
	
	public TerrariumListeVitrine(List<Terrarium> list) {
		this.listeTerrarium = list;
		visible=false;
		this.addMouseListener(this);
		nbPage=0;
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		//Drawing the background of the shop and add the main button
		
	    try {
	    	g.drawImage(ImageIO.read(new File("boutique.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
	    	g.drawImage(ImageIO.read(new File("main.png")), 716*this.getWidth()/809, 10*this.getHeight()/604, 65*this.getWidth()/809, 57*this.getHeight()/604, null);
	    } catch (IOException e) {
			e.printStackTrace();
		}
	    
	    ///!\CHANTIER!!! Creer une methode draw objet et mettre les valeurs dans des variables nan mais ohhh !!!!
	    
	    int x=75, y=110;
	    int h=80, l=60;
	    for(int i=nbPage*21; (i<(nbPage+1)*21 & i<listeTerrarium.size()); i++) {
        	Objet o = listeTerrarium.get(i);
        	try {
        		g.setColor(Color.BLACK);
        		g.fillRect((x-15)*this.getWidth()/809, (y-15)*this.getHeight()/604, (l+30)*this.getWidth()/809, (h+30)*this.getHeight()/604);
        		g.setColor(Color.WHITE);
        		g.fillRect((x-10)*this.getWidth()/809, (y-10)*this.getHeight()/604, (l+20)*this.getWidth()/809, (h+20)*this.getHeight()/604);
        		g.drawImage(ImageIO.read(o.getImage()), x*this.getWidth()/809, y*this.getHeight()/604,l*this.getWidth()/809, h*this.getHeight()/604, null);
        		g.setColor(Color.BLACK);
        		g.setFont(new Font("Dialog", Font.BOLD, 15*this.getWidth()/809));
        		g.drawString("Price : " + o.getPrice(), (x-15)*this.getWidth()/809, (y+h+30)*this.getHeight()/604);
        		o.setxShop((x-15)*this.getWidth()/809);
        		o.setlShop((l+30)*this.getWidth()/809);
        		o.sethShop((h+30)*this.getHeight()/604);
        		o.setyShop((y-15)*this.getHeight()/604);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	//Change line
        	if((x+l+25+l+30)*this.getWidth()/809>this.getWidth()) {
        		x=75;
        		y+=h+60;
        	}
        	//Change Column
        	else
        		x+=l+40;
        	
        	if(nbPage==listeTerrarium.size()/21) {
        		next=false;
        		nextArrow = new File("nextArrowLocked.png");
        	}
        	else {
        		next=true;
        		nextArrow = new File("nextArrow.png");
        	}
        	if(nbPage==0) {
        		prev=false;
        		prevArrow = new File("prevArrowLocked.png");
        	}
        	else {
        		prev=true;
        		prevArrow = new File("prevArrow.png");
        	}
    	}
	    try {
	    	g.drawImage(ImageIO.read(nextArrow), 700*this.getWidth()/809, 525*this.getHeight()/604, 60*this.getWidth()/809, 60*this.getHeight()/604, null);
	    	g.drawImage(ImageIO.read(prevArrow), 40*this.getWidth()/809, 525*this.getHeight()/604, 60*this.getWidth()/809, 60*this.getHeight()/604, null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Go to mainShop
		if(e.getX()>716*this.getWidth()/809 & e.getX()<781*this.getWidth()/809 & e.getY()>10*this.getHeight()/604 & e.getY()<67*this.getHeight()/604) {
			nbPage=0;
			if(this.getParent() instanceof BoutiqueView)
				((BoutiqueView) this.getParent()).getCl().show((BoutiqueView) this.getParent(), "mainShop");
			if(this.getParent() instanceof InventaireView)
				((InventaireView) this.getParent()).getCl().show((InventaireView) this.getParent(), "main");
			
		}
			
		//Change page by create clickable arrows
		
		if(next==true) {
			if(e.getX()>700*this.getWidth()/809 & e.getX()<760*this.getWidth()/809 & e.getY()>525*this.getHeight()/604 & e.getY()<585*this.getHeight()/604) {
				nbPage++;
			}
		}
		if(prev==true) {
			if(e.getX()>40*this.getWidth()/809 & e.getX()<100*this.getWidth()/809 & e.getY()>525*this.getHeight()/604 & e.getY()<585*this.getHeight()/604) {
				nbPage--;
			}
		}
		
		//Create clickable image
		
		for(int i=nbPage*21; (i<(nbPage+1)*21 & i<listeTerrarium.size()); i++) {
			Objet o = listeTerrarium.get(i);
			if(e.getX()>o.getxShop() & e.getX()<(o.getxShop()+o.getlShop()) & e.getY()>o.getyShop() & e.getY()<(o.getyShop()+o.gethShop())) {
				if (this.getParent() instanceof InventaireView) {
					//Print informations
				}
				else {
					((BoutiqueView) this.getParent()).setObjet(o);
					((BoutiqueView) this.getParent()).getCl().show((BoutiqueView) this.getParent(), "vitrine");
				}
			}
		}
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
