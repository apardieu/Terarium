package IHMPackage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import MainPackage.Terarium;

public class IHM extends JFrame{
	
	public IHM(Terarium t) {
		setTitle("Tera Land : The Origins");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1080, 720));
		
		TerariumView tera = new TerariumView(t);
		Data donnes = new Data();
		Border border = new Border();
		
		tera.setBackground(Color.blue);
		donnes.setBackground(Color.green);
		border.setBackground(Color.black);
		
		GridBagLayout gbl = new GridBagLayout();
		Container container = getContentPane();
		container.setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = gbc.gridy = 0;
		gbc.weightx = 0.8;
		gbc.weighty = 0.95;
		gbc.anchor = GridBagConstraints.PAGE_START;
		gbc.fill = GridBagConstraints.BOTH;
		container.add(tera, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.8;
		gbc.weighty = 0.05;
		gbc.anchor = GridBagConstraints.LAST_LINE_START;
		gbc.fill = GridBagConstraints.BOTH;
		container.add(donnes, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.gridheight = 2;
		gbc.weightx = 0.2;
		gbc.weighty = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		gbc.fill = GridBagConstraints.BOTH;
		container.add(border, gbc);
		
		setLocationRelativeTo(null);
		setVisible(true);
	}
}
