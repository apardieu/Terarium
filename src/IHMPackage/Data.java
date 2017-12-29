package IHMPackage;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainPackage.Variables;

public class Data extends JPanel{
	private static final long serialVersionUID = -8153420072559073398L;
	private JLabel contenantLabel = null;
	private JLabel tempsLabel = null;
	private JLabel argentLabel = null;
	
	public Data() {
		contenantLabel = new JLabel("Nombre d'individus/Capacité :");
		tempsLabel = new JLabel("Temps: ");
		argentLabel = new JLabel("Argent: ");
		
		//GridBagLayout is used to place the buttons
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10, 10, 10, 0);
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.weightx = 0.3;
		add(getContenantLabel(), gbc);
		
		gbc.gridx = 1;
		add(getTempsLabel(), gbc);
		
		gbc.gridx = 2;
		add(getArgentLabel(), gbc);
	}
	
	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
			g.drawImage(ImageIO.read(new File(Variables.FONDSPATH + "donnes.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
			g.fillRect(0, 0, this.getWidth(), 7);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public JLabel getContenantLabel() {
		return contenantLabel;
	}

	public JLabel getTempsLabel() {
		return tempsLabel;
	}

	public JLabel getArgentLabel() {
		return argentLabel;
	}
}