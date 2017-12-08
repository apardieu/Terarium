package IHMPackage;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import Objets.Boutique;

public class mainBoutique extends JPanel implements MouseListener{
	private static final long serialVersionUID = -1758625270358921797L;
	protected Boutique shop;
	
	public mainBoutique(Boutique shop) {
		this.shop=shop;
		this.addMouseListener(this);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
			g.drawImage(ImageIO.read(new File("mainShop.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
		//Go to InsecteShop
			if(e.getX()>577*this.getWidth()/1462 & e.getX()<885*this.getWidth()/1462 & e.getY()>241*this.getHeight()/916 & e.getY()<311*this.getHeight()/916) {
				((BoutiqueView) this.getParent()).getCl().show((BoutiqueView) this.getParent(), "insecteShop");
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
