package IHMPackage;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Data extends JPanel{
	private static final long serialVersionUID = -8153420072559073398L;
	private JLabel contenantLabel = null;
	private JLabel tempsLabel = null;
	private JLabel argentLabel = null;
	
	public Data() {
		setContenantLabel(new JLabel("Nombre d'individus/Capacité :"));
		setTempsLabel(new JLabel("Temps: "));
		setArgentLabel(new JLabel("Argent: "));
		
		//GridBagLayout is used to place the buttons
		
		GridBagLayout gbl = new GridBagLayout();
		setLayout(gbl);
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = gbc.gridy = 0;
		gbc.gridheight = 1;
		gbc.gridwidth = 1;
		gbc.insets = new Insets(10, 10, 10, 0);
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		gbc.weightx = 0.3;
		add(getContenantLabel(), gbc);
		
		gbc.gridx = 1;
		add(getTempsLabel(), gbc);
		
		gbc.gridx = 2;
		add(getArgentLabel(), gbc);
	}

	public JLabel getContenantLabel() {
		return contenantLabel;
	}

	public void setContenantLabel(JLabel contenantLabel) {
		this.contenantLabel = contenantLabel;
	}

	public JLabel getTempsLabel() {
		return tempsLabel;
	}

	public void setTempsLabel(JLabel tempsLabel) {
		this.tempsLabel = tempsLabel;
	}

	public JLabel getArgentLabel() {
		return argentLabel;
	}

	public void setArgentLabel(JLabel argentLabel) {
		this.argentLabel = argentLabel;
	}
}