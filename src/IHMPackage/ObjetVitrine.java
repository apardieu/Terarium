package IHMPackage;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import InsectePackage.Insecte;
import Nourriture.Nourriture;
import Objets.Objet;

public class ObjetVitrine extends JPanel implements MouseListener{
	private static final long serialVersionUID = 4012013336582860929L;
	private int l;
	private int h;
	private Objet objet;
	private Color borderColor = Color.BLACK;
	
	public ObjetVitrine(Objet objet, int x, int y, int l, int h) {
		this.objet = objet;
		this.l= l;
		this.h = h;
		this.setOpaque(false);
		this.setSize(l, h);
		this.setLocation(x, y);
		this.addMouseListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
        	try {
        		g.setColor(borderColor);
        		g.fillRect(0, 0, l, h-20);
        		g.setColor(Color.WHITE);
        		g.fillRect(5, 5, l-10, h-30);
        		g.drawImage(ImageIO.read(objet.getImage()), 15, 15, l-30, h-50, null);
        		g.setColor(Color.BLACK);
        		g.setFont(new Font("Dialog", Font.BOLD, 19));
        		if (((CardView) this.getParent().getParent()).getType() == TypeInventaire.INVENTAIRE) 
        			g.drawString(objet.getName(),0, h);
        		else
        			g.drawString("Price : " + objet.getPrice(),0, h);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (((CardView) this.getParent().getParent()).getType() == TypeInventaire.INVENTAIRE) {
			if(objet instanceof Insecte)
				((CardView) this.getParent().getParent()).inventaire.addInsecte((Insecte) objet);
			if(objet instanceof Nourriture)
				((CardView) this.getParent().getParent()).inventaire.addNourriture((Nourriture) objet);
		}
		else
			((CardView) this.getParent().getParent()).showVitrine(objet, ((ObjetVitrineList) this.getParent()).getNom());
		((ObjetVitrineList) this.getParent()).update();
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
		borderColor = Color.green;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		borderColor = Color.black;
		repaint();
	}
	
}
