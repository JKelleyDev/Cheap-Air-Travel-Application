package application;

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

	
	///////////////////////////// Getter Methods 
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getMiddleName() 
	{
		return middleName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}
	
	public String getDob() 
	{
		return dob;
	}
	
	public String getGender() 
	{
		return gender;
	}
	
	public String getPhoneNumber() 
	{
		return phoneNumber;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	////////////////////////////// Setter Methods 
	
	
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
		this.firstName = firstName; 
	}
	
	public void setMiddleName(String middleName)
	{
		this.middleName = middleName; 
	}
	public void setLastName(String lastName) 
	{
		this.lastName = lastName;
	}
	
	public void setOptions(Option option)
	{
		this.option = option;
	}
	
	
	 @Override
	    public String toString() 
	 	{
	        return firstName + " " + lastName ;
	    }
	
}