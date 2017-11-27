package IHMPackage;
import java.awt.Graphics;
import javax.swing.JPanel;
import InsectePackage.Insecte;

public class InsecteGraph extends JPanel{
	Insecte insecte = null;
	
	public InsecteGraph(Insecte i) {
		insecte = i;
	}
	
	protected void paintComponent(Graphics g) {
		g.fillRect(insecte.getX(), insecte.getY(), insecte.getLargeur(), insecte.getHauteur());
    }
}
