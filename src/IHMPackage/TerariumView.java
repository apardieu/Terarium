package IHMPackage;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

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
            for(int i=0; i<terarium.getNbInsecte(); i++) {
            	terarium.getListeInsecte().get(i).setY(this.getHeight()-terarium.getListeInsecte().get(i).getHauteur());
            	g.fillRect(terarium.getListeInsecte().get(i).getX(), terarium.getListeInsecte().get(i).getY(), terarium.getListeInsecte().get(i).getLargeur(), terarium.getListeInsecte().get(i).getHauteur());
            }
    }
}