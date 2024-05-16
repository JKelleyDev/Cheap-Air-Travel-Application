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
* 
* This class stores the information about a traveler.
* 
*/
public class Traveler 
{
	private String firstName; // A Traveler has-a firstName
	private String middleName; // A Taveler has-a middleName
	private String lastName; // A Taveler has-a lastName
	private String dob; // A Taveler has-a dob 
	private String gender; // A Taveler has-a gender
	private String email; // A Taveler has-a email
	private String phoneNumber; // A Taveler has-a phone number
	private Option option; // A Taveler has-a set of options
 
	/**
	 * sets the date of birth (DOB) for the traveler.
	 * 
	 * @param dob The date of birth to set.
	 */
	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	
	/**
	 * sets the email address for the traveler.
	 * 
	 * @param email The email address to set.
	 */
	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	/**
	 * sets the gender for the traveler.
	 * 
	 * @param gender The gender to set.
	 */
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	/**
	 * sets the phone number for the traveler.
	 * 
	 * @param phoneNumber The phone number to set.
	 */
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * sets the first name for the traveler.
	 * 
	 * @param firstName The first name to set.
	 */
	public void setFirstName(String firstName)
	{ 
		this.firstName = (firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase());
	}
	
	/**
	 * sets the middle name for the traveler.
	 * 
	 * @param middleName The middle name to set.
	 */
	public void setMiddleName(String middleName)
	{
		this.middleName = (middleName.substring(0, 1).toUpperCase() + middleName.substring(1).toLowerCase());
	}
	
	/**
	 * sets the last name for the traveler.
	 * 
	 * @param lastName The last name to set.
	 */
	public void setLastName(String lastName) 
	{
		this.lastName = (lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase());
	}
	
	/**
	 * sets the options chosen by the traveler.
	 * 
	 * @param option The options to set.
	 */
	public void setOptions(Option option)
	{
		this.option = option;
	}
	
	/**
	 * returns the options chosen by the traveler.
	 * 
	 * @return The options chosen by the traveler.
	 */
	public Option getOptions()
	{ 
		return option;
	}
	
	/**
	 * returns the full name of the traveler.
	 * 
	 * @return The full name of the traveler.
	 */
	public String returnFullName() 
	{ 
		return firstName + " " + middleName.charAt(0) + ". " + lastName; 
	}
	
	/**
	 * Overrides the toString method to return a string representation of the Traveler object.
	 * 
	 * @return A string representation of the Traveler object.
	 */
	 @Override
	    public String toString() 
	 	{
	        return firstName + " " + middleName.charAt(0) + ". " + lastName +
	        	   "\n  DOB: " + dob + 
	        	   "\n  Gender: " + gender + 
	        	   "\n  Phone Number: " + phoneNumber +
	        	   "\n  Email: " + email + 
	        	   "\n  Carry On Bag: "  + option.getCarryOnStatus() + 
	        	   "\n  Checked Bag: " + option.getCheckedBagStatus() + 
	        	   "\n  Wifi: " + option.getWifiStatus() + 
	        	   "\n  Meal: " + option.getMeal() +
	        	   "\n  Assistance: " + option.getAssistanceStatus(); 
		
	    }
	
}