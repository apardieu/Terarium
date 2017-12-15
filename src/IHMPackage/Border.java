package IHMPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

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
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weighty = 0.05;
		gbc.weightx = 0.5;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(50, 20, 0, 0);
		add(prevTerraButton, gbc);
		
		gbc.gridx = 1;
		gbc.insets = new Insets(50, 20, 0, 20);
		add(nextTerraButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 2;
		gbc.weighty = 0.3;
		gbc.weightx = 1;
		gbc.insets = new Insets(20, 20, 90, 20);
		add(previewTera, gbc);
		
		gbc.gridy = 0;
		gbc.weighty = 0.2;
		gbc.insets = new Insets(50, 20, 50, 20);
		add(printInventaire, gbc);
		
		gbc.gridy = 1;
		add(getPrintBoutique(), gbc);
	}

	public JButton getNextTerraButton() {
		return nextTerraButton;
	}

	public void setNextTerraButton(JButton nextTerraButton) {
		this.nextTerraButton = nextTerraButton;
	}

	public JButton getPrevTerraButton() {
		return prevTerraButton;
	}

	public void setPrevTerraButton(JButton prevTerraButton) {
		this.prevTerraButton = prevTerraButton;
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