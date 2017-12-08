package IHMPackage;
import java.awt.CardLayout;
import java.io.File;
import javax.swing.JPanel;
import Objets.Boutique;
import Objets.Objet;

public class BoutiqueView extends JPanel{
	private static final long serialVersionUID = 4502791054000189705L;
	protected Boutique shop;
	protected insecteBoutique insecteShop;
	protected mainBoutique mainShop;
	protected vitrineBoutique vitrine;
	protected int nbPage;
	protected boolean next;
	protected boolean prev;
	protected File nextArrow;
	protected File prevArrow;
	protected Objet objet;

	protected CardLayout cl;

	public BoutiqueView(Boutique shop) {
		cl = new CardLayout();
		this.setLayout(cl);
		this.shop = shop;
		mainShop = new mainBoutique(shop);
		insecteShop = new insecteBoutique(shop);
		this.add("mainShop", mainShop);
		this.add("insecteShop", insecteShop);
		
		cl.show(this, "mainShop");
	}
	
	public CardLayout getCl() {
		return cl;
	}

	public void setCl(CardLayout cl) {
		this.cl = cl;
	}
	
	public Objet getObjet() {
		return objet;
	}

	public void setObjet(Objet objet) {
		this.objet = objet;
		vitrine = new vitrineBoutique(shop, objet);
		this.add("vitrine", vitrine);
	}
}
