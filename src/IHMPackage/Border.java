package IHMPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Border extends JPanel{
	private JButton nourrirButton = null;
	private JButton newHButton = null;
	private JButton newCButton = null;
	
	public Border() {
		nourrirButton = new JButton("Nourir");
		newHButton = new JButton("Herbivore");
		newCButton = new JButton("Carnivore");
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weighty = 0.3;
		gbc.weightx = 1;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = new Insets(50, 20, 50, 20);
		add(nourrirButton, gbc);
		
		gbc.gridy = 1;
		add(newHButton, gbc);
		
		gbc.gridy = 2;
		add(newCButton, gbc);
		
		
	}
}