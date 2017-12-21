package IHMPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Border extends JPanel{
	private static final long serialVersionUID = -2252455145201448815L;
	private ImageButton exitButton = null;
	private ImageButton optionButton = null;
	private JButton printInventaire = null;
	private JButton printBoutique = null;
	private PreviewTerrarium previewTera = null;
	private ImageButton nextTerraButton = null;
	private ImageButton prevTerraButton = null;
	
	public Border(PreviewTerrarium previewTera){
		this.previewTera = previewTera;
		exitButton = new ImageButton("exit.png", 0, 0, 30, 30, false);
		optionButton = new ImageButton("option.png", 0, 0, 30, 30, false);
		printInventaire = new JButton("Inventaire");
		setPrintBoutique(new JButton("Boutique"));
		nextTerraButton = new ImageButton("nextTerrarium.png", 0, 0, 100, 30, false);
		prevTerraButton = new ImageButton("prevTerrarium.png", 0, 0, 100, 30, false);
		
		//GridBagLayout is used to place the buttons
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();	
		
		gbc.gridx = gbc.gridy = 0;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.BASELINE_TRAILING;
		gbc.insets = new Insets(10,10, 10, 10);
		add(optionButton, gbc);
		
		gbc.gridx = 1;	
		gbc.weightx = 0;
		add(exitButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.weightx = 0.5;
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.LINE_START;
		gbc.insets = new Insets(50, 20, 0, 0);
		add(prevTerraButton, gbc);
		
		gbc.gridx = 1;
		gbc.insets = new Insets(50, 20, 0, 20);
		gbc.anchor = GridBagConstraints.LINE_END;
		add(nextTerraButton, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 2;
		gbc.weighty = 0.3;
		gbc.weightx = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(20, 20, 90, 20);
		add(previewTera, gbc);
		
		gbc.gridy = 1;
		gbc.weighty = 0.2;
		gbc.insets = new Insets(50, 20, 50, 20);
		add(printInventaire, gbc);
		
		gbc.gridy = 2;
		add(getPrintBoutique(), gbc);
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

	public ImageButton getExitButton() {
		return exitButton;
	}

	public ImageButton getOptionButton() {
		return optionButton;
	}
}