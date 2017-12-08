package IHMPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import InsectePackage.Insecte;
import MainPackage.Terarium;
import MainPackage.Variables;

public class TerariumView extends JPanel{
	private static final long serialVersionUID = -8916755259904328022L;
	protected Terarium terarium;
	
	public TerariumView(Terarium tera) {
		terarium = tera;
		this.setLayout(null);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        float eL = (float) (((double) this.getWidth())/Variables.LARGEUR); //Echelle largeur
        float eH = (float) (((double) this.getHeight())/Variables.HAUTEUR); //Echelle Hauteur

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
	        		ins.setY((int) (this.getHeight()-ins.getHauteur()*eH));
					g.drawImage(ImageIO.read(ins.getImage()),(int) (ins.getX()*eL), ins.getY(),(int) (ins.getLargeur()*eL),(int) (ins.getHauteur()*eH), null);
				} catch (IOException e) {
					e.printStackTrace(); 
				}
	        	this.drawHealthBar(ins, g, eL, eH);
	        }
        }
    }
	
	//Paint the Health bar at the top of the insect
	
	public void drawHealthBar(Insecte ins, Graphics g, float eL, float eH)
	{
		int emptyfood = ins.getMaxFoodLevel()-ins.getFoodLevel();
		g.setColor(Color.GREEN);
		g.fillRect((int) (ins.getX()*eL), ins.getY()-10,(int) (ins.getFoodLevel()*ins.getLargeur()*eL/ins.getMaxFoodLevel()),(int) (5*eH));
		g.setColor(Color.RED);
		g.fillRect((int) (ins.getX()*eL+ins.getFoodLevel()*ins.getLargeur()*eL/ins.getMaxFoodLevel()), ins.getY()-10, (int) (emptyfood*eL*ins.getLargeur()/ins.getMaxFoodLevel()),(int) (5*eH));
	}
}