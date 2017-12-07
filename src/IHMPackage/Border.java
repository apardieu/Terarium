package IHMPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Border extends JPanel{
	private static final long serialVersionUID = -2252455145201448815L;
	private JButton nourrirButton = null;
	private JButton newHButton = null;
	private JButton newCButton = null;
	private JButton printBoutique = null;
	
	public Border() {
		nourrirButton = new JButton("Nourir");
		setNewHButton(new JButton("Herbivore"));
		setNewCButton(new JButton("Carnivore"));
		setPrintBoutique(new JButton("Boutique"));
		
		//GridBagLayout is used to place the buttons
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = gbc.gridy = 0;
		gbc.weighty = 0.3;
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(50, 20, 50, 20);
		add(nourrirButton, gbc);
		
		gbc.gridy = 1;
		gbc.weightx = 0.5;
		gbc.gridwidth = 1;
		add(getNewHButton(), gbc);
		
		gbc.gridx = 1;
		add(getNewCButton(), gbc);
		
		gbc.gridy = 2;
		gbc.gridx=0;
		gbc.weightx = 1;
		gbc.gridwidth = 2;
		add(getPrintBoutique(), gbc);
	}

	public JButton getNewHButton() {
		return newHButton;
	}

	public void setNewHButton(JButton newHButton) {
		this.newHButton = newHButton;
	}

	public JButton getNewCButton() {
		return newCButton;
	}

	public void setNewCButton(JButton newCButton) {
		this.newCButton = newCButton;
	}

	public JButton getPrintBoutique() {
		return printBoutique;
	}

	public void setPrintBoutique(JButton printBoutique) {
		this.printBoutique = printBoutique;
	}
}