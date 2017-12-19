package IHMPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import InsectePackage.Insecte;
import MainPackage.Variables;
import Terrariums.Terrarium;

public class TerrariumView extends JPanel{
	private static final long serialVersionUID = -8916755259904328022L;
	protected Terrarium Terrarium;
	
	public TerrariumView(Terrarium tera) {
		Terrarium = tera;
		this.setLayout(null);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        float eL = (float) (((double) this.getWidth())/Variables.LARGEUR); //Echelle largeur
        float eH = (float) (((double) this.getHeight())/Variables.HAUTEUR); //Echelle Hauteur

        //Paint the background
        try {
			g.drawImage(ImageIO.read(Terrarium.getImage()), 0, 0, this.getWidth(), this.getHeight(), null);
			g.drawImage(ImageIO.read(Terrarium.getMangeoire().getImage()), this.getWidth()/2, (int) (this.getHeight()-100*eH), (int) (100*eH), (int) (100*eH), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        //Paint each insect of the terrarium
        
        for(Insecte ins : Terrarium.getListeInsecte()) 
        {
        	try {
        		ins.setY((int) (this.getHeight()-ins.gethTerra()*eH));
				g.drawImage(ImageIO.read(ins.getImage()),(int) (ins.getX()*eL), ins.getY(),(int) (ins.getlTerra()*eL),(int) (ins.gethTerra()*eH), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
        	this.drawHealthBar(ins, g, eL, eH);
        }
    }
	
	//Paint the Health bar at the top of the insect
	
	public void drawHealthBar(Insecte ins, Graphics g, float eL, float eH)
	{
		int emptyfood = ins.getMaxFoodLevel()-ins.getFoodLevel();
		g.setColor(Color.GREEN);
		g.fillRect((int) (ins.getxTerra()*eL), ins.getY()-10,(int) (ins.getFoodLevel()*ins.getlTerra()*eL/ins.getMaxFoodLevel()),(int) (5*eH));
		g.setColor(Color.RED);
		g.fillRect((int) (ins.getX()*eL+ins.getFoodLevel()*ins.getlTerra()*eL/ins.getMaxFoodLevel()), ins.getY()-10, (int) (emptyfood*eL*ins.getlTerra()/ins.getMaxFoodLevel()),(int) (5*eH));
	}
	
	public void update(Terrarium tera) {
		this.Terrarium=tera;
		this.Terrarium.getMangeoire().updateImage();
	}
}