package IHMPackage;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import MainPackage.Variables;

public class ImageButton extends JPanel{
	private static final long serialVersionUID = -5208419355329885260L;
	private JButton button;
	private String image;
	private int largeur;
	private int hauteur;
	private boolean locked = false;
	private boolean unlocked = true;
	private MouseListener mL = null;
	private ActionListener aL = null;
	
	public ImageButton(String image, int x, int y, int largeur, int hauteur, boolean mouseOn) {
		this.image = Variables.BOUTONSPATH + image;
		this.largeur = largeur;
		this.hauteur = hauteur;
		button = new JButton(resizeImage());
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		button.setSize(largeur, hauteur);
		button.setMaximumSize(button.getSize());
		if(mouseOn) {
			mL = new MouseOn();
			button.addMouseListener(mL);
		}
		this.setSize(largeur + 15, hauteur + 15);
		this.add(button);
		this.setLocation(x, y);
		this.setOpaque(false);
	}
	
	private Icon resizeImage(){
		ImageIcon imageIcon = new ImageIcon(image); // load the image to a imageIcon
		Image image2 = imageIcon.getImage(); // transform it 
		Image newimg = image2.getScaledInstance(largeur, hauteur,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		imageIcon = new ImageIcon(newimg);  // transform it back
	    return (Icon) imageIcon;
	}
	
	public void addActionListener(ActionListener l) {
		aL = l;
		button.addActionListener(aL);
	}

	public String getImage() {
		return image;
	}
	
	public void update() {
		button.setIcon(resizeImage());
	}
	
	public void lock() {
		if(unlocked) {
			String extension = image.substring(image.indexOf("."));
			image = image.replaceFirst("Light" + extension, extension);
			image = image.replaceFirst(extension, "Locked" + extension);
			button.setIcon(resizeImage());
			button.removeMouseListener(mL);
			button.removeActionListener(aL);
			button.revalidate();
			unlocked = !(locked = true);
		}
	}
	
	public void unlock() {
		if(locked) {
			String extension = image.substring(image.indexOf("."));
			image = image.replaceFirst("Light" + extension, extension);
			image = image.replaceFirst("Locked" + extension, extension);
			button.setIcon(resizeImage());
			button.addMouseListener(mL);
			button.addActionListener(aL);
			button.revalidate();
			locked = !(unlocked = true);
		}
	}
	
	class MouseOn implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			String extension = image.substring(image.indexOf("."));
			image = image.replaceFirst(extension, "Light" + extension);
			button.setIcon(resizeImage());
			button.revalidate();
		}

		@Override
		public void mouseExited(MouseEvent e) {
			String extension = image.substring(image.indexOf("."));
			image = image.replaceFirst("Light" + extension, extension);
			button.setIcon(resizeImage());
			button.revalidate();
		}
	}
}
