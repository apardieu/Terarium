package IHMPackage;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Objets.Boutique;
import Objets.Objet;

public class vitrineBoutique extends JPanel implements MouseListener{
	private static final long serialVersionUID = 2525121154772774593L;
	protected Objet objet;
	protected Boutique shop;
	public boolean visible;
	
	public vitrineBoutique(Boutique shop, Objet objet) {
		this.shop = shop;
		this.objet = objet;
		visible=false;
		this.addMouseListener(this);
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    	//Drawing the background of the shop and add the main button
    	int x=46, y=101, l=202, h=270;
        try {
        	if(shop.getPlayer().getArgent()>=objet.getPrice())
        		g.drawImage(ImageIO.read(new File("vitrine.png")), 0, 0, this.getWidth(), this.getHeight(), null);
        	else
        		g.drawImage(ImageIO.read(new File("vitrineLocked.png")), 0, 0, this.getWidth(), this.getHeight(), null);
        	g.drawImage(ImageIO.read(new File("main.png")), 716*this.getWidth()/809, 8*this.getHeight()/604, 58*this.getWidth()/809, 51*this.getHeight()/604, null);
        	g.drawImage(ImageIO.read(new File("undoArrow.png")), 35*this.getWidth()/809, 8*this.getHeight()/604, 58*this.getWidth()/809, 51*this.getHeight()/604, null);
        	g.drawImage(ImageIO.read(objet.getImage()), x*this.getWidth()/1462, y*this.getHeight()/916,l*this.getWidth()/1462, h*this.getHeight()/916, null);
        	g.drawString("Nom : " + objet.getName(), 329*this.getWidth()/1462, 111*this.getHeight()/916);
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	//A revoir

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Go to mainShop
		if(e.getX()>716*this.getWidth()/809 & e.getX()<774*this.getWidth()/809 & e.getY()>8*this.getHeight()/604 & e.getY()<59*this.getHeight()/604)
			((CardView) this.getParent()).getCl().show((CardView) this.getParent(), "mainShop");
		
		if(e.getX()>1167*this.getWidth()/1462 & e.getX()<1429*this.getWidth()/1462 & e.getY()>830*this.getHeight()/916 & e.getY()<897*this.getHeight()/916) {
			shop.buy(objet);
		}
		
		//Undo
		if(e.getX()>35*this.getWidth()/809 & e.getX()<93*this.getWidth()/809 & e.getY()>8*this.getHeight()/604 & e.getY()<59*this.getHeight()/604)
			((CardView) this.getParent()).getCl().show((CardView) this.getParent(), "insecteShop");
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
