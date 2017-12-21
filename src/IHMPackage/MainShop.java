package IHMPackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MainShop extends JPanel{
	private static final long serialVersionUID = -1758625270358921797L;
	private ImageButton insectesBoutton = null;
	private ImageButton soinsBoutton = null;
	private ImageButton nourritureBoutton = null;
	private ImageButton terrariumsBoutton = null;
	private String type;
	public static final String BOUTIQUE = "Shop";
	public static final String INVENTAIRE = "Inventaire";
	
	public MainShop(String type) {
		this.type = type;
		this.setLayout(null);
		insectesBoutton = new ImageButton("insectesBoutton.png", 480, 200, 430, 100, true);
		insectesBoutton.addActionListener(new ButtonInsectes());
		this.add(insectesBoutton);
		soinsBoutton = new ImageButton("soinsBoutton.png", 480 , 350, 430, 100, true);
		soinsBoutton.addActionListener(new ButtonSoins());
		this.add(soinsBoutton);
		nourritureBoutton = new ImageButton("nourritureBoutton.png", 480, 500, 430, 100, true);
		nourritureBoutton.addActionListener(new ButtonNourriture());
		this.add(nourritureBoutton);
		terrariumsBoutton = new ImageButton("terrariumsBoutton.png", 480, 650, 430, 100, true);
		terrariumsBoutton.addActionListener(new ButtonTerrariums());
		this.add(terrariumsBoutton);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
			g.drawImage(ImageIO.read(new File("main" + type + ".jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
        insectesBoutton.update();
	}
	
	class ButtonInsectes implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getParent() instanceof BoutiqueView)
					((BoutiqueView) getParent()).getCl().show((BoutiqueView) getParent(), "insecteShop");
				if(getParent() instanceof InventaireView)
					((InventaireView) getParent()).getCl().show((InventaireView) getParent(), "insecteInventaire");
			}
		}
	
	class ButtonSoins implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(getParent() instanceof BoutiqueView)
					((BoutiqueView) getParent()).getCl().show((BoutiqueView) getParent(), "soinsShop");
				if(getParent() instanceof InventaireView)
					((InventaireView) getParent()).getCl().show((InventaireView) getParent(), "soinsInventaire");
			}
		}
	
	class ButtonNourriture implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(getParent() instanceof BoutiqueView)
				((BoutiqueView) getParent()).getCl().show((BoutiqueView) getParent(), "soinsShop");
			if(getParent() instanceof InventaireView)
				((InventaireView) getParent()).getCl().show((InventaireView) getParent(), "soinsInventaire");
		}
	}
	
	class ButtonTerrariums implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(getParent() instanceof BoutiqueView)
				((BoutiqueView) getParent()).getCl().show((BoutiqueView) getParent(), "Shop");
			if(getParent() instanceof InventaireView)
				((InventaireView) getParent()).getCl().show((InventaireView) getParent(), "soinsInventaire");
		}
	}
}
