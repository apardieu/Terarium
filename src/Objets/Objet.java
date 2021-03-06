package Objets;

import java.io.File;

public abstract class Objet{
	protected int price;
	protected File image;
	protected String name;
	protected int xTerra;
	protected int lTerra;
	protected int hTerra;
	protected int yTerra;
	protected int lShop;
	protected int hShop;
	protected int revenu;
	protected boolean vendable;
	
	public Objet() {
		lShop = 120;
		hShop = 193;
		vendable = true;
	}
	
	public boolean isInContactWith(Objet a) {
		if((xTerra+lTerra) >= a.xTerra & xTerra <= (a.xTerra+a.lTerra) & (yTerra+hTerra) >= a.yTerra & yTerra <= (a.yTerra+a.hTerra)) {
			return true;
		}
		else
			return false;
	}

	public File getImage() {
		return image;
	}

	public void setImage(File image) {
		this.image = image;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getlShop() {
		return lShop;
	}

	public void setlShop(int lShop) {
		this.lShop = lShop;
	}

	public int gethShop() {
		return hShop;
	}

	public void sethShop(int hShop) {
		this.hShop = hShop;
	}
	public String getName() {
		return name;
	}

	public int getxTerra() {
		return xTerra;
	}

	public void setxTerra(int xTerra) {
		this.xTerra = xTerra;
	}

	public int getlTerra() {
		return lTerra;
	}

	public void setlTerra(int lTerra) {
		this.lTerra = lTerra;
	}

	public int gethTerra() {
		return hTerra;
	}

	public void sethTerra(int hTerra) {
		this.hTerra = hTerra;
	}

	public int getyTerra() {
		return yTerra;
	}

	public void setyTerra(int yTerra) {
		this.yTerra = yTerra;
	}
	
	public void setName(String name)
	{
		this.name=name;
	}

	public int getRevenu() {
		return revenu;
	}

	public void setRevenu(int revenu) {
		this.revenu = revenu;
	}
}