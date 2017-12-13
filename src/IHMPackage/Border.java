package IHMPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import MainPackage.Terarium;

public class Border extends JPanel{
	private static final long serialVersionUID = -2252455145201448815L;
	private JButton exitButton = null;
	private JButton printInventaire = null;
	private JButton printBoutique = null;
	private PreviewTerrarium previewTera = null;
	private JButton nextTerraButton = null;
	private JButton prevTerraButton = null;
	
	public Border(PreviewTerrarium previewTera){
		this.previewTera = previewTera;
		exitButton = new JButton("EXIT");
		printInventaire = new JButton("Inventaire");
		setPrintBoutique(new JButton("Boutique"));
		nextTerraButton = new JButton("Next");
		prevTerraButton = new JButton("Previous");
		
		//GridBagLayout is used to place the buttons
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = gbc.gridy = 0;
		gbc.weighty = 0.1;
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(50, 20, 50, 20);
		add(prevTerraButton, gbc);
		
		gbc.gridx = 1;
		add(nextTerraButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.gridwidth = 2;
		gbc.weighty = 0.3;
		gbc.weightx = 1;
		add(previewTera, gbc);
		
		gbc.gridy = 2;
		gbc.weighty = 0.2;
		add(printInventaire, gbc);
		
		gbc.gridy = 3;
		add(getPrintBoutique(), gbc);
	}

	public PreviewTerrarium getPreviewTera() {
		return previewTera;
	}

	public void setPreviewTera(PreviewTerrarium previewTera) {
		this.previewTera = previewTera;
	}

	public JButton getPrintInventaire() {
		return printInventaire;
	}

	public void setPrintInventaire(JButton printInventaire) {
		this.printInventaire = printInventaire;
	}

	public JButton getPrintBoutique() {
		return printBoutique;
	}

	public void setPrintBoutique(JButton printBoutique) {
		this.printBoutique = printBoutique;
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}
}