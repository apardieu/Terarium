package IHMPackage;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ImageButton extends JPanel{
	private static final long serialVersionUID = -5208419355329885260L;
	protected JButton button;
	protected String image;
	protected int x;
	protected int y;
	protected int largeur;
	protected int hauteur;
	
	public ImageButton(String image, int x, int y, int largeur, int hauteur) {
		this.image = image;
		this.x = x;
		this.y = y;
		this.largeur = largeur;
		this.hauteur = hauteur;
		button = new JButton(resizeImage());
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setSize(largeur, hauteur);
		button.setMaximumSize(button.getSize());
		this.setSize(button.getSize());
		this.setMaximumSize(this.getSize());
		if(x != 0 & y != 0)
			this.setLocation(x, y);
		this.add(button);
		this.setOpaque(false);
	}
	
	private Icon resizeImage(){
		ImageIcon imageIcon = new ImageIcon(image); // load the image to a imageIcon
		Image image2 = imageIcon.getImage(); // transform it 
		Image newimg = image2.getScaledInstance(largeur, hauteur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
	    return (Icon) imageIcon;
	}
	
	public JButton getButton() {
		return button;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
