package IHMPackage;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class View extends JPanel{
	private static final long serialVersionUID = 5357544026259177499L;
	protected boolean insecteShop = false;
	protected boolean mainShop = true;
	protected CardLayout cl = null;
	protected TerariumView tera;
	protected BoutiqueView shop;
	
	public View(TerariumView tera, BoutiqueView shop) {
		this.tera = tera;
		this.shop = shop;
		cl = new CardLayout();
		setLayout(cl);
		
		//Add the two view with Terrarium first
		
		this.add(tera, "tera");
		this.add(shop, "shop");
	}
	
	//Show the boutique
	
	public void boutiqueView() {
		shop.nbPage=0;
		cl.last(this);
	}
	
	//Show the terrarium
	
	public void TeraView() {
		cl.first(this);
	}
}
