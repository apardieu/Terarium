package IHMPackage;
import java.awt.CardLayout;
import javax.swing.JPanel;
import Objets.Boutique;
import Objets.Objet;

public class BoutiqueView extends JPanel{
	private static final long serialVersionUID = 4502791054000189705L;
	protected Boutique shop;
	protected insecteListeVitrine insecteShop;
	protected TerrariumListeVitrine TerrariumShop;
	protected mainBoutique mainShop;
	protected vitrineBoutique vitrine;
	protected Objet objet;
	protected int nbPage;
	protected CardLayout cl;

	public BoutiqueView(Boutique shop) {
		cl = new CardLayout();
		this.setLayout(cl);
		this.shop = shop;
		mainShop = new mainBoutique();
		insecteShop = new insecteListeVitrine(shop.getListeInsecte());
		TerrariumShop = new TerrariumListeVitrine(shop.getListeTerrarium());
		this.add("mainShop", mainShop);
		this.add("insecteShop", insecteShop);
		this.add("TerrariumShop", TerrariumShop);
		
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
