package IHMPackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JTextField;

import MainPackage.Variables;
import Objets.Inventaire;
import Objets.Objet;

public class vitrineBoutique extends JPanel{
	private static final long serialVersionUID = 2525121154772774593L;
	private Objet objet;
	private Inventaire inventaire;
	private File fond = new File(Variables.FONDSPATH + "vitrine.jpg");
	private ImageButton acheterBoutton = null;
	private ImageButton mainBoutton = null;
	private ImageButton goBackBoutton = null;
	private JTextField nameObjet = new JTextField(15);
	private String previousCard;
	
	public vitrineBoutique(Inventaire inventaire, Objet objet, String previousCard) {
		this.setLayout(null);
		this.inventaire = inventaire;
		this.objet = objet;
		this.previousCard = previousCard;
		acheterBoutton = new ImageButton("acheterBoutton.png", 1050, 885, 270, 70, true);
		acheterBoutton.addActionListener(new ButtonAcheter());
		this.add(acheterBoutton);
		mainBoutton = new ImageButton("mainBoutton.png", 1260, 20, 80, 65, false);
		mainBoutton.addActionListener(new ButtonMain());
		this.add(mainBoutton);
		goBackBoutton = new ImageButton("goBackBoutton.png", 35, 25, 75, 60, false);
		goBackBoutton.addActionListener(new ButtonGoBack());
		this.add(goBackBoutton);
		nameObjet.setSize(100, 25);
		nameObjet.setLocation(500, 300);
		this.add(nameObjet);
	}

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    	//Drawing the background of the inventaire and add the main button
    	int x=70, y=150, l=objet.getlShop()*2, h=objet.gethShop()*2;
        try {
        	g.drawImage(ImageIO.read(fond), 0, 0, this.getWidth(), this.getHeight(), null);
        	if(inventaire.getPlayer().getArgent()>=objet.getPrice())
        		acheterBoutton.unlock();
        	else
        		acheterBoutton.lock();
       
        	g.drawImage(ImageIO.read(objet.getImage()), x*this.getWidth()/1462, y*this.getHeight()/916,l*this.getWidth()/1462, h*this.getHeight()/916, null);
        	g.drawString("Nom : " + objet.getName(), 329*this.getWidth()/1462, 150*this.getHeight()/916);
        } catch (IOException e) {
			e.printStackTrace();
		}
    }
	
	class ButtonAcheter implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(nameObjet.getText()!="")
				inventaire.getPlayer().buy(objet, nameObjet.getText());
			else
				inventaire.getPlayer().buy(objet);
		}
	}

	class ButtonMain implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			((CardView) getParent()).getCl().show((CardView) getParent(), "main");
		}
	}
	
	class ButtonGoBack implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			((CardView) getParent()).getCl().show((CardView) getParent(), previousCard);
		}
	}
}
