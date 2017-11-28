package IHMPackage;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Border extends JPanel{
	private JButton nourrirButton = null;
	private JButton newHButton = null;
	private JButton newCButton = null;
	
	public Border() {
		nourrirButton = new JButton("Nourir");
		setNewHButton(new JButton("Herbivore"));
		setNewCButton(new JButton("Carnivore"));
		
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
		add(getNewHButton(), gbc);
		
		gbc.gridy = 2;
		add(getNewCButton(), gbc);
		
		
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
}