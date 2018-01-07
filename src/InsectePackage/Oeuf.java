package InsectePackage;

import java.io.File;

import MainPackage.Variables;

public class Oeuf extends Insecte
{
	private Insecte typeIns;
	private Insecte insecteNait;
	private int tempsVecu;
	
	
	public Oeuf(Insecte t)
	{
		this.image = new File(Variables.INSECTESPATH + "oeuf.png");
		this.typeIns=t;
		this.setSexe(Sexe.NOGENDER);
		this.tempsVecu=0;
		this.hTerra=70;
		this.lTerra=50;
		this.imageDroite=new File(Variables.INSECTESPATH + "oeuf.png");
		this.imageGauche=new File(Variables.INSECTESPATH + "oeuf.png");
		this.speedMove=0;
		this.xTerra=t.getxTerra();
		this.yTerra=916-70;
		this.foodLevel=100000;
		this.typeIns=t;
		this.name="Enfant de "+t.getName();
		this.insecteNait = (Insecte) t.clone();
		this.insecteNait.setName(this.getName());
		
		
	}
	
	
	public int getTempsVecu()
	{
		return this.tempsVecu;
	}
	
	public Insecte getinstype()
	{
		return this.typeIns;
	}
	
	public Insecte getInsecteNait()
	{
		return this.insecteNait;
	}
	
	public void increasetemps()
	{
		this.tempsVecu++;
	}
	public void settypeins(Insecte t)
	{
		this.typeIns=t;
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
