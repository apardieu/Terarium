package IHMPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import MainPackage.Terarium;

public class View extends JPanel{
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
			BoutiqueView shop = (BoutiqueView) panel;
	        super.paintComponent(g);
	            try {
					g.drawImage(ImageIO.read(new File("boutique.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
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
