package IHMPackage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import InsectePackage.Insecte;
import InsectePackage.Sexe;
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
            synchronized(terarium.getListeInsecte()) {
            for(Insecte ins : terarium.getListeInsecte()) 
            {
            	if((ins.getX()+ins.getLargeur())*this.getWidth()/809 >= this.getWidth())
            		ins.setDirection(-1);
            	else if(ins.getX() <= 0)
            		ins.setDirection(1);
            	if(ins instanceof Herbivore)
            	{
            	try {
            		ins.setY(this.getHeight()-ins.getHauteur()*this.getHeight()/604);
					g.drawImage(ImageIO.read(new File("resources/carnivore.png")), ins.getX()*this.getWidth()/809, ins.getY(), ins.getLargeur()*this.getWidth()/809, ins.getHauteur()*this.getHeight()/604, null); //changer en getLargeur et getHauteur qui sera défini pour chaque type d'insecte
				} catch (IOException e) {
					e.printStackTrace();
				}
            	}
            	if(ins instanceof Carnivore)
            	{
            		try {
            			ins.setY(this.getHeight()-ins.getHauteur()*this.getHeight()/604);
						g.drawImage(ImageIO.read(new File("resources/carnivore.png")), ins.getX()*this.getWidth()/809, ins.getY(), ins.getLargeur()*this.getWidth()/809, ins.getHauteur()*this.getHeight()/604, null);
					} catch (IOException e) {
						e.printStackTrace();
					}
                	
            	}
            	this.drawHealthBar(ins, g);
            	//if(ins.getSexe()==Sexe.FEMALE)
            		
            }
            }
    }
	
	public void drawHealthBar(Insecte ins, Graphics g)
	{
		int emptyfood = ins.getMaxFoodLevel()-ins.getFoodLevel();
		g.setColor(Color.GREEN);
		g.fillRect(ins.getX()*this.getWidth()/809, ins.getY()-10, ins.getFoodLevel()*ins.getLargeur()*this.getWidth()/809/100,5*this.getHeight()/604);
		g.setColor(Color.RED);
		g.fillRect(ins.getX()*this.getWidth()/809+ins.getFoodLevel()*ins.getLargeur()*this.getWidth()/809/100, ins.getY()-10, emptyfood*this.getWidth()/809*ins.getLargeur()/100,5*this.getHeight()/604);
	}
}