package IHMPackage;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoutiqueView extends JPanel{

	protected void paintComponent(Graphics g) {
        super.paintComponent(g);
            try {
				g.drawImage(ImageIO.read(new File("boutique.jpg")), 0, 0, this.getWidth(), this.getHeight(), null);
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}
