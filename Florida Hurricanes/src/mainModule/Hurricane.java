package mainModule;

public class Hurricane {
	private String stormName;
	private int intCategory;
	private int intMM;
	private int intDD;
	private int intYYYY;
	
	
	//Hurricane::Hurricane
	//Constructor
	public Hurricane(String stName, int intCat, int intMonth, int intDay, int intYear) 
	{
		this.stormName = stName;
		this.intCategory = intCat;
		this.intMM = intMonth;
		this.intDD = intDay;
		this.intYYYY = intYear;
	}

	public String getStormName()
	{
		return stormName;
	}
	
	public int getCat()
	{
		return intCategory ;
	}
	
	public int getMM()
	{
		return intMM;
	}
	
	public int getDD()
	{
		return intDD;
	}
	
	public int getYYYY()
	{
		return intYYYY;
	}

	

}
