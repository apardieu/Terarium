package IHMPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import InsectePackage.Insecte;
import MainPackage.Terarium;

public class TerariumView extends JPanel{
	private static final long serialVersionUID = -8916755259904328022L;
	protected Terarium terarium;
	
	public TerariumView(Terarium tera) {
		terarium = tera;
		this.setLayout(null);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        float echelleLargeur = (float) (((double) this.getWidth())/809);
        float echelleHauteur = (float) (((double) this.getHeight())/604);

        //Paint the background
        try {
			g.drawImage(ImageIO.read(terarium.getImage()), 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //Paint each insect of the terrarium
        
        synchronized(terarium.getListeInsecte()) {
	        for(Insecte ins : terarium.getListeInsecte()) 
	        {
	        	try {
	        		ins.setSize(echelleLargeur, echelleHauteur);
	        		ins.setY((int) (this.getHeight()-ins.getHauteur()*echelleHauteur));
					g.drawImage(ImageIO.read(ins.getImage()), ins.getX(), ins.getY(), ins.getLargeur(), ins.getHauteur(), null); //changer en getLargeur et getHauteur qui sera d�fini pour chaque type d'insecte
				} catch (IOException e) {
					e.printStackTrace(); 
				}
	        	this.drawHealthBar(ins, g);
	        }
        }
    }
	
	//Paint the Health bar at the top of the insect
	
	public void drawHealthBar(Insecte ins, Graphics g)
	{
		int emptyfood = ins.getMaxFoodLevel()-ins.getFoodLevel();
		g.setColor(Color.GREEN);
		g.fillRect(ins.getX()*this.getWidth()/809, ins.getY()-10, ins.getFoodLevel()/100*ins.getLargeur()*this.getWidth()/809/1000,5*this.getHeight()/604);
		g.setColor(Color.RED);
		g.fillRect(ins.getX()*this.getWidth()/809+ins.getFoodLevel()/100*ins.getLargeur()*this.getWidth()/809/1000, ins.getY()-10, emptyfood*this.getWidth()/809*ins.getLargeur()/ins.getMaxFoodLevel(),5*this.getHeight()/604);
	}
}