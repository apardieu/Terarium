package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class Oeuf extends Insecte
{
	private Insecte insecteNait;
	private int tempsVecu;

	public Oeuf(Insecte t)
	{
		this.image = new File(Variables.INSECTESPATH + "oeuf.png");
		this.tempsVecu=0;
		this.hTerra=70;
		this.lTerra=50;
		this.imageDroite=new File(Variables.INSECTESPATH + "oeuf.png");
		this.imageGauche=new File(Variables.INSECTESPATH + "oeuf.png");
		this.speedMove=0;
		this.xTerra=t.getxTerra();
		this.yTerra=Variables.HAUTEUR-hTerra;
		this.foodLevel=100000;
		this.name="Enfant de "+t.getName();
		this.insecteNait = (Insecte) t.clone();
		this.insecteNait.setName(this.getName());	
	}
	
	public int getTempsVecu()
	{
		return this.tempsVecu;
	}
	
	public Insecte getInsecteNait()
	{
		return this.insecteNait;
	}
	
	public void increasetemps()
	{
		this.tempsVecu++;
	}
	
	public boolean eclore()
	{
		if(tempsVecu>1000)
		{
			return true;
		}
		return false;
	}
	





}
