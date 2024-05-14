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
*/
public class Traveler 
{
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String gender;
	private String email;
	private String phoneNumber;
	private Option option;


	public void setDob(String dob) 
	{
		this.dob = dob;
	}
	
	public void setEmail(String email) 
	{
		this.email = email;
	}
		
	public void setGender(String gender) 
	{
		this.gender = gender;
	}
	
	public void setPhoneNumber(String phoneNumber) 
	{
		this.phoneNumber = phoneNumber;
	}

	public void setFirstName(String firstName)
	{ 
		this.firstName = (firstName.substring(0, 1).toUpperCase() + firstName.substring(1).toLowerCase());
	}
	
	public void setMiddleName(String middleName)
	{
		this.middleName = (middleName.substring(0, 1).toUpperCase() + middleName.substring(1).toLowerCase());
	}
	public void setLastName(String lastName) 
	{
		this.lastName = (lastName.substring(0, 1).toUpperCase() + lastName.substring(1).toLowerCase());
	}
	
	public void setOptions(Option option)
	{
		this.option = option;
	}
	
	public Option getOptions()
	{ 
		return option;
	}
	
	public String returnFullName() 
	{ 
		return firstName + " " + middleName.charAt(0) + ". " + lastName; 
	}
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