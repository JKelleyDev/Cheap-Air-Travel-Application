package application;

public class MealOptions
{
	private Traveler traveler;
	private String name;
	private int calories;
	private double price;
	
	public MealOptions(Traveler traveler, String name, int calories, double price)
	{ 
		this.traveler = traveler; 
		this.name = name;
		this.calories =calories;
		this.price = price;
	}
	
	public String getMealName() 
	{
		return name;
	}
	 
	public int getMealCalories() 
	{
		return calories;
	}
	 
	public double getMealPrice()
	 {
		return price;
	 }
	 
}



