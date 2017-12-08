package Objets;

import java.io.File;

public abstract class Objet{
	protected int price;
	protected File image;
	protected String name;
	private int xShop;
	private int lShop;
	private int hShop;
	private int yShop;

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

	public int getxShop() {
		return xShop;
	}

	public void setxShop(int xShop) {
		this.xShop = xShop;
	}

	public int getyShop() {
		return yShop;
	}

	public void setyShop(int yShop) {
		this.yShop = yShop;
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

	public void setName(String name) {
		this.name = name;
	}
}