package IHMPackage;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Data extends JPanel{
	private JLabel contenantLabel = null;
	private JLabel tempsLabel = null;
	private JLabel argentLabel = null;
	
	public Data() {
		contenantLabel = new JLabel("Nombre d'individus/Capacité :");
		tempsLabel = new JLabel("Temps: ");
		argentLabel = new JLabel("Argent: ");
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.weightx = 0.3;
		add(contenantLabel, gbc);
		
		gbc.gridx = 1;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		add(tempsLabel, gbc);
		
		gbc.gridx = 2;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		add(argentLabel, gbc);
	}
}