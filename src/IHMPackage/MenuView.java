package IHMPackage;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import MainPackage.Variables;

enum TypeInventaire {
	BOUTIQUE("Shop"),
	INVENTAIRE("Inventaire");
	
	private String type;
	
	TypeInventaire(String type) {
		this.setType(type);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}


public class MenuView extends JPanel{
	private static final long serialVersionUID = -1758625270358921797L;
	private ImageButton insectesBoutton = null;
	private ImageButton soinsBoutton = null;
	private ImageButton nourritureBoutton = null;
	private ImageButton terrariumsBoutton = null;
	private TypeInventaire type;
	
	public MenuView(TypeInventaire type) {
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
			g.drawImage(ImageIO.read(new File(Variables.FONDSPATH + "main" + type.getType() + ".jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
		} catch (IOException e) {
			e.printStackTrace();
		}
        insectesBoutton.update();
	}
	
	class ButtonInsectes implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardView) getParent()).getCl().show((CardView) getParent(), "insecteInventaire");
			}
		}
	
	class ButtonSoins implements ActionListener{
			
			@Override
			public void actionPerformed(ActionEvent e) {
				((CardView) getParent()).getCl().show((CardView) getParent(), "soinsInventaire");
			}
		}
	
	class ButtonNourriture implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			((CardView) getParent()).getCl().show((CardView) getParent(), "nourritureInventaire");
		}
	}
	
	class ButtonTerrariums implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			((CardView) getParent()).getCl().show((CardView) getParent(), "TerrariumInventaire");
		}
	}
}
