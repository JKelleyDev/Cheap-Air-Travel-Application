package application;
/**
*
* @author Jordan Kelley
* @author Esteban Naranjo
* 
* @version 2024.05.24.001
* 
* @see
* 	References:<br>
*         Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
*         Retrieved from {@link https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving}
* 
*
* <br><br>
* Responsibilities of class:<br>
* The responsibility of the class is to manage various options or choices related to travel, 
* such as baggage selection, meal preferences, wi-fi, and assistance requirements.
* 
*/

public class Option 
{
	private boolean wifi; // Option has a wifi choice of true or false
	private boolean standardMeal; // Option has a choice for a standard meal.
	@SuppressWarnings("unused")
	private boolean vegetarianMeal; // Option has a choice for a vegetarian meal.
	private boolean assistance; // Option has a choice for assistance.
	private int checkedBag; // Option has a checked bag count.
	private int carryOnBag; //Option has a carry-on bag count.
	private ApplicationModel model; // Option has a refrence to the application model.

	/** 
	 * Purpose: Creates a Option object which belongs to a traveler, 
	 * this has a reference to the model to store appropriate information.
	 * 
	 * @param model this information model to store information.
	 */
	public Option(ApplicationModel model) 
	{
		this.model = model; 
		checkedBag = 0; 
		carryOnBag = 0;
	}
	
	/** 
	 * Purpose: add checked bag and update the model.
	 */
	public void addCheckedBag() 
	{ 
		checkedBag++;  // if adding a checked bag, increase the amount of checked bags by 1
		model.addCheckedBag(); // Increment the total amount of checked bags in the model
	}
	
	/** 
	 * Purpose: add a carry-on bag and updates the model.
	 */
	public void addCarryOnBag() 
	{ 
		carryOnBag++; // if adding a carry on bag, increase the amount of carry on bags by 1 
		model.addCarryOnBag(); // Increment the total amount of carry on bags in the model
	}
	
	/** 
	 * Purpose: select the wi-fi option and update the model
	 * 
	 * @param selected true if the wi-fi is selected, false otherwise.
	 */
	public void setWifi(boolean selected) 
	{
		wifi = selected;
		model.addWifiPackage(); // For each travel, want to keep a total amount of wifi charges 
		
	}
	
	/** 
	 * Purpose: set the standard meal option and update the model.
	 * 
	 * @param selected true if the standard meal is selected, false otherwise.
	 */
	public void setStandardMeal(boolean selected) 
	{
		if(selected) 
		{
			standardMeal = true;
			model.addMealCharge();
		}
	}
	
	/** 
     * Purpose: Sets the vegetarian meal option and updates the model.
     * 
     * @param selected true if the vegetarian meal is selected, false otherwise.
     */
	public void setMealVegetarian(boolean selected) 
	{
		if(selected)
		{
			vegetarianMeal = true;
			model.addMealCharge(); // For each travel, want to keep a total amount of meal charges
	    }
	}
	
	/** 
     * Purpose: sets the assistance option and updates the model.
     * 
     * @param selected true if assistance is selected, false otherwise.
     */
	public void setAssistance(boolean selected) 
	{
		this.assistance = selected;
		if (selected) 
		{
			model.addAssistance(); // For each travel, want to keep a total amount of assistance charges 
		}
	}
	
	 /** 
     * Purpose: retrieves the carry-on bag count.
     * 
     * @return the number of carry-on bags.
     */
	public int getCarryOnStatus() 
	{ 
		return carryOnBag; 
	}
	
	/** 
     * Purpose: retrieves the checked bag count.
     * 
     * @return the number of checked bags.
     */
	public int getCheckedBagStatus()
	{ 
		return checkedBag; 
	}
	
	 /** 
     * Purpose: Retrieves the wifi status.
     * 
     * @return "Yes" if wi-fi is selected, "No" otherwise.
     */
	public String getWifiStatus() 
	{ 
		if(wifi == true) 
			return "Yes"; 
		else 
			return "No";
	}
	
	 /** 
     * Purpose: retrieves the meal selection.
     * 
     * @return the selected meal type or "No Meal Selected".
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
	
    /** 
     * Purpose: retrieves the assistance status.
     * 
     * @return "Assistance required" if assistance is selected, 
     * 			"No Assistance required" otherwise.
     */
	public String getAssistanceStatus() 
	{ 
		if(assistance == true) 
			return "Assistance required"; 
		else 
			return "No Assistance required";
	}
	
	
}
