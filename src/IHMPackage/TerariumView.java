package IHMPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import MainPackage.Terarium;

public class TerariumView extends JPanel{
	protected Terarium terarium;
	
	public TerariumView(Terarium tera) {
		terarium = tera;
		this.setLayout(null);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            try {
				g.drawImage(ImageIO.read(terarium.getImage()), 0, 0, this.getWidth(), this.getHeight(), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
            for(Insecte ins : terarium.getListeInsecte()) 
            {
            	
            	if(ins instanceof Herbivore)
            	{
            	try {
					g.drawImage(ImageIO.read(new File("resources/mouchetest.png")), ins.getX(), ins.getY(), 100,100, null); //changer en getLargeur et getHauteur qui sera défini pour chaque type d'insecte
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	}
            	if(ins instanceof Carnivore)
            	{
            		try {
						g.drawImage(ImageIO.read(new File("resources/carnivore.png")), ins.getX(), ins.getY(), 100,100, null);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            	
            	this.drawHealthBar(ins, g);
            	//terarium.getListeInsecte().get(i).setY(this.getHeight()-terarium.getListeInsecte().get(i).getHauteur());
            	//g.fillRect(terarium.getListeInsecte().get(i).getX(), terarium.getListeInsecte().get(i).getY(), terarium.getListeInsecte().get(i).getLargeur(), terarium.getListeInsecte().get(i).getHauteur());
            }
    }
	
	public void drawHealthBar(Insecte ins, Graphics g)
	{
		int emptyfood = 100-ins.getFoodLevel();
		g.setColor(Color.GREEN);
		g.fillRect(ins.getX(), ins.getY()-10, ins.getFoodLevel(),7);
		g.setColor(Color.RED);
		g.fillRect(ins.getX()+ins.getFoodLevel(), ins.getY()-10, emptyfood,7);
		
		
	}
}