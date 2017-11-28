package IHMPackage;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import InsectePackage.Carnivore;
import InsectePackage.Herbivore;
import MainPackage.Terarium;

//Thread AutoRefresh : repaint();

public class IHM extends JFrame{
	private int startTime;
	
	public IHM(Terarium t) {
		startTime = (int)(System.currentTimeMillis()/1000);
		setTitle("Tera Land : The Origins");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(1080, 720));
		
		TerariumView tera = new TerariumView(t);
		Data donnes = new Data();
		Border border = new Border();
		
		tera.setBackground(Color.blue);
		donnes.setBackground(Color.green);
		border.setBackground(Color.black);
		
		border.getNewHButton().addActionListener(new ButtonAddHerbivore(t));
		border.getNewCButton().addActionListener(new ButtonAddCarnivore(t));
		
		class DataRefresh implements Runnable{

			@Override
			public void run() {
				while(true) {
					donnes.getContenantLabel().setText("Nombre d'individus/Capacit� : " + t.getNbInsecte() + "/" + t.getCapacity());
					donnes.getTempsLabel().setText("Temps: " + ((int)(System.currentTimeMillis()/1000) - startTime));
					donnes.getArgentLabel().setText("Argent : " + "0");
				}
			}
			
		}
		
		Thread refreshData = new Thread(new DataRefresh());
		refreshData.start();
		
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
		
		Thread refresh = new Thread(new AutoRefresh());
		refresh.start();
	}
	
	class ButtonAddHerbivore implements ActionListener{
		protected Terarium t;
		
		public ButtonAddHerbivore(Terarium t) {
			this.t= t;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Herbivore h = new Herbivore();
			t.addInsecte(h);
		}
	}
	
	class ButtonAddCarnivore implements ActionListener{
		protected Terarium t;
		
		public ButtonAddCarnivore(Terarium t) {
			this.t= t;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Carnivore c = new Carnivore();
			t.addInsecte(c);
		}
	}
	
	class AutoRefresh implements Runnable{

		@Override
		public void run() {
			while(true)
				repaint();
		}
	}
}
