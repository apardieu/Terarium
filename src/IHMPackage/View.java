package IHMPackage;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import InsectePackage.Insecte;
import MainPackage.Terarium;
import Objets.Boutique;
import Objets.Objet;

public class View extends JPanel{
	private static final long serialVersionUID = 5357544026259177499L;
	protected JPanel panel;
	
	public View() {
		this.setLayout(null);
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
	            try {
					g.drawImage(ImageIO.read(new File("boutique.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
				} catch (IOException e) {
					e.printStackTrace();
				}
	            int x=75, y=110;
	            int h=80, l=60;
	            int j=0;
	            for(int i=j; i<shop.getListeInsecte().size(); i++) {
	            	if(i<j+21) {
		            	Objet o = shop.getListeInsecte().get(i);
		            	try {
		            		g.setColor(Color.BLACK);
		            		g.fillRect((x-15)*this.getWidth()/809, (y-15)*this.getHeight()/604, (l+30)*this.getWidth()/809, (h+30)*this.getHeight()/604);
		            		g.setColor(Color.WHITE);
		            		g.fillRect((x-10)*this.getWidth()/809, (y-10)*this.getHeight()/604, (l+20)*this.getWidth()/809, (h+20)*this.getHeight()/604);
		            		g.drawImage(ImageIO.read(o.getInsecte().getImage()), x*this.getWidth()/809, y*this.getHeight()/604,l*this.getWidth()/809, h*this.getHeight()/604, null);
		            		g.setColor(Color.BLACK);
		            		g.setFont(new Font("Dialog", Font.BOLD, 15*this.getWidth()/809));
		            		g.drawString("Price : " + o.getPrice(), (x-15)*this.getWidth()/809, (y+h+30)*this.getHeight()/604);
						} catch (IOException e) {
							e.printStackTrace();
						}
		            	if((x+l+25+l+30)*this.getWidth()/809>this.getWidth()) {
		            		x=75;
		            		y+=h+60;
		            	}
		            	else
		            		x+=l+40;
	            	}
	            }
	            try {
					g.drawImage(ImageIO.read(new File("nextArrow.png")), 700*this.getWidth()/809, 525*this.getHeight()/604, 60*this.getWidth()/809, 60*this.getHeight()/604, null);
				} catch (IOException e) {
					e.printStackTrace();
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
}
