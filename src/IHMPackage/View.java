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
import InsectePackage.Insecte;
import MainPackage.Terarium;
import Objets.Boutique;
import Objets.Objet;

public class View extends JPanel implements MouseListener{
	private static final long serialVersionUID = 5357544026259177499L;
	protected JPanel panel;
	protected int nbPage;
	protected boolean next=true;
	protected boolean prev=false;
	protected File nextArrow;
	protected File prevArrow;
	protected BoutiqueView shopView;
	protected Boutique shop;
	protected boolean insecteShop = false;
	protected boolean mainShop = true;
	private List<Objet> listeInsecte = new LinkedList<Objet>();
	
	
	public View() {
		nbPage=0;
		this.setLayout(null);
		this.addMouseListener(this);
	}
	
	protected void paintComponent(Graphics g) {
		if(panel instanceof TerariumView) {
			TerariumView tera = (TerariumView) panel;
			Terarium terarium = tera.terarium;
	        super.paintComponent(g);
	            try {
	            	g.drawImage(ImageIO.read(terarium.getImage()), 0, 0, this.getWidth(), this.getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
	            synchronized(terarium.getListeInsecte()) {
	            for(Insecte ins : terarium.getListeInsecte()) 
	            {
	            	try {
	            		ins.setY(this.getHeight()-ins.getHauteur()*this.getHeight()/604);
						g.drawImage(ImageIO.read(ins.getImage()), ins.getX()*this.getWidth()/809, ins.getY(), ins.getLargeur()*this.getWidth()/809, ins.getHauteur()*this.getHeight()/604, null); //changer en getLargeur et getHauteur qui sera défini pour chaque type d'insecte
					} catch (IOException e) {
						e.printStackTrace(); 
					}
	            	this.drawHealthBar(ins, g);
	            }
            }
		}
		if(panel instanceof BoutiqueView) {
			BoutiqueView shopView = (BoutiqueView) panel;
			Boutique shop = shopView.shop;
	        super.paintComponent(g);
	        if(mainShop==true) {
	        	try {
					g.drawImage(ImageIO.read(new File("mainShop.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        if(insecteShop==true) {
	            try {
	            	g.drawImage(ImageIO.read(new File("boutique.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
	            	g.drawImage(ImageIO.read(new File("main.png")), 716*this.getWidth()/809, 10*this.getHeight()/604, 65*this.getWidth()/809, 57*this.getHeight()/604, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
	            int x=75, y=110;
	            int h=80, l=60;
	            for(int i=nbPage*21; (i<(nbPage+1)*21 & i<shop.getListeInsecte().size()); i++) {
		            	Objet o = shop.getListeInsecte().get(i);
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
		            	if((x+l+25+l+30)*this.getWidth()/809>this.getWidth()) {
		            		x=75;
		            		y+=h+60;
		            	}
		            	else
		            		x+=l+40;
		            	if(nbPage==shop.getListeInsecte().size()/21) {
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
		            	listeInsecte = shop.getListeInsecte();
	            	}
	            try {
	            	g.drawImage(ImageIO.read(nextArrow), 700*this.getWidth()/809, 525*this.getHeight()/604, 60*this.getWidth()/809, 60*this.getHeight()/604, null);
	            	g.drawImage(ImageIO.read(prevArrow), 40*this.getWidth()/809, 525*this.getHeight()/604, 60*this.getWidth()/809, 60*this.getHeight()/604, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
		}
    }
	
	public void drawHealthBar(Insecte ins, Graphics g)
	{
		int emptyfood = ins.getMaxFoodLevel()-ins.getFoodLevel();
		g.setColor(Color.GREEN);
		g.fillRect(ins.getX()*this.getWidth()/809, ins.getY()-10, ins.getFoodLevel()/100*ins.getLargeur()*this.getWidth()/809/1000,5*this.getHeight()/604);
		g.setColor(Color.RED);
		g.fillRect(ins.getX()*this.getWidth()/809+ins.getFoodLevel()/100*ins.getLargeur()*this.getWidth()/809/1000, ins.getY()-10, emptyfood*this.getWidth()/809*ins.getLargeur()/ins.getMaxFoodLevel(),5*this.getHeight()/604);
	}
	
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	
	public JPanel getPanel() {
		return panel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(insecteShop==true) {
			if(panel instanceof BoutiqueView & next==true) {
				if(e.getX()>700*this.getWidth()/809 & e.getX()<760*this.getWidth()/809 & e.getY()>525*this.getHeight()/604 & e.getY()<585*this.getHeight()/604) {
					nbPage++;
				}
			}
			if(panel instanceof BoutiqueView & prev==true) {
				if(e.getX()>40*this.getWidth()/809 & e.getX()<100*this.getWidth()/809 & e.getY()>525*this.getHeight()/604 & e.getY()<585*this.getHeight()/604) {
					nbPage--;
				}
			}
			if(panel instanceof BoutiqueView) {
				for(int i=nbPage*21; (i<(nbPage+1)*21 & i<listeInsecte.size()); i++) {
					Objet o = listeInsecte.get(i);
					if(e.getX()>o.getxShop() & e.getX()<(o.getxShop()+o.getlShop()) & e.getY()>o.getyShop() & e.getY()<(o.getyShop()+o.gethShop())) {
						System.out.println("Price : " + o.getPrice());
					}
				}
			}
			if(panel instanceof BoutiqueView) {
				if(e.getX()>716*this.getWidth()/809 & e.getX()<781*this.getWidth()/809 & e.getY()>10*this.getHeight()/604 & e.getY()<67*this.getHeight()/604) {
					insecteShop=false;
					mainShop=true;
				}
			}
		}
		if(mainShop==true & panel instanceof BoutiqueView) {
			if(e.getX()>284*this.getWidth()/809 & e.getX()<493*this.getWidth()/809 & e.getY()>132*this.getHeight()/604 & e.getY()<179*this.getHeight()/604) {
				mainShop=false;
				insecteShop=true;
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
