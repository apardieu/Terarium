package IHMPackage;
import java.awt.CardLayout;
import javax.swing.JPanel;

public class View extends JPanel{
	private static final long serialVersionUID = 5357544026259177499L;
	private CardLayout cl = null;
	private CardView shop;
	private CardView inventaireView;
	
	public View(TerrariumView tera, CardView shop, CardView inventaireView, VenteListObjet venteView) {
		this.shop = shop;
		this.inventaireView = inventaireView;
		cl = new CardLayout();
		setLayout(cl);
		
		//Add the two view with Terrarium first
		
		this.add(tera, "tera");
		this.add(shop, "shop");
		this.add(inventaireView, "inventaireView");
		this.add(venteView, "venteView");
	}
	
	//Show the boutique
	
	public void boutiqueView() {
		shop.getCl().show(shop, "main");
		cl.show(this, "shop");
	}
	
	//Show the terrarium
	
	public void TeraView() {
		cl.show(this, "tera");
	}
	
	public void venteView() {
		cl.show(this, "venteView");
	}
	
	public void invView() {
		inventaireView.getCl().show(inventaireView, "main");
		cl.show(this, "inventaireView");
	}
}
