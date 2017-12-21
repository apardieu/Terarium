package IHMPackage;

import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
	
	public ImageButton(String image, int x, int y, int largeur, int hauteur, boolean mouseOn) {
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
		if(mouseOn)
			button.addMouseListener(new MouseOn());
		this.setSize(largeur + 15, hauteur + 15);
		this.add(button);
		if(x != 0 & y != 0)
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
		button.addActionListener(l);
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public void update() {
		button.setIcon(resizeImage());
	}
	
	public void lock() {
		
	}
	
	public void unlock() {
		
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
