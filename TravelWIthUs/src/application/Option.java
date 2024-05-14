package application;
/**
 * Lead Author(s):
 * 
 * @author Jordan Kelley
 * @author Esteban Naranjo
 *       
 * Other contributors:
 * 
 * References:
 *         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 *         Retrieved from
 *         https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 * 

 * Version/date: 2024.05.24.001
 * 
 * Responsibilities of class:
 * TODO: Type our the responsiblility of the class, look at Application model if you need a reference 
 * 
 */

public class Option 
{
	//TODO: Comment the HAS-A Relationships for each private variable, look at Application Model for example
	private boolean wifi; // Option has a wifi choice of true or false
	private boolean standardMeal;
	@SuppressWarnings("unused")
	private boolean vegetarianMeal;
	private boolean assistance;
	private int checkedBag;
	private int carryOnBag; 
	private ApplicationModel model;

	/** 
	 * Purpose: Creates a Option object which belongs to a traveler, this has a reference to the model to store apppropriate information
	 * @param model
	 */
	public Option(ApplicationModel model) 
	{
		this.model = model; 
		checkedBag = 0; 
		carryOnBag = 0;
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 */
	public void addCheckedBag() 
	{ 
		checkedBag++;  // if adding a checked bag, increase the amount of checked bags by 1
		model.addCheckedBag(); // Increment the total amount of checked bags in the model
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 */
	public void addCarryOnBag() 
	{ 
		carryOnBag++; // if adding a carry on bag, increase the amount of carry on bags by 1 
		model.addCarryOnBag(); // Increment the total amount of carry on bags in the model
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @param
	 */
	public void setWifi(boolean selected) 
	{
		wifi = selected;
		model.addWifiPackage(); // For each travel, want to keep a total amount of wifi charges 
		
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @param 
	 */
	public void setStandardMeal(boolean selected) 
	{
		if(selected) 
		{
			standardMeal = true;
			model.addMealCharge();
		}
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @param
	 */
	public void setMealVegetarian(boolean selected) 
	{
		if(selected)
		{
			vegetarianMeal = true;
			model.addMealCharge(); // For each travel, want to keep a total amount of meal charges
	    }
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @param 
	 */
	public void setAssistance(boolean selected) 
	{
		this.assistance = selected;
		if (selected) 
		{
			model.addAssistance(); // For each travel, want to keep a total amount of assistance charges 
		}
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @return 
	 */
	public int getCarryOnStatus() 
	{ 
		return carryOnBag; 
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 */
	public int getCheckedBagStatus()
	{ 
		return checkedBag; 
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @return 
	 */
	public String getWifiStatus() 
	{ 
		if(wifi == true) 
			return "Yes"; 
		else 
			return "No";
	}
	
	/** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @return 
	 */
    public String getMeal()
    { 
    	if(standardMeal == true)
    		return "Standard Meal"; 
    	else if(vegetarianMeal = true)
    		return "Vegetarian Meal";
    	else 
    		return "No Meal Selected"; 
    }
	
    /** TODO: Comment the purpose and the @return or @param if they exist 
	 * Purpose:
	 * @return 
	 */
	public String getAssistanceStatus() 
	{ 
		if(assistance == true) 
			return "Assistance required"; 
		else 
			return "No Assistance required";
	}
	
	
}
