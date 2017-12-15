package IHMPackage;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class View extends JPanel{
	private static final long serialVersionUID = 5357544026259177499L;
	protected CardLayout cl = null;
	protected TerrariumView tera;
	protected BoutiqueView shop;
	protected InventaireView inventaireView;
	
	public View(TerrariumView tera, BoutiqueView shop, InventaireView inventaireView) {
		this.tera = tera;
		this.shop = shop;
		this.inventaireView = inventaireView;
		cl = new CardLayout();
		setLayout(cl);
		
		//Add the two view with Terrarium first
		
		this.add(tera, "tera");
		this.add(shop, "shop");
		this.add(inventaireView, "inventaireView");
	}
	
	//Show the boutique
	
	public void boutiqueView() {
		shop.nbPage=0;
		shop.getCl().show(shop, "mainShop");
		cl.show(this, "shop");
	}
	
	//Show the terrarium
	
	public void TeraView() {
		cl.show(this, "tera");
	}
	
	public void invView() {
		inventaireView.getCl().show(inventaireView, "main");
		cl.show(this, "inventaireView");
	}
}
