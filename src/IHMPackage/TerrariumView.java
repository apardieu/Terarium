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
	private Terrarium Terrarium;
	
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
			g.drawImage(ImageIO.read(Terrarium.getMangeoire().getImage()), (int) (Terrarium.getMangeoire().getxTerra()*eL), (int) (Terrarium.getMangeoire().getyTerra()*eH), (int) (Terrarium.getMangeoire().getlTerra()*eL), (int) (Terrarium.getMangeoire().gethTerra()*eH), null);
        } catch (IOException e) {
			e.printStackTrace();
		}
        
        //Paint each insect of the terrarium
        
        for(Insecte ins : Terrarium.getListeInsecte()) 
        {
        	try {
				g.drawImage(ImageIO.read(ins.getImage()),(int) (ins.getxTerra()*eL), (int) (ins.getyTerra()*eH),(int) (ins.getlTerra()*eL),(int) (ins.gethTerra()*eH), null);
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
		g.fillRect((int) (ins.getxTerra()*eL), (int) ((ins.getyTerra()-10)*eH),(int) (ins.getFoodLevel()*ins.getlTerra()*eL/ins.getMaxFoodLevel()),(int) (5*eH));
		g.setColor(Color.RED);
		g.fillRect((int) (ins.getxTerra()*eL+ins.getFoodLevel()*ins.getlTerra()*eL/ins.getMaxFoodLevel()), (int) ((ins.getyTerra()-10)*eH), (int) (emptyfood*eL*ins.getlTerra()/ins.getMaxFoodLevel()),(int) (5*eH));
	}
	
	public void update(Terrarium tera) {
		this.Terrarium=tera;
		this.Terrarium.getMangeoire().updateImage();
	}
}