package IHMPackage;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import MainPackage.Variables;

public class Border extends JPanel{
	private static final long serialVersionUID = -2252455145201448815L;
	private ImageButton exitButton = null;
	private ImageButton optionButton = null;
	private ImageButton printInventaire = null;
	private ImageButton printBoutique = null;
	private ImageButton printVentes = null;
	private PreviewTerrarium previewTera = null;
	private ImageButton nextTerraButton = null;
	private ImageButton prevTerraButton = null;
	
	public Border(PreviewTerrarium previewTera){
		this.setLayout(null);
		this.previewTera = previewTera;
		exitButton = new ImageButton("exit.png", 420, 0, 30, 30, false);
		optionButton = new ImageButton("option.png", 385, 0, 30, 30, false);
		printInventaire = new ImageButton("inventaireBoutton.png", 30, 250, 400, 100, true);
		printBoutique = new ImageButton("boutiqueBoutton.png", 30, 450, 400, 100, true);
		printVentes = new ImageButton("boutiqueBoutton.png", 30, 50, 400, 100, true);
		nextTerraButton = new ImageButton("nextTerrarium.png", 370, 650, 50, 50, true);
		prevTerraButton = new ImageButton("prevTerrarium.png", 10, 650, 50, 50, true);
		
		this.add(optionButton);
		
		this.add(exitButton);
		
		this.add(prevTerraButton);
		
		this.add(nextTerraButton);
		
		previewTera.setSize(438, 264);
		previewTera.setLocation(10, 716);
		this.add(previewTera);
		
		this.add(printInventaire);
		
		this.add(printBoutique);
		
		this.add(printVentes);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
			g.drawImage(ImageIO.read(new File(Variables.FONDSPATH + "border.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
			g.fillRect(0, 0, 7, 987);
        } catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ImageButton getNextTerraButton() {
		return nextTerraButton;
	}

	public ImageButton getPrevTerraButton() {
		return prevTerraButton;
	}

	public PreviewTerrarium getPreviewTera() {
		return previewTera;
	}

	public ImageButton getPrintInventaire() {
		return printInventaire;
	}

	public ImageButton getPrintBoutique() {
		return printBoutique;
	}

	public ImageButton getExitButton() {
		return exitButton;
	}

	public ImageButton getOptionButton() {
		return optionButton;
	}

	public ImageButton getPrintVentes() {
		return printVentes;
	}
}